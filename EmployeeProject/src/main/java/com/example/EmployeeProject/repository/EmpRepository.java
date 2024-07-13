package com.example.EmployeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeProject.model.EmpModel;

@Repository
public interface EmpRepository extends JpaRepository<EmpModel, Integer>{

}
