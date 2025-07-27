package com.setoue.api.controllers;

import com.setoue.api.dto.CarPostDto;
import com.setoue.api.message.KafkaProducerMessage;
import com.setoue.api.services.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostStoreController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getAllCarSales() {
        List<CarPostDto> carPostDtoList = carPostStoreService.getCarForSale();
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostDtoList) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarPostDto> changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable String id){
        carPostStoreService.changeCarForSale(carPostDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarSale(@PathVariable String id){
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // The POST verb is not used to call services, but to send a message to Kafka.
    @PostMapping("/posts")
    public ResponseEntity<Void> createCarSale(@RequestBody CarPostDto carPostDto){
        kafkaProducerMessage.sendMessage(carPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
