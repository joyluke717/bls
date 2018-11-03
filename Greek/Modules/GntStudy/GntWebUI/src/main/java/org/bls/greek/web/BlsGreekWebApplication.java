package org.bls.greek.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.bls.greek.web")
public class BlsGreekWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlsGreekWebApplication.class, args);
	}
}
