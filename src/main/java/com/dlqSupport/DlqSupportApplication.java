package com.dlqSupport;

import com.dlqSupport.service.SupportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DlqSupportApplication {

	static void main(String[] args) throws IOException {
		SpringApplication.run(DlqSupportApplication.class, args);
		SupportService supportService = new SupportService();
		supportService.iniciarEditor(1L);
	}

}
