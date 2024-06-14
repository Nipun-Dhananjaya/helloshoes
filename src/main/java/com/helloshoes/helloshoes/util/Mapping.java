package com.helloshoes.helloshoes.util;

import com.helloshoes.helloshoes.dto.*;
import com.helloshoes.helloshoes.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    /*public List<SalesDTO> toSalesDTOList(List<SalesEntity> sales) {
        return mapper.map(sales, List.class);
    }*/
    public List<SalesDTO> toSalesDTOList(List<SalesEntity> salesEntities) {
        List<SalesDTO> salesDTOS = new ArrayList<>();
        for (SalesEntity salesEntity : salesEntities) {
            salesDTOS.add(toSalesDTO(salesEntity));
        }
        return salesDTOS;
    }
    public List<SalesEntity> toSalesList(List<SalesDTO> sales) {
        return mapper.map(sales, List.class);
    }

    public UserDTO toUserDTO(UserEntity user) {
        return  mapper.map(user, UserDTO.class);
    }
    public UserEntity toUser(UserDTO userDTO) {
        return  mapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> user) {
        return mapper.map(user, List.class);
    }
    public List<UserEntity> toUserList(List<UserDTO> user) {
        return mapper.map(user, List.class);
    }

    public SalesItemDTO toSalesItemDTO(SalesItemEntity salesItem) {
        return  mapper.map(salesItem, SalesItemDTO.class);
    }
    public SalesItemEntity toSalesItemEntity(SalesItemDTO salesItemDTO) {
        return  mapper.map(salesItemDTO, SalesItemEntity.class);
    }
    /*public List<SalesItemDTO> toSalesItemDTOList(List<SalesItemEntity> salesItem) {
        return mapper.map(salesItem, List.class);
    }*/
    public List<SalesItemDTO> toSalesItemDTOList(List<SalesItemEntity> salesItemEntities) {
        List<SalesItemDTO> salesItemDTOS = new ArrayList<>();
        for (SalesItemEntity salesItemEntity : salesItemEntities) {
            SalesItemDTO salesItemDTO=new SalesItemDTO();
            if (salesItemEntity.getInventory()!=null && salesItemEntity.getSales() !=null) {
                salesItemDTO.setItemId(salesItemEntity.getInventory().getItemId());
                salesItemDTO.setOrdId(salesItemEntity.getSales().getOrdId());
                salesItemDTO.setQuantity(salesItemEntity.getQuantity());
                salesItemDTOS.add(salesItemDTO);
            }
        }
        return salesItemDTOS;
    }
    public List<SalesItemEntity> toSalesItemEntityList(List<SalesItemDTO> salesItem) {
        return mapper.map(salesItem, List.class);
    }
}

