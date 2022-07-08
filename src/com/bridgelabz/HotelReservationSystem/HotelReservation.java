package com.bridgelabz.HotelReservationSystem;

import java.util.HashMap;
import java.util.Map;


public class HotelReservation {

    Map<String, Hotel> hotelList = new HashMap<String, Hotel>();
    Hotel hotels = new Hotel();

    public void addHotel(String hotelName,int rating, double weekdayRateRegular, double weekendRateRegular)
    {
        hotels = new Hotel();
        hotels.setHotelName(hotelName);
        hotels.setRating(rating);
        hotels.setWeekdayRegularCustomerPrice(weekdayRateRegular);
        hotels.setWeekendRegularCustomerPrice(weekendRateRegular);

        hotelList.put(hotelName, hotels);
    }

}
