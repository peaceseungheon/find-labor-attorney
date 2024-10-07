package kr.co.sh.labor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "kr.co.sh.labor.labor_api",
    "kr.co.sh.labor.mysql_jpa",
    "kr.co.sh.labor.labor_core"
})
public class LaborApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaborApiSpringBootApplication.class, args);
    }

}
