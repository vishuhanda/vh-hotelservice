package com.vh.hotelservice.services;

import com.vh.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    Hotel getHotel(String hotel_Id);

    List<Hotel> getHotels();


}
