package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
	
	@GetMapping("/simpleMessageWelcome")
	@ResponseBody
	public String simpleMessageWelcome() {
		return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login(@RequestParam String user, @RequestParam String password) {
		
		String msg = "LOGIN EFETUADO COM SUCESSO !!!";
		
		if (user == "" || password == "") {
			msg = "USUÁRIO E SENHA NÃO INFORMADOS";
		} else if (user.length() > 15 || password.length() > 15) {
			msg = "USUÁRIO E SENHA INVÁLIDOS";
		}
		
		return msg;
	}

}
