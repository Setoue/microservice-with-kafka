package com.setoue.store_car.repositories;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.entities.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
}
