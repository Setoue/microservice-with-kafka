package com.setoue.store_car.services;

import com.setoue.store_car.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDto carPostDto);
    List<CarPostDto> getCarSales();
    void changeCarSale(CarPostDto carPostDto, Long id);
    void deleteCarSale(Long id);
}
