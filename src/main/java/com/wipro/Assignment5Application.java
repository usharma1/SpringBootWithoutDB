package com.wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Assignment5Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}

//	@PostConstruct
//	public void init() {
//		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
//		map.put(101, new Employee(1, "Usha", "Sharma", "Delhi"));
//		map.put(102, new Employee(2, "Pratha", "Sharma", "Delhi"));
//
//		//Stream.of(map.values().toString()).forEach(System.out::println);
//		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
//			Integer k = entry.getKey();
//			Employee v = entry.getValue();
//			System.out.println("Key: " + k + ", Value: " + v);
//		}
//	}
}
