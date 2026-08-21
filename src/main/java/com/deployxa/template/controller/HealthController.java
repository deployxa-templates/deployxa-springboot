package com.deployxa.template.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {
	@GetMapping("/health")
	public Map<String, Object> health() {
		Map<String, Object> res = new HashMap<>();
		res.put("status", "ok");
		return res;
	}

	@GetMapping("/")
	public Map<String, Object> home() {
		Map<String, Object> res = new HashMap<>();
		res.put("message", "deployxa-spring-boot-release-two");
		return res;
	}
}
