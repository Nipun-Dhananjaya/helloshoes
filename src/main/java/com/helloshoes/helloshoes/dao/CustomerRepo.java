package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
