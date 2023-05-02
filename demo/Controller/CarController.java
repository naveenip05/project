package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CarModel;
import com.example.demo.Service.CarService;


@RestController

public class CarController 
{
	@Autowired
	public CarService cser;
		
	@PostMapping("/postm")
	public CarModel addDetails(@RequestBody CarModel cr)
	{
		return cser.saveInfo(cr);
	}
	@GetMapping("/getma")
	public List <CarModel> getDetails()
	{
		return cser.getInfo();
	}
	
	@PutMapping("/updatem")
	public CarModel updateDetails(@RequestBody CarModel carnum)
	{
		return cser.updateInfo(carnum);
	}
	
	@DeleteMapping("delete/{cid}")
	public String deleteDetails (@PathVariable ("cid") int carnum)
	{
		cser.deleteInfo(carnum);
		return "car number "+carnum+" is deleted";
				
	}
	@DeleteMapping("/deleteReq")
	public String deleteByReq(@RequestParam ("cid") int carnum)
	{
		cser.deleteInfo(carnum);
		return "Bike number "+carnum+" is deleted";
	}
}