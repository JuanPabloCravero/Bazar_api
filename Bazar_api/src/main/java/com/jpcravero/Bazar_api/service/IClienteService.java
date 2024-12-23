package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveClientes(Cliente cliente);

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void editCliente(Cliente cliente);

}
