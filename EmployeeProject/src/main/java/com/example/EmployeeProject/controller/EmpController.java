package com.example.EmployeeProject.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeProject.model.EmpModel;
import com.example.EmployeeProject.repository.EmpRepository;
import com.example.EmployeeProject.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService ser;
	
	@Autowired
	private EmpRepository rep;
	
	@PostMapping("/createemp")
	public EmpModel createEmployee(@RequestBody EmpModel e) {
		return ser.createEmp(e);
	}
	
	@GetMapping("/getemployee")
	public List<EmpModel>getEmployee(){
		return ser.getEmp();
	}
	
	@GetMapping("/getbyid/{id}")
	public Optional<EmpModel> getUserById(@PathVariable Integer id){
		return ser.getUserId(id);
		
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUserById(@PathVariable Integer id) {
			return ser.deleteUserId(id);
	}
	
	@PutMapping("/updateuser/{id}")
	public EmpModel updateEmployeeDetails(@PathVariable Integer id, @RequestBody EmpModel em) {
		return ser.updateUser(id, em);
		
	}
	
}
