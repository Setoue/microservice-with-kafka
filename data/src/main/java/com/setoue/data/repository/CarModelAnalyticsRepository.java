package com.setoue.data.repository;

import com.setoue.data.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {

    Optional<CarModelAnalyticsEntity> findByModel(String model);
}
