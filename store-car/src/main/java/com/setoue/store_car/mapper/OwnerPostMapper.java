package com.setoue.store_car.mapper;

import com.setoue.store_car.dto.OwnerPostDto;
import com.setoue.store_car.entities.OwnerPostEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerPostMapper {

    public OwnerPostEntity toEntity(OwnerPostDto ownerPostDto){
        OwnerPostEntity ownerPostEntity = new OwnerPostEntity();

        ownerPostEntity.setName(ownerPostDto.getName());
        ownerPostEntity.setType(ownerPostDto.getType());
        ownerPostEntity.setContactNumber(ownerPostDto.getContactNumber());

        return ownerPostEntity;
    }

}
