package com.wipro.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmpRepo {

	Map<Integer, Employee> map = new HashMap<Integer, Employee>();

	public Employee addEmployee(Employee employee) {
		map.put(employee.getEid(), employee);
		return employee;
	}

	public Map<Integer, Employee> getAll() {
		return map;
	}

	public Employee findEmployee(int eid) {
		return map.get(eid);
	}

	public Employee update(Employee employee, int eid) {
		map.put(employee.getEid(), employee);
		return employee;
	}

	public String delete(int eid) {
		map.remove(eid);
		return "Deleted";
	}
}
