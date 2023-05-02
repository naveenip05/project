package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Integer> {

}