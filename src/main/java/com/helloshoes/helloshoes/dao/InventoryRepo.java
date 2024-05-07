package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity,String> {
}
