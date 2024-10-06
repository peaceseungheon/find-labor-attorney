package kr.co.sh.mysql_jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(value = "kr.co.sh")
@EnableJpaRepositories(value = "kr.co.sh")
public class EntityConfig {

}
