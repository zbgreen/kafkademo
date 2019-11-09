package com.green;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {
	
	public static final String TOPIC = "test";
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@PostMapping("/kafka/publish")
	public boolean publish(@RequestParam("message") String message) {
		template.send(TOPIC, message);
		return true;
	}
}
