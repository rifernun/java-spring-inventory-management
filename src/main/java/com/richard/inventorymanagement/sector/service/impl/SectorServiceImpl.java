package com.richard.inventorymanagement.sector.service.impl;

import com.richard.inventorymanagement.sector.dto.SectorRequestDto;
import com.richard.inventorymanagement.sector.entity.Sector;
import com.richard.inventorymanagement.sector.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl {
    @Autowired
    private SectorRepository repository;

    public List<Sector> findAllSectors(){
         return repository.findAll();
    }

    public void createSector(SectorRequestDto requestDto) {
        Sector sector = new Sector();
        sector.setName(requestDto.getName());
        sector.setDescription(requestDto.getDescription());
        repository.save(sector);
    }
}
