package com.delivery.drones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/application-context.xml")
class DronesApplicationTests {

	@Test
	void testTest(){
		Assertions.assertTrue(true);
	}

}
