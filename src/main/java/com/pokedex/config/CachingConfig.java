package com.pokedex.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachingConfig {

    public static final String POKEMONS = "pokemons";
    public static final String POKEMON = "pokemon";
    public static final String EVOLUTIONS = "evolutions";
    public static final String DESCRIPTIONS = "descriptions";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(POKEMONS,POKEMON,EVOLUTIONS, DESCRIPTIONS);
    }
}