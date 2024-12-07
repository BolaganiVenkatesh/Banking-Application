package com.crudoperation.repository;

import com.crudoperation.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
}
