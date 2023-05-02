package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CarRepository;
import com.example.demo.Model.CarModel;
@Service

public class CarService
{
	@Autowired
    public CarRepository crepo;
	
	public CarModel saveInfo(CarModel c)
	{
		return crepo.save(c);
	}
	public List<CarModel> getInfo()
	{
		return crepo.findAll();
	}
	public CarModel updateInfo(CarModel iu)
	{
		return crepo.saveAndFlush(iu);
		
	}
	public void deleteInfo(int id )
	{
		crepo.deleteById(id);
	}
}