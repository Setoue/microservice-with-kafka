package com.setoue.api.controllers;

import com.setoue.api.dto.OwnerPostDto;
import com.setoue.api.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<Void> createOwnerCar(@RequestBody OwnerPostDto ownerPostDto){
        ownerPostService.createdOwnerCar(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
