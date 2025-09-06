package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private int nextId = 1;
	private String email = "@example.com";
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable int id) {
		Employee employee = employeeRepository.findById(id).
				            orElseThrow(()-> new RuntimeException("Student id not found"));
				           
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employee.setId(nextId++);
		employee.setEmail(employee.getName().toLowerCase()+email);
		employeeRepository.save(employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
		
		return ResponseEntity.ok("Employee deleted Successfully");
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
		
		Employee existingEmployee = employeeRepository.findById(id)
				                  .orElseThrow(()-> new RuntimeException("Employee not found"));
		
		existingEmployee.setName(employee.getName());
		existingEmployee.setDomain(employee.getDomain());
		
		employeeRepository.save(existingEmployee);
		
		return ResponseEntity.ok("Employee updated Successfully");
	}
}