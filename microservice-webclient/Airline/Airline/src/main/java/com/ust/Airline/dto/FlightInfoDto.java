package com.ust.Airline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfoDto {
        private String flightDate;
        private String flightStatus;
        private String departureAirport;
        private String arrivalAirport;
        private String airlineName;
        private String flightNumber;
        private String scheduledDeparture;
        private String scheduledArrival;
}
