package com.mail.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.api.dto.EmailRequest;
import com.mail.api.dto.EmailResponse;
import com.mail.api.service.EmailService;

@SpringBootApplication
@RestController
public class SendingMailApi1Application {

	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public EmailResponse sendEmail(@RequestBody EmailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SendingMailApi1Application.class, args);
		System.out.println("running...");
	}

}
