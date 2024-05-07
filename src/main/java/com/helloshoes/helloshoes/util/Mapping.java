package com.helloshoes.helloshoes.util;

import com.helloshoes.helloshoes.dto.*;
import com.helloshoes.helloshoes.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }
    public List<CustomerEntity> toCustomerList(List<CustomerDTO> customers) {
        return mapper.map(customers, List.class);
    }


    public EmployeeDTO toEmployeeDTO(EmployeeEntity employee) {
        return  mapper.map(employee, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employees) {
        return mapper.map(employees, List.class);
    }
    public List<EmployeeEntity> toEmployeeList(List<EmployeeDTO> employees) {
        return mapper.map(employees, List.class);
    }

    public SupplierDTO toSupplierDTO(SupplierEntity supplier) {
        return  mapper.map(supplier, SupplierDTO.class);
    }
    public SupplierEntity toSupplier(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> suppliers) {
        return mapper.map(suppliers, List.class);
    }
    public List<SupplierEntity> toSupplierList(List<SupplierDTO> suppliers) {
        return mapper.map(suppliers, List.class);
    }

    public InventoryDTO toInventoryDTO(InventoryEntity inventory) {
        return  mapper.map(inventory, InventoryDTO.class);
    }
    public InventoryEntity toInventory(InventoryDTO inventoryDTO) {
        return  mapper.map(inventoryDTO, InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventories) {
        return mapper.map(inventories, List.class);
    }
    public List<InventoryEntity> toInventoryList(List<SupplierDTO> inventories) {
        return mapper.map(inventories, List.class);
    }

    public SalesDTO toSalesDTO(SalesEntity sales) {
        return  mapper.map(sales, SalesDTO.class);
    }
    public SalesEntity toSales(SalesDTO salesDTO) {
        return  mapper.map(salesDTO, SalesEntity.class);
    }
    public List<SalesDTO> toSalesDTOList(List<SalesEntity> sales) {
        return mapper.map(sales, List.class);
    }
    public List<SalesEntity> toSalesList(List<SupplierDTO> sales) {
        return mapper.map(sales, List.class);
    }
}
