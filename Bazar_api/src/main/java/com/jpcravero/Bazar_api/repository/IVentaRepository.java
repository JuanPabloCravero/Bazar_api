package com.jpcravero.Bazar_api.repository;

import com.jpcravero.Bazar_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
