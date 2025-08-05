package com.setoue.store_car.controllers;

import com.setoue.store_car.dto.CarPostDto;
import com.setoue.store_car.services.CarPostService;
import com.setoue.store_car.services.CarPostServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/car")
    public ResponseEntity<List<CarPostDto>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Void> changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable String id){
        carPostService.changeCarSale(carPostDto, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> removeCarSale(@PathVariable String id){
        carPostService.deleteCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
