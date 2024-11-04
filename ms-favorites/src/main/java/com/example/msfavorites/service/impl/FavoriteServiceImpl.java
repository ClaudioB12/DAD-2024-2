package com.example.msfavorites.service.impl;

import com.example.msfavorites.entity.Favorite;
import com.example.msfavorites.repository.FavoriteRepository;
import com.example.msfavorites.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public List<Favorite> list() {
        return List.of();
    }

    @Override
    public Favorite save(Favorite Favorite) {
        return null;
    }

    @Override
    public Favorite update(Favorite Favorite) {
        return null;
    }

    @Override
    public Optional<Favorite> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }
}
