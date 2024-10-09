package com.ust.Airline.controller;





import com.ust.Airline.dto.FlightInfoDto;
import com.ust.Airline.dto.Flightdto;
import com.ust.Airline.dto.ResponseDto;
import com.ust.Airline.model.Airline;
import com.ust.Airline.service.AirlineService;
import com.ust.Airline.service.Airlineserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService service;
    @Autowired
    private Airlineserviceimpl airlineserviceimpl;

    @PostMapping("/addairline")
    public ResponseEntity<Airline> addairline(@RequestBody Airline airline){
        return ResponseEntity.ok(service.addAirline(airline));

    }
    @GetMapping("{airlinecode}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("airlinecode") String airlinecode){
        ResponseDto responseDto = service.getAirline(airlinecode);
        return ResponseEntity.ok(responseDto);
    }
//    @GetMapping("/externalApi")
//    public ResponseEntity<?> getExternalApi(){
//        https://api.aviationstack.com/v1/flights?access_key=c42ba0c13e84be129b0b8ba782746497
//        List<Flightdto> flightDTOList = webClientBuilder.baseUrl("http://localhost:9098")
//                .build()
//                .get()
//                .uri("/flights/" + airline.getAirlinecode())
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<Flightdto>>() {})
//                .block();
//
//        return ResponseEntity.ok(responseDto);
//    }
    @GetMapping("/trackFlight/{flightNumber}")
    public FlightInfoDto check(@PathVariable String flightNumber){
        return airlineserviceimpl.getFlightInfo(flightNumber);
    }


}
