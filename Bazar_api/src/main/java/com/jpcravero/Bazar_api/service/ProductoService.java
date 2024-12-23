package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.model.Producto;
import com.jpcravero.Bazar_api.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository producRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = producRepo.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) {
        producRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        producRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto productoEncontrado = producRepo.findById(id).orElse(null);
        return productoEncontrado;
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }
}
