package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplerRepo extends JpaRepository<SupplierEntity,String>{
}
