package com.db.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(isolation = Isolation.DEFAULT)
@Rollback(true)
@SpringBootTest
public class CloudApplicationTests {

	@Test
	void contextLoads() {
	}

}
