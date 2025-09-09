package com.monicasystem.Tienda.controller;


import com.monicasystem.Tienda.entity.Producto;
import com.monicasystem.Tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable String id) {
        return productoRepository.findById(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable String id, @RequestBody Producto productoDetalles) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoDetalles.getNombre());
            producto.setCantidad(productoDetalles.getCantidad()); // corregí el typo de getCantida()
            producto.setPrecio(productoDetalles.getPrecio());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
        return "Producto con id " + id + " eliminado correctamente";
    }
}



