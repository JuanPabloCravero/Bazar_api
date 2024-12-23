package com.jpcravero.Bazar_api.service;

import com.jpcravero.Bazar_api.model.Cliente;
import com.jpcravero.Bazar_api.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;


    @Override
    public List<Cliente> getClientes() {
    List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public void saveClientes(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente clienteEncontrado = clienteRepo.findById(id).orElse(null);
        return clienteEncontrado;
    }

    @Override
    public void editCliente(Cliente cliente) {
        this.saveClientes(cliente);
    }
}
