package com.pokedex.controller;

import com.pokedex.service.Interface.IPokemonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokemonController {
    @Autowired
    private IPokemonService pokemonService;

    @GetMapping
    public ResponseEntity<?> getAllPokemon(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit){
        try {
            return ResponseEntity.ok(pokemonService.findAll(offset, limit));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @GetMapping("/1")
    public ResponseEntity<?> findById()  {
        try {
            return ResponseEntity.ok(pokemonService.findById());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }



}
