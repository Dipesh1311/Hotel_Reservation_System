package com.bridgelabz.HotelReservationSystem;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelReservation {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        System.out.println("Welcome to Hotel Reservation System.");
        System.out.println("-------------------------------------------");


        HotelReservationOperation hotelReservation = new HotelReservationOperation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);

        System.out.println("\nList of Hotels : ");
        hotelReservation.printHotelList();
        System.out.println("--------------------------------------------------------------------------------------------------------------");

        LocalDate startDate = LocalDate.of(2022, Month.JULY, 8);
        LocalDate endDate = LocalDate.of(2022, Month.JULY, 22);
        System.out.println("From "+ startDate + " to " + endDate);
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate) +1;

        System.out.println("Total number of day : "+numberOfDays);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(hotelReservation.getDurationOfStayDetails(startDate,endDate));

        System.out.println(hotelReservation.getCheapestHotel("Regular",startDate,endDate));
        System.out.println(hotelReservation.getCheapestHotel("Reward",startDate,endDate));
        //double weekDay = hotelReservation.weekdaysNumber*hotel.getWeekdayRegularCustomerCost();
        //int cost = (int) (hotelReservation.weekdaysNumber*hotel.getWeekdayRegularCustomerCost());
        //System.out.println(weekDay);

    }
}
