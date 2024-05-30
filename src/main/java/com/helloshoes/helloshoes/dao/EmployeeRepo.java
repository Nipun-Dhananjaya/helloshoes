package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}
