package com.setoue.data.services;

import com.setoue.data.dto.CarPostDto;
import com.setoue.data.entity.BrandAnalyticsEntity;
import com.setoue.data.entity.CarModelAnalyticsEntity;
import com.setoue.data.entity.CarModelPriceEntity;
import com.setoue.data.repository.BrandAnalyticsRepository;
import com.setoue.data.repository.CarModelAnalyticsRepository;
import com.setoue.data.repository.CarModelPriceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    private final BrandAnalyticsRepository brandAnalyticsRepository;
    private final CarModelAnalyticsRepository carModelAnalyticsRepository;
    private final CarModelPriceRepository carModelPriceRepository;

    @Override
    public void saveDataAnalytics(CarPostDto carPostDto) {
        saveBrandAnalytics(carPostDto.getBrand());
        saveCarModelAnalytics(carPostDto.getModel());
        saveCarModelPrice(carPostDto.getModel() ,carPostDto.getPrice());
    }

    private void saveBrandAnalytics(String brand){

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });
    };


    private void saveCarModelAnalytics(String model){

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item -> {
            carModelAnalyticsEntity.setPosts(item.getPosts() + 1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            carModelAnalyticsEntity.setModel(model);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });
    };


    private void saveCarModelPrice(String carModel, Double price){

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setPrice(price);
        carModelPriceEntity.setModel(carModel);
        carModelPriceRepository.save(carModelPriceEntity);
    };


}
