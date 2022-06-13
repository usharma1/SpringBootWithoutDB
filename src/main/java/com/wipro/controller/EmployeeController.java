package com.wipro.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.model.EmpRepo;
import com.wipro.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmpRepo empRepo;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employee2 = empRepo.addEmployee(employee);
		return employee2;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> findAll() {
		Map<Integer, Employee> list = empRepo.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("find/{eid}")
	public ResponseEntity<?> findById(@PathVariable("eid") int eid) {
		Employee e = empRepo.findEmployee(eid);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

//	@PutMapping("/update")
//	public ResponseEntity<?> updateEmp(@RequestBody Employee employee) {
//		Employee update = empRepo.update(employee, employee.getEid());
//		return new ResponseEntity<>(update, HttpStatus.OK);
//	}

	@PutMapping("/update/{eid}")
	public ResponseEntity<?> updateEmp(@PathVariable int eid, @RequestBody Employee employee) {
		Employee find = empRepo.findEmployee(eid);
		if (find != null) {
			Employee update = empRepo.update(employee, eid);
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{eid}")
	public String deleteById(@PathVariable("eid") int eid) {
		Employee find = empRepo.findEmployee(eid);
		if (find != null) {
			empRepo.delete(eid);
			return "Successfully Deleted";
		}
		return "NOT FOUND";

	}
}
