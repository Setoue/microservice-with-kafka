package com.setoue.api.services;

import com.setoue.api.client.CarPostStoreClient;
import com.setoue.api.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    CarPostStoreClient carPostStoreClient;

    @Override
    public void createdOwnerCar(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostsClient(ownerPostDto);
    }
}
