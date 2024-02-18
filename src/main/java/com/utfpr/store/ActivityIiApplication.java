package com.utfpr.store;

import com.utfpr.store.service.DepartmentService;
import com.utfpr.store.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ActivityIiApplication {

	private static final Logger log = LoggerFactory.getLogger(ActivityIiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ActivityIiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartmentService ds, EmployeeService es) {
		return (args) -> {

			log.info("");
			log.info("");
			log.info("============ Pergunta 1 =============================");
			log.info(es.findByNameAndDependents("Johann Sebastian Bach", 4).toString());

			log.info("");
			log.info("");
			log.info("============ Pergunta 2 =============================");
			es.findByDepartmentId(3L).forEach(e -> log.info(e.toString()));


			log.info("");
			log.info("");
			log.info("============ Pergunta 3 =============================");
			log.info(ds.findOldestDepartment().toString());

			log.info("");
			log.info("");
			log.info("============ Pergunta 4 =============================");
			log.info(es.findFirstByWage().toString());

			log.info("");
			log.info("");
			log.info("============ Pergunta 5 =============================");
			es.findThreeByWage().forEach(e -> log.info(e.toString()));

			log.info("");
			log.info("");
			log.info("============ Pergunta 6 =============================");
			es.findWithNoDependentsAsc().forEach(e -> log.info(e.toString()));

			log.info("");
			log.info("");
			log.info("============ Pergunta 7 =============================");
			es.findEmployeesByWageAfter(BigDecimal.valueOf(16000.00)).forEach(e -> log.info(e.toString()));

			log.info("");
			log.info("");
			log.info("============ Pergunta 8 =============================");
			es.findEmployeesByWageBiggerThan(BigDecimal.valueOf(16000.00)).forEach(e -> log.info(e.toString()));

			log.info("");
			log.info("");
			log.info("============ Pergunta 11.a ===========================");
			es.findByDependents(3).forEach(e -> log.info(e.toString()));

			log.info("");
			log.info("");
			log.info("============ Pergunta 11.b ===========================");
			es.findWithPartialName("Jo").forEach(e -> log.info(e.toString()));

		};
	}
}
