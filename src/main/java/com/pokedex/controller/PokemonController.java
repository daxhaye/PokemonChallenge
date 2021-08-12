package com.pokedex.controller;

import com.pokedex.service.Interface.IPokemonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Pokemon Controller")
public class PokemonController {
    private final IPokemonService pokemonService;

    public PokemonController(IPokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    @ApiOperation("Lista todos los pokemon Paginados, trae su información básica, foto, tipo, y habilidades")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT FOUND")}
    )
    public ResponseEntity<?> getAllPokemon(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit){
        try {
            return ResponseEntity.ok(pokemonService.findAll(offset, limit));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    @ApiOperation("Busca al pokemon por el ID ingresado y le suma la descripción y su próxima evolución")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT FOUND")}
    )
    public ResponseEntity<?> findById(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(pokemonService.findById(id));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
