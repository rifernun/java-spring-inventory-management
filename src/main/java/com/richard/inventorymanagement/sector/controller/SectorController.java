package com.richard.inventorymanagement.sector.controller;

import com.richard.inventorymanagement.sector.dto.SectorRequestDto;
import com.richard.inventorymanagement.shared.dto.ResponseDto;
import com.richard.inventorymanagement.sector.dto.SectorResponseDto;
import com.richard.inventorymanagement.sector.service.impl.SectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sector")
public class SectorController {

    @Autowired
    private SectorServiceImpl sectorService;

    @GetMapping
    public ResponseEntity<List<SectorResponseDto>> getAllSectors(){
        if(sectorService.findAllSectors().isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            List<SectorResponseDto> response = sectorService.findAllSectors().stream()
                    .map(sector -> new SectorResponseDto(sector.getId(), sector.getName(), sector.getDescription()))
                    .toList();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createSector(@RequestBody SectorRequestDto request){
        sectorService.createSector(request);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK, "Sector created successfully"));
    }
}
