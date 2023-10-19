package com.senai.marcela.PrjGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.marcela.PrjGame.entities.Jogo;
import com.senai.marcela.PrjGame.services.JogoServices;
@RestController
@RequestMapping("/jogos")
public class JogoController{
	
	private final JogoServices jogoServices;
	
	@Autowired
	public JogoController(JogoServices jogoServices) {
		this.jogoServices = jogoServices;
	}
	
	@PostMapping
	public Jogo craeteJogo (@RequestBody Jogo jogo) {
		return jogoServices.saveJogo(jogo);
	}
	
	@GetMapping
	public List<Jogo> getAllJogo(){
		return jogoServices.getAlljogo();
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoServices.deleteJogo(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo>getJogo(@PathVariable Long id) {
		Jogo jogo = jogoServices.getJogoByid(id);
		if (jogo !=null) {
		return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	
	
	
	
}
