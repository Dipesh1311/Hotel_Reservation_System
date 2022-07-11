package com.bridgelabz.HotelReservationSystem;

import java.util.ArrayList;

public interface HotelReservationIF {

    public void addHotel(String hotelName,int rating, double regularCustomerRate);
    public int getHotelListSize();
    public void printHotelList();
    public ArrayList<Hotel> getHotelList();

}
