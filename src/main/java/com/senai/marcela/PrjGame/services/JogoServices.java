package com.senai.marcela.PrjGame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.marcela.PrjGame.entities.Jogo;
import com.senai.marcela.PrjGame.repository.JogoRepository;

@Service
public class JogoServices {
	private final JogoRepository jogorepository;

	@Autowired
	public JogoServices(JogoRepository jogoRepository) {
		this.jogorepository = jogoRepository;
	}

	public Jogo saveJogo(Jogo jogo) {
		return jogorepository.save(jogo);
	}

	public Jogo getJogoByid(Long id) {
		return jogorepository.findById(id).orElse(null);
	}

	public List<Jogo> getAlljogo(){
		return jogorepository.findAll();
	}

	public void deleteJogo(Long id) {
		jogorepository.deleteById(id);
	}
}