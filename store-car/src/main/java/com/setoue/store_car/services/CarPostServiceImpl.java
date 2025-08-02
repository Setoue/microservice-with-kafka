package com.setoue.store_car.services;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.entities.CarPostEntity;
import com.setoue.store_car.mapper.CarPostMapper;
import com.setoue.store_car.repositories.CarPostRepository;
import com.setoue.store_car.repositories.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;


    @Override
    public void newPostDetails(CarPostDto carPostDto) {
        CarPostEntity carPostEntity = CarPostMapper.toEntity(carPostDto);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDto> getCarSales() {
        List<CarPostDto> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarsSales.add(CarPostMapper.toDto(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDto carPostDto, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(item -> {
            item.setDescription(carPostDto.getDescription());
            item.setBrand(carPostDto.getBrand());
            item.setPrice(carPostDto.getPrice());
            item.setEngineVersion(carPostDto.getEngineVersion());
            item.setModel(carPostDto.getModel());
            item.setContact(carPostDto.getContact());

            carPostRepository.save(item);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void deleteCarSale(Long id) {
        carPostRepository.deleteById(id);
    }
}
