package com.setoue.api.services;

import com.setoue.api.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createdOwnerCar(OwnerPostDto ownerPostDto);
}
