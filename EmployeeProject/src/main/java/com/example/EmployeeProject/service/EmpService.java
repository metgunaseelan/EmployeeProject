package com.example.EmployeeProject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeProject.model.EmpModel;
import com.example.EmployeeProject.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository rep;
	
	
	public EmpModel createEmp(EmpModel e) {
		return rep.save(e);
	}
	
	
	public List<EmpModel> getEmp() {
		return rep.findAll();
		 
	}
	
	public Optional<EmpModel> getUserId(Integer id){
		return rep.findById(id);
		
	}
	
	public String deleteUserId(Integer id){
		rep.deleteById(id);
		return "Deleted user : "+id;
		
	}
								// 1
	public EmpModel updateUser(Integer id, EmpModel em) {
						 //mani					  //1
		Optional<EmpModel> User = rep.findById(id);
				//true
		if(User.isPresent()) {
			//mani
			EmpModel userUpdate = User.get();
			userUpdate.setName(em.getName());;
			userUpdate.setEmail(em.getEmail());
			
			return rep.save(userUpdate);
			
		}
		else {
			return null;
		}
		
	}
	
}
