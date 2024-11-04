package com.example.msfavorito.service.impl;

import com.example.msfavorito.dto.ProductoDto;
import com.example.msfavorito.entity.Favorito;
import com.example.msfavorito.exception.ResourceNotFoundException;
import com.example.msfavorito.feign.ProductoFeign;
import com.example.msfavorito.repository.FavoritoRepository;
import com.example.msfavorito.service.FavoritoService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private ProductoFeign productoFeign;

    @Autowired
    private FavoritoRepository favoritoRepository;


    @Override
    public List<Favorito> list() {
        List<Favorito> favoritos = favoritoRepository.findAll();

        // Recorremos cada Registroenvio y asignamos el VehiculoDto
        favoritos.forEach(favorito -> {
            try {
                ResponseEntity<ProductoDto> productoDtoResponse = productoFeign.getById(favorito.getProductoId());
                if (productoDtoResponse.getBody() == null) {
                    // Manejar el caso en el que el VehiculoDto no existe
                    throw new ResourceNotFoundException("VehiculoDto con ID " + favorito.getProductoId() + " no existe");
                }
                favorito.setProductoDto(productoDtoResponse.getBody());

            } catch (FeignException e) {
                // Manejar el error en el servidor de OpenFeign para VehiculoDto
                throw new RuntimeException("Error al obtener el VehiculoDto con ID " + favorito.getProductoId(), e);
            }
        });

        return favoritos;
    }

    @Override
    public Favorito save(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Override
    public Favorito update(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Override
    public Optional<Favorito> findById(Integer id) {
        return favoritoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        favoritoRepository.deleteById(id);
    }
}