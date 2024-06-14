package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.InventoryEntity;
import com.helloshoes.helloshoes.entity.SalesItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesItemRepo extends JpaRepository<SalesItemEntity,String> {
    SalesItemEntity getReferenceById(long parseLong);
}
