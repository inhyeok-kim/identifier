package com.seaweed.identifier

import com.seaweed.identifier.user.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class IdentifierApplicationTests {

	@Autowired
	private lateinit var userService : UserService

	@Test
	fun contextLoads() {
		userService.findAllUsers().forEach{i-> println(i.toString()) }
	}

	@Test
	fun createTest(){
		userService.saveUser("홍길동","test");
	}

	@Test
	fun updateTest(){
		userService.updateNameById("test","홍길동");
	}

}
