package com.setoue.store_car.mapper;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.entities.CarPostEntity;

public class CarPostMapper {

    public static CarPostEntity toEntity(CarPostDto carPostDto){
        CarPostEntity carPostEntity = new CarPostEntity();
        carPostEntity.setContact(carPostDto.getContact());
        carPostEntity.setBrand(carPostDto.getModel());
        carPostEntity.setPrice(carPostDto.getPrice());
        carPostEntity.setDescription(carPostDto.getDescription());
        carPostEntity.setEngineVersion(carPostDto.getEngineVersion());
        carPostEntity.setCity(carPostDto.getCity());
        carPostEntity.setModel(carPostDto.getModel());
        carPostEntity.setCreatedDate(carPostDto.getCreatedDate());

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
