package com.helloshoes.helloshoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class UserEntity implements SuperEntity{
}
