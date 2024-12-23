package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

    public void editProducto(Producto producto);

}
