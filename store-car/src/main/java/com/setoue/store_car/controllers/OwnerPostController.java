package com.setoue.store_car.controllers;

import com.setoue.store_car.dto.OwnerPostDto;
import com.setoue.store_car.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody OwnerPostDto ownerPostDto){
        ownerPostService.createOwnerPost(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
