package com.example.msfavorites.service;

import com.example.msfavorites.entity.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    public List<Favorite> list();
    public Favorite save(Favorite favorite);
    public Favorite update(Favorite favorite);
    public Optional<Favorite> findById(Integer id);
    public void deleteById(Integer id);
}
