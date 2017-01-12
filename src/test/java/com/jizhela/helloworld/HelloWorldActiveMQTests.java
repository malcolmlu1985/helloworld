package com.jizhela.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhela.helloworld.component.RoncooJmsComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldActiveMQTests {
	@Autowired
	private RoncooJmsComponent roncooJmsComponent;

	@Test
	public void send() {
		for(int i=0; i<15;i++)
		{
			roncooJmsComponent.send("The " + i + " hello world");
			System.out.println("发送：" + " The " + i + " hello world");
		}
	}

}
