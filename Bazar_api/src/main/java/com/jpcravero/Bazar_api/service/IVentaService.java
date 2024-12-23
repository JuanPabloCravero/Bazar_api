package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.dto.VentaClienteDTO;
import com.jpcravero.Bazar_api.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long id);

    public Venta findVenta(Long id);

    public void editVenta(Venta venta);

    public VentaClienteDTO getClienteMasVentas();
}
