package com.setoue.store_car.services;

import com.setoue.store_car.dto.OwnerPostDto;
import com.setoue.store_car.entities.OwnerPostEntity;
import com.setoue.store_car.mapper.OwnerPostMapper;
import com.setoue.store_car.repositories.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private OwnerPostMapper ownerPostMapper;

    @Override
    public void createOwnerPost(OwnerPostDto ownerPostDto) {
        OwnerPostEntity ownerPostEntity = ownerPostMapper.toEntity(ownerPostDto);
        ownerPostRepository.save(ownerPostEntity);
    }
}
