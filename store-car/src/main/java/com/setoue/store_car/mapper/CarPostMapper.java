package com.setoue.store_car.mapper;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.entities.CarPostEntity;
import com.setoue.store_car.entities.OwnerPostEntity;
import com.setoue.store_car.repositories.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CarPostMapper {

    @Autowired
    private static OwnerPostRepository ownerPostRepository;

    public static CarPostEntity toEntity(CarPostDto carPostDto){
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDto.getOwnerId()).ifPresentOrElse(item -> {
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, () -> {
            throw new RuntimeException();
        });

        carPostEntity.setBrand(carPostDto.getModel());
        carPostEntity.setPrice(carPostDto.getPrice());
        carPostEntity.setDescription(carPostDto.getDescription());
        carPostEntity.setEngineVersion(carPostDto.getEngineVersion());
        carPostEntity.setCity(carPostDto.getCity());
        carPostEntity.setModel(carPostDto.getModel());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

    public static CarPostDto toDto(CarPostEntity carPostEntity){
        return CarPostDto.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerName())
                .price(carPostEntity.getPrice()).build();
    };
}
