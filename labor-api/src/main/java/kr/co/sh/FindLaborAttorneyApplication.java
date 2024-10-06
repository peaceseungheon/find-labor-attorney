package kr.co.sh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "kr.co.sh")
public class FindLaborAttorneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindLaborAttorneyApplication.class, args);
	}

}
