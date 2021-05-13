package com.devsuperiorbootcamp.dsvendas.controllers;

import com.devsuperiorbootcamp.dsvendas.dto.SellerDTO;
import com.devsuperiorbootcamp.dsvendas.services.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    //endpoints
    @GetMapping
    public ResponseEntity <List<SellerDTO>>findAll(){
        List<SellerDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

}
