package com.unab.digitalresidency;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // Omitir la base de datos
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // excluimos la seguridad


public class DigitalresidencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalresidencyApplication.class, args);
		System.out.println("Api corriendo");
	}

	@Bean 
	public ModelMapper modelMapper(){ // Este metodo instancia todos nuestros Objetos

		ModelMapper modelMapper=new ModelMapper(); // como creabamos los objetos
		return modelMapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();

	}

}
