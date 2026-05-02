package com.dlqSupport;

import com.dlqSupport.service.SupportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DlqSupportApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DlqSupportApplication.class, args);
	}

}
