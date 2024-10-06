package kr.co.sh.find_labor_attorney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FindLaborAttorneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindLaborAttorneyApplication.class, args);
	}

}
