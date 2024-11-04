package com.example.msfavorito.entity;

import com.example.msfavorito.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fechafavorito;
    private Integer productoId; // ID del producto que se guarda como favorito
    @Transient
    private ProductoDto productoDto;
}