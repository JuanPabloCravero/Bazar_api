package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.dto.VentaClienteDTO;
import com.jpcravero.Bazar_api.model.Producto;
import com.jpcravero.Bazar_api.model.Venta;
import com.jpcravero.Bazar_api.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;


    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta ventaEncontrada = ventaRepo.findById(id).orElse(null);
        return ventaEncontrada;
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    public Venta findVentaMasAlta(){
        List<Venta> listaVentas = new ArrayList<>();
        Venta ventaMayor = null;
        double montoMayor = 0;
        for (Venta venta : listaVentas){
            if(montoMayor < venta.getTotal()){
                ventaMayor = venta;
                montoMayor = venta.getTotal();
            }
        }
        return ventaMayor;
    }

    public int getCantidadProductos(Venta venta){
        List<Producto> listaProductos = venta.getListaProductos();

        for (Producto producto : listaProductos){
            producto.getCosto()
        }
    }

    @Override
    public VentaClienteDTO getClienteMasVentas() {
        VentaClienteDTO clienteConVentaMayor = null;
        Venta ventaMayor = this.findVentaMasAlta();

        clienteConVentaMayor.setCodigo_venta(ventaMayor.getCodigo_venta());
        clienteConVentaMayor.setApellidoCliente(ventaMayor.getUnCliente().getApellido());
        clienteConVentaMayor.setNombreCliente(ventaMayor.getUnCliente().getNombre());
        clienteConVentaMayor.setTotal(ventaMayor.getTotal());
        clienteConVentaMayor.setCantidad_productos(ventaMayor.getListaProductos().size());

        return clienteConVentaMayor;
    }
}
