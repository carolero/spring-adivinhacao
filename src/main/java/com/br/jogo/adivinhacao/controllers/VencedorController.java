package com.br.jogo.adivinhacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.jogo.adivinhacao.models.Vencedor;
import com.br.jogo.adivinhacao.services.RandomService;
import com.br.jogo.adivinhacao.services.VencedorService;

@Controller
public class VencedorController {
	
	@Autowired
	private VencedorService vencedorService;
	@Autowired
	private RandomService randomService;
	
	@GetMapping("/")
	public ModelAndView chutar() {
		ModelAndView modelAndView = new ModelAndView("vencedor.html");
		modelAndView.addObject("vencedores", vencedorService.mostrarVencedores());
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView cadastrarUsuario(@Valid Vencedor vencedor, BindingResult bindingResultVencedor) {
		ModelAndView modelAndView = new ModelAndView("vencedor.html");
		if(bindingResultVencedor.hasErrors()) {
			List<String> mensagem = new ArrayList<String>();
			for (ObjectError objectError : bindingResultVencedor.getAllErrors()) {
				mensagem.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("mensagem", mensagem);
			modelAndView.addObject("vencedores", vencedorService.mostrarVencedores());
			return modelAndView;
		} else {
			modelAndView.addObject("mensagem", vencedorService.validarChute(vencedor));
		}
		modelAndView.addObject("vencedores", vencedorService.mostrarVencedores());
		return modelAndView;
	}

}
