package com.helloshoes.helloshoes.dao;

import com.helloshoes.helloshoes.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<UserEntity,String> {
}

