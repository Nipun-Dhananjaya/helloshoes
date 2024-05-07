package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepo extends JpaRepository<SalesEntity,String> {
}
