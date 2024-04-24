package com.risk.MangementAPI.operationalRisk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OperationalRiskApplication implements CommandLineRunner {
	// @Autowired
	// private  AdminService adminService ;


	public static void main(String[] args) {
		SpringApplication.run(OperationalRiskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Just For Testing
//		AddRiskRequestDTO data = new AddRiskRequestDTO();
//		//
//		LocalDateTime currentDateTime = LocalDateTime.now();
//		data.setDate(currentDateTime) ;
//		data.setImpact(4 );
//		data.setFrequency(5);
//		data.setDescription("TestDescription ");
//		data.setTypology("TestTypology");
//		data.setCategory("Test Cat ");
//		//
//		this.adminService.addRisk(data);

	}

}
