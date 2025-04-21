package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {
	
	//@JsonProperty(value = "email") Força reconhecer um atributo
	@NotBlank(message = "Campo obrigatorio")
	@Email(message = "Email inválido")
	private String email;
	
	public EmailDTO() {
		
	}
	
	public EmailDTO(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}
