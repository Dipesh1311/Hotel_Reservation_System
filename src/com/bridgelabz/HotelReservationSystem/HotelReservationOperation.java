package com.bridgelabz.HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservationOperation {
    public ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    public static Scanner scannerObject = new Scanner(System.in);
    public static double cheapestPrice;
    int weekdaysNumber;

    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost,double weekendRegularCustomerCost,
                         double weekdayRewardCustomerCost, double weekendRewardCustomerCost) {


        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setWeekdayRegularCustomerCost(weekdayRegularCustomerCost);
        hotel.setWeekendRegularCustomerCost(weekendRegularCustomerCost);
        hotel.setWeekdayRewardCustomerCost(weekdayRewardCustomerCost);
        hotel.setWeekendRewardCustomerCost(weekendRewardCustomerCost);
        hotelList.add(hotel);
        System.out.println("Successfully ADDED !!");
    }
    public int getHotelListSize() {
        return hotelList.size();
    }

    public void printHotelList() {
        System.out.println(hotelList);
    }

    public ArrayList<Hotel> getHotelList(int i) {
        return hotelList;
    }
    public ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate) {
        ArrayList<Integer> durationDetails = new ArrayList<>();
        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
        int weekends = 0;

        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
                default:
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        int weekdays = numberOfDays - weekends;
        durationDetails.add(weekdays);
        durationDetails.add(weekends);
        return durationDetails;
    }
    public ArrayList<Hotel> getCheapestHotel(String customerType, LocalDate startDate, LocalDate endDate) {

        ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
        weekdaysNumber = durationDetails.get(0);
        int weekendsNumber = durationDetails.get(1);
        ArrayList<Hotel> cheapestHotel = new ArrayList<Hotel>();



        if (customerType.equalsIgnoreCase("Regular")) {

            cheapestPrice = hotelList.stream()
                    .mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerCost() * weekendsNumber)
                            + hotel.getWeekdayRegularCustomerCost() * weekdaysNumber))
                    .min().orElse(Double.MAX_VALUE);
            cheapestHotel = hotelList.stream()
                    .filter(hotel -> (hotel.getWeekendRegularCustomerCost() * weekendsNumber
                            + hotel.getWeekdayRegularCustomerCost() * weekdaysNumber) == cheapestPrice)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (customerType.equalsIgnoreCase("Reward")) {

        cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRewardCustomerCost() * weekendsNumber)
                        + hotel.getWeekdayRewardCustomerCost() * weekdaysNumber))
                .min().orElse(Double.MAX_VALUE);

        cheapestHotel = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRewardCustomerCost() * weekendsNumber
                        + hotel.getWeekdayRewardCustomerCost() * weekdaysNumber) == cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));
    }

		if (cheapestPrice != Double.MAX_VALUE) {
        Iterator<Hotel> iterator = cheapestHotel.iterator();
        System.out.println("Cheap Hotels : \n");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
        }
        return cheapestHotel;
    }
		return null;

}



}


