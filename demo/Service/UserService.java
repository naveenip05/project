package com.example.demo.Service;



import java.util.List;
import java.util.Optional;

import com.example.demo.Model.UserModel; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repo;
	
	
	public String createUser(UserModel user){
		boolean value = repo.existsByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(value == true){
			return "The user already exists. To enter the application please use login";
		}
		else{
			repo.save(user);
			return "A new user with the details " + user.toString() + " is created. Login to continue";
		}
	}
	
	
	public String checkUser(String username, String password){
		boolean value = repo.existsByUserNameAndPassword(username, password);
		boolean exist = repo.existsByUserName(username);
		
		if(exist == true) {
			if(value == true) {
				return "The User is successfully Logged in";
			}
			else {
				return "The user password is not correct. Login failed";
			}
		}
		else {
			return "The user is not found in database";
		}
	}
	
	
	public Optional<UserModel> getUser(int id){
		boolean value = repo.existsById(id);
		if(value == true) {
			return repo.findById(id);
		}
		else {
			return null;
		}
	}
	
	
	public List<UserModel> getUsers(){
		return repo.findAll();
	}
	
	
	public String updateUser(UserModel user, int id){
		boolean value = repo.existsById(id);
		UserModel dummy = repo.findById(id).orElse(null);
		if(value == true) {
			dummy.setAge(user.getAge());
			dummy.setEmail(user.getEmail());
			dummy.setFirstName(user.getFirstName());
			dummy.setLastName(user.getLastName());
			dummy.setPassword(user.getPassword());
			dummy.setPhoneNumber(user.getPhoneNumber());
			dummy.setUserName(user.getUserName());
			
			repo.saveAndFlush(dummy);
			
			return "The user details was successfully updated in the database";
		}
		else {
			return "The user details is not present in the database to be updated";
		}
	}
	
	
	public String deleteUser(int id){
		UserModel value = repo.findById(id).orElse(null);
		if(value != null) {
			repo.deleteById(id);
			return "Item with id " + id + "is not deleted from the database";
		}
		else {
			return "Item with id " + id + "is not deleted as it's not present in Database";
		}
	}
	
	
	public List<UserModel> sortAscending(String field){
		return repo.findAll(Sort.by(Direction.ASC, field));
	}
	
	
	public List<UserModel> sortDescending(String field){
		return repo.findAll(Sort.by(Direction.DESC, field));
	}
	
	
	public List<UserModel> paginationAndSorting(int pageNumber, int pageSize, String column_name){
		Page<UserModel> user = repo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).descending()));
		return user.getContent();
	}
}