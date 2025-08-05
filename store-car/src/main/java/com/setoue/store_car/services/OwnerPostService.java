package com.setoue.store_car.services;

import com.setoue.store_car.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDto ownerPostDto);
}
