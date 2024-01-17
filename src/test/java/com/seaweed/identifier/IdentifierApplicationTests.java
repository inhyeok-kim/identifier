package com.seaweed.identifier;

import com.seaweed.identifier.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
class IdentifierApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		Pageable pageReq = PageRequest.of(0,1);
		System.out.println(userService.findUsers(pageReq).toString());
	}
}
