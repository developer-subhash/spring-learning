package com.springlearning.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Bean
	public CommandLineRunner runner(){
		return args -> {
			jdbcTemplate.execute("DROP TABLE CUSTOMER IF EXISTS");
			jdbcTemplate.execute("CREATE TABLE CUSTOMER ( id NUMBER, firstName VARCHAR(255), lastName VARCHAR(255), address VARCHAR(255))");

//			jdbcTemplate.execute("insert into customer values(1, 'subhash', 'sam', 'patna')");

			List<Object[]> data = new ArrayList<>();
			data.add(new Object[]{1, "subhash", "sam", "patna"});
			data.add(new Object[]{2, "suman", "sam", "patna"});

			jdbcTemplate.batchUpdate("insert into customer values(?,?,?,?)", data);


			List<Customer> customers = jdbcTemplate.query(
							"SELECT id, firstname, lastname, address FROM customer",
							(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("address")));

			customers.forEach(customer -> System.out.println(customer.toString()));
		};
	}

}
