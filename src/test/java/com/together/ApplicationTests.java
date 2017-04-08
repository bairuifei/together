package com.together;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.websocket.server.ServerContainer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerContainer.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}
}
