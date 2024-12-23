package com.jpcravero.Bazar_api.controller;

import com.jpcravero.Bazar_api.model.Cliente;
import com.jpcravero.Bazar_api.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService cliService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return cliService.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente buscarCliente(@PathVariable Long id){
        return cliService.findCliente(id);
    }

    @PostMapping("clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        cliService.saveClientes(cliente);
        return "Cliente registrado exitosamente";
    }

    @DeleteMapping("clientes/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id){
        cliService.deleteCliente(id);
        return "Cliente eliminado exitosamente";
    }

    @PutMapping("clientes/editar/{id}")
    public Cliente editCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        cliService.saveClientes(cliente);
        return cliService.findCliente(id);
    }

}
