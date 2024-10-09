package com.ust.Airline.service;

import com.ust.Airline.dto.*;
import com.ust.Airline.model.Airline;
import com.ust.Airline.repo.Airlinerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Airlineserviceimpl implements AirlineService {
    @Autowired
    private Airlinerepo repo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Airline addAirline(Airline airline) {
        return repo.save(airline);
    }

    @Override
    public ResponseDto getAirline(String airlinecode) {
        ResponseDto responseDto = new ResponseDto();
        Airline airline = repo.findByAirlinecode(airlinecode)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        Airlinedto airlineDto = mapToAirline(airline);

        // Fetch flights for the airline
        List<Flightdto> flightDTOList = webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/flights/" + airline.getAirlinecode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Flightdto>>() {})
                .block();

        // Fetch passengers for each flight
        for (Flightdto flightDTO : flightDTOList) {
            List<Passengerdto> passengerDTOList = webClientBuilder.baseUrl("http://localhost:9099")
                    .build()
                    .get()
                    .uri("/passangerinfo/" + flightDTO.getFlightNumber())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Passengerdto>>() {})
                    .block();

            flightDTO.setPassengerdto(passengerDTOList);
        }

        responseDto.setAirline(airlineDto);
        responseDto.setFlight(flightDTOList);

        return responseDto;
    }

    private Airlinedto mapToAirline(Airline airline) {
        Airlinedto dto = new Airlinedto();
        dto.setAirlinename(airline.getAirlinename());
        dto.setAirlinecode(airline.getAirlinecode());
        dto.setCountry(airline.getCountry());
        dto.setHeadquarters(airline.getHeadquarters());
        dto.setCeo(airline.getCeo());
        dto.setFoundedYear(airline.getFoundedYear());
        dto.setHubAirport(airline.getHubAirport());
        dto.setWebsite(airline.getWebsite());
        dto.setFleetSize(airline.getFleetSize());
        return dto;
    }

    public FlightInfoDto getFlightInfo(String flightNumber) {
        // Replace 'xxx' with the actual API URL
        String apiUrl = ("https://api.aviationstack.com/v1/flights?access_key=c42ba0c13e84be129b0b8ba782746497&flight_number=" +flightNumber+ "&limit=1");

        // Use WebClient to fetch data from the external API
        Mono<FlightInfoDto> flightInfoDtoMono = webClientBuilder.baseUrl(apiUrl)
                .build()
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .map(response -> {
                    // Extract the data array
                    List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");

                    if (data.isEmpty()) {
                        return null; // or throw an exception if preferred
                    }

                    // Get the first flight data
                    Map<String, Object> flightData = data.get(0);

                    // Create and populate FlightInfoDto
                    FlightInfoDto flightInfoDto = new FlightInfoDto();
                    flightInfoDto.setFlightDate((String) flightData.get("flight_date"));
                    flightInfoDto.setFlightStatus((String) flightData.get("flight_status"));

                    // Extract departure information
                    Map<String, Object> departure = (Map<String, Object>) flightData.get("departure");
                    flightInfoDto.setDepartureAirport((String) departure.get("airport"));
                    flightInfoDto.setScheduledDeparture((String) departure.get("scheduled"));

                    // Extract arrival information
                    Map<String, Object> arrival = (Map<String, Object>) flightData.get("arrival");
                    flightInfoDto.setArrivalAirport((String) arrival.get("airport"));
                    flightInfoDto.setScheduledArrival((String) arrival.get("scheduled"));

                    // Extract airline information
                    Map<String, Object> airline = (Map<String, Object>) flightData.get("airline");
                    flightInfoDto.setAirlineName((String) airline.get("name"));

                    // Extract flight number
                    Map<String, Object> flight = (Map<String, Object>) flightData.get("flight");
                    flightInfoDto.setFlightNumber((String) flight.get("iata"));

                    return flightInfoDto;
                });

        // Block to get the result (consider handling this in a non-blocking way in real applications)
        return flightInfoDtoMono.block();
    }
}