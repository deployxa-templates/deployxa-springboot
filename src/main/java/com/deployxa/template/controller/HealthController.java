package com.deployxa.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

	@GetMapping("/")
	public Map<String, String> index() {
		Map<String, String> res = new HashMap<>();
		res.put("message", "Deployxa Spring Boot Template");
		return res;
	}

	@GetMapping("/health")
	public Map<String, Object> health() {
		Map<String, Object> res = new HashMap<>();
		res.put("status", "healthy");
		res.put("timestamp", System.currentTimeMillis());
		return res;
	}
}
