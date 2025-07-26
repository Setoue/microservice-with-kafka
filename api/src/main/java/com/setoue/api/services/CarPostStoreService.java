package com.setoue.api.services;

import com.setoue.api.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDto> getCarForSale();
    void changeCarForSale(CarPostDto carPostDto, String id);
    void removeCarForSale(String id);

}
