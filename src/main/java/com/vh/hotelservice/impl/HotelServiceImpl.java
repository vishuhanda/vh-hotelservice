package com.vh.hotelservice.impl;

import com.vh.hotelservice.entities.Hotel;
import com.vh.hotelservice.exceptions.ResourceNotFoundException;
import com.vh.hotelservice.repositories.HotelRepository;
import com.vh.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotel_Id) {
        return hotelRepository.findById(hotel_Id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found"));
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }
}
