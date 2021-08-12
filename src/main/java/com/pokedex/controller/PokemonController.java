package com.pokedex.controller;

import com.pokedex.service.Interface.IPokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    private final IPokemonService pokemonService;

    public PokemonController(IPokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPokemon(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit){
        try {
            return ResponseEntity.ok(pokemonService.findAll(offset, limit));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(pokemonService.findById(id));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }



}
