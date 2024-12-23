package com.jpcravero.Bazar_api.repository;

import com.jpcravero.Bazar_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
