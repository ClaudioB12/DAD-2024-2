package com.example.msfavorites.controller;


import com.example.msfavorites.entity.Favorite;
import com.example.msfavorites.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<Favorite>> list() {
        List<Favorite> favorites = favoriteService.list();
        return ResponseEntity.ok(favorites);
    }

    @PostMapping
    public ResponseEntity<Favorite> save(@RequestBody Favorite favorite) {
        Favorite savedFavorite = favoriteService.save(favorite);
        return ResponseEntity.ok(savedFavorite);
    }

    @PutMapping
    public ResponseEntity<Favorite> update(@RequestBody Favorite favorite) {
        Favorite updatedFavorite = favoriteService.update(favorite);
        return ResponseEntity.ok(updatedFavorite);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> listById(@PathVariable Integer id) {
        Optional<Favorite> favorite = favoriteService.findById(id);
        return favorite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        favoriteService.deleteById(id);
        return ResponseEntity.ok("Eliminación Correcta");
    }
}
