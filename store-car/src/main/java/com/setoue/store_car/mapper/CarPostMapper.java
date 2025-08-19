package com.setoue.store_car.mapper;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.entities.CarPostEntity;
import com.setoue.store_car.repositories.OwnerPostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CarPostMapper {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    public CarPostEntity toEntity(CarPostDto carPostDto){
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDto.getOwnerId()).ifPresentOrElse(item -> {
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, () -> {
            throw new EntityNotFoundException("OwnerPost não encontrado para ID " + carPostDto.getOwnerId());
        });

        carPostEntity.setBrand(carPostDto.getBrand());
        carPostEntity.setPrice(carPostDto.getPrice());
        carPostEntity.setDescription(carPostDto.getDescription());
        carPostEntity.setEngineVersion(carPostDto.getEngineVersion());
        carPostEntity.setCity(carPostDto.getCity());
        carPostEntity.setModel(carPostDto.getModel());
        carPostEntity.setOwnerId(carPostDto.getOwnerId());
        carPostEntity.setOwnerType(carPostDto.getOwnerType());
        carPostEntity.setOwnerName(carPostDto.getOwnerName());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

    public CarPostDto toDto(CarPostEntity carPostEntity){
        return CarPostDto.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerName())
                .ownerId(carPostEntity.getOwnerId())
                .ownerType(carPostEntity.getOwnerType())
                .price(carPostEntity.getPrice()).build();
    };
}
