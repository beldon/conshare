package bd.conshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "bd.conshare", annotationClass = Repository.class)
public class ConShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConShareApplication.class, args);
	}
}
