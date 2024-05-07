package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dto.SalesDTO;
import com.helloshoes.helloshoes.service.SalesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesServiceIMPL implements SalesService {
    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        return null;
    }

    @Override
    public void deleteSales(String salesId) {

    }

    @Override
    public SalesDTO getSelectedSales(String salesId) {
        return null;
    }

    @Override
    public List<SalesDTO> getAllSales() {
        return null;
    }

    @Override
    public void updateSales(String salesId, SalesDTO salesDTO) {

    }
}
