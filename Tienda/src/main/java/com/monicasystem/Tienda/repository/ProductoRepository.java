package com.monicasystem.Tienda.repository;

import com.monicasystem.Tienda.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

}
