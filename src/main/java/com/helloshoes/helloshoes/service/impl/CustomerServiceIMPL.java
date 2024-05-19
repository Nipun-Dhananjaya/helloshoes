package com.helloshoes.helloshoes.service.impl;

import com.helloshoes.helloshoes.dao.CustomerRepo;
import com.helloshoes.helloshoes.dto.CustomerDTO;
import com.helloshoes.helloshoes.service.CustomerService;
import com.helloshoes.helloshoes.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo repo;
    private final Mapping mapping;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return mapping.toCustomerDTO(repo.save(mapping.toCustomer(customerDTO)));
    }

    @Override
    public void deleteCustomer(String customerId) {
        CustomerDTO customerDTO = mapping.toCustomerDTO(repo.getReferenceById(customerId));
        repo.delete(mapping.toCustomer(customerDTO));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return mapping.toCustomerDTO(repo.getReferenceById(customerId));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(repo.findAll());
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        CustomerDTO custDTO = mapping.toCustomerDTO(repo.getReferenceById(customerId));
        custDTO.setName(customerDTO.getName());
        custDTO.setJoinedDate(customerDTO.getJoinedDate());
        custDTO.setLevel(customerDTO.getLevel());
        custDTO.setTotPoints(customerDTO.getTotPoints());
        custDTO.setDob(customerDTO.getDob());
        custDTO.setAddress(customerDTO.getAddress());
        custDTO.setContact(customerDTO.getContact());
        custDTO.setEmail(customerDTO.getEmail());
        repo.save(mapping.toCustomer(custDTO));
    }
}
