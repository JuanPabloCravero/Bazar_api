package com.jpcravero.Bazar_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {

    private Long codigo_venta;
    private double total;
    private int cantidad_productos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, double total, int cantidad_productos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }


}
