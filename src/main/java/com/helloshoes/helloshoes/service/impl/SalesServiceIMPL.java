package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.SalesRepo;
import com.helloshoes.helloshoes.dto.SalesDTO;
import com.helloshoes.helloshoes.service.SalesService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesServiceIMPL implements SalesService {
    private final SalesRepo repo;
    private final Mapping mapping;
    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        return mapping.toSalesDTO(repo.save(mapping.toSales(salesDTO)));
    }

    @Override
    public void deleteSales(String salesId) {
        SalesDTO salesDTO = mapping.toSalesDTO(repo.getReferenceById(salesId));
        repo.delete(mapping.toSales(salesDTO));;
    }

    @Override
    public SalesDTO getSelectedSales(String salesId) {
        return mapping.toSalesDTO(repo.getReferenceById(salesId));
    }

    @Override
    public List<SalesDTO> getAllSales() {
        return mapping.toSalesDTOList(repo.findAll());
    }

    @Override
    public void updateSales(String salesId, SalesDTO salesDTO) {
        SalesDTO sDTO = mapping.toSalesDTO(repo.getReferenceById(salesId));
        sDTO.setOrdDate(salesDTO.getOrdDate());
        sDTO.setPayMethod(salesDTO.getPayMethod());
        sDTO.setSubtot(salesDTO.getSubtot());
        sDTO.setDiscount(salesDTO.getDiscount());
        sDTO.setCustomer(salesDTO.getCustomer());
        sDTO.setItem(salesDTO.getItem());
        sDTO.setUser(salesDTO.getUser());
        repo.save(mapping.toSales(sDTO));
    }
}
