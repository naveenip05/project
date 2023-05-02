package com.example.demo.Controller;



import java.util.List;
import java.util.Optional;
import java.util.Map;
   
import com.example.demo.Service.UserService;
import com.example.demo.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService service;
	
	
	//Sign Up Method
	@PostMapping(value = "/signup")
	public String signUp(@RequestBody UserModel user){
		return service.createUser(user);
	}
	
	
	//Login Method
	@PostMapping(value = "/login")
	public String login(@RequestBody Map<String , String> loginData) {
		String username = loginData.get("userName");
		String password = loginData.get("password");
		
		return service.checkUser(username, password);
	}
	
	
	//Get User by Id
	@GetMapping(value = "/showUser")
	public Optional<UserModel> getUserByReqParam(@RequestParam int id){
		return service.getUser(id);
	}
	
	
	//Get All Users
	@GetMapping(value = "/showUsers")
	public List<UserModel> getAllUsers(){
		return service.getUsers();
	}
	
	
	//Update User By Id
	@PutMapping(value = "/editUser")
	public  String updateUserById(@RequestBody UserModel user, @RequestParam(required = true) int id){
		return service.updateUser(user, id);
	}
	
	
	//Delete User By Id
	@DeleteMapping(value = "/deleteUser")
	public String deleteUserByReqParam(@RequestParam(required = true) int id){
		service.deleteUser(id);
		return "Drug with ID " + id + " is deleted"; 
	}
	
	
	//Ascending Sorting
	@GetMapping(value = "/sortAsc")
	public List<UserModel> sortAsc(@RequestParam(required = true) String field){
		return service. sortAscending(field);
	}
	
	
	//Descending Sorting
	@GetMapping(value = "/sortDesc")
	public List<UserModel> sortDesc(@RequestParam(required = true) String field){
		return service. sortDescending(field);
	}
	
	
	//Pagination with sorting
	@GetMapping(value = "/pagination")
	public List<UserModel> paginationData(@RequestParam(value = "pnu", required = true) int pnu, @RequestParam(value = "psize", required = true) int psize, @RequestParam(value = "field", required = true) String field){
		return service.paginationAndSorting(pnu, psize, field);
	}
}