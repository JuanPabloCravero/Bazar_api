package com.jpcravero.Bazar_api.controller;

import com.jpcravero.Bazar_api.model.Producto;
import com.jpcravero.Bazar_api.model.Venta;
import com.jpcravero.Bazar_api.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return "Venta registrada exitosamente";
    }

    @GetMapping("ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("ventas/{codigo_venta}")
    public Venta buscarVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta);
    }

    @DeleteMapping("ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        return "Venta eliminada exitosamente";
    }

    @PutMapping("ventas/editar/{codigo_venta}")
    public Venta editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return ventaService.findVenta(codigo_venta);
    }

    @GetMapping("ventas/productos/{codigo_venta}")
    public List<Producto> productosDeVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta).getListaProductos();
    }

    @GetMapping("ventas/{fecha_venta}")
    public String obtenerVentasDelDía(@PathVariable Date fecha_venta){
        int cantidad_ventas = Integer.parseInt(null);
        double montoVendido = Double.parseDouble(null);
        List<Venta> ventasTotales = ventaService.getVentas();

        for (Venta venta : ventasTotales){
            if(fecha_venta.equals(venta.getFecha_venta())){
                montoVendido += venta.getTotal();
                cantidad_ventas ++;
            }
        }
        return "Se realizaron " + cantidad_ventas + " ventas, por un total de " + montoVendido + " $";
    }

}
