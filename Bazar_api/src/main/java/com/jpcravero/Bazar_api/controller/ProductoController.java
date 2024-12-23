package com.jpcravero.Bazar_api.controller;

import com.jpcravero.Bazar_api.model.Producto;
import com.jpcravero.Bazar_api.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService prodService;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        prodService.saveProducto(producto);
        return "Producto registrado exitosamente";
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return prodService.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long id){
        return prodService.findProducto(id);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long id){
         prodService.deleteProducto(id);
         return "Producto eliminado exitosamente";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long id, @RequestBody Producto producto){
        prodService.saveProducto(producto);
        return prodService.findProducto(id);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> verificarStock(){
        List<Producto> listaProductos = new ArrayList<Producto>();
        List<Producto> stockNecesario = new ArrayList<Producto>();
        int stock = Integer.parseInt(null);
        listaProductos = prodService.getProductos();

        for (Producto producto : listaProductos){
            stock = producto.getCantidad_disponible();
            if (stock<5){
                stockNecesario.add(producto);
            }
            stock = Integer.parseInt(null);
        }
        return stockNecesario;
    }

}
