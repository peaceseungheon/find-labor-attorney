package kr.co.sh.labor.labor_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "kr.co.sh.labor")
public class LaborApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaborApiSpringBootApplication.class, args);
    }

}
