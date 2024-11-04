package com.example.msfavorito.feign;

import com.example.msfavorito.dto.ProductoDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto-service", path = "/producto") // Define el cliente Feign para comunicarse con el microservicio de producto
public interface ProductoFeign {
    @GetMapping("/{id}") // Mapea la solicitud GET a "/producto/{id}"
    @CircuitBreaker(name = "favoritoListByIdCB", fallbackMethod = "favoritoListById")
    public ResponseEntity<ProductoDto> getById(@PathVariable Integer id);
    default ResponseEntity<ProductoDto> favoritoListById(Integer id, Exception e) {
        return ResponseEntity.ok(new ProductoDto());
    }
}