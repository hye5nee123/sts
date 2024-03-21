package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	CustomerRepository repo;

//	@AfterAll
//	public void cleanup() {
//		repo.deleteAll();
//	}

	@Test
	public void 저장_조회() {
		// given
		String name = "송강";
		String phone = "010-4921-0217";

		Customer customer = Customer.builder().name(name).phone(phone).build();

		repo.save(customer);
		// when
		// 전체조회
		List<Customer> list = repo.findByNameLike(name);

		// then
		Customer result = list.get(0);
		assertThat(result.getName()).isEqualTo(name);
	}
}
