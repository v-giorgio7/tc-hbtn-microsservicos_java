package com.example.jpah2demo.controller;

import com.example.jpah2demo.model.Cliente;
import com.example.jpah2demo.model.Telefone;
import com.example.jpah2demo.repository.ClienteRepository;
import com.example.jpah2demo.repository.EnderecoRepository;
import com.example.jpah2demo.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {

        try {
            Cliente clienteNovo = clienteRepository.save(
                    new Cliente(cliente.getNome(), cliente.getIdade(), cliente.getEmail()));

            return new ResponseEntity<>(clienteNovo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {

        try {
            List<Cliente> clientes = new ArrayList<>();
            clientes = clienteRepository.findAll();
            if (clientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {

        try {
            Optional<Cliente> clienteById = clienteRepository.findById(idClient);
            return clienteById.map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){

        Optional<Cliente> clienteById = clienteRepository.findById(idClient);
        if (clienteById.isPresent()) {
            clienteRepository.deleteById(idClient);
        } else {
            System.out.println("Cliente não encontrado");
        }

//        try {
//            Optional<Cliente> clienteById = clienteRepository.findById(idClient);
//            if (clienteById.isPresent()) {
//                clienteRepository.deleteById(idClient);
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){

        Optional<Cliente> clienteById = clienteRepository.findById(id);
        if (clienteById.isPresent()) {
            Cliente clienteAtualizado = clienteById.get();
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setIdade(cliente.getIdade());
            clienteAtualizado.setEmail(cliente.getEmail());

            clienteRepository.save(clienteAtualizado);
            System.out.println("Cliente atualizado com sucesso");
        } else {
            System.out.println("Cliente não encontrado");
        }

//        try {
//            Optional<Cliente> clienteById = clienteRepository.findById(id);
//            if (clienteById.isPresent()) {
//                Cliente clienteAtualizado = clienteById.get();
//                clienteAtualizado.setNome(cliente.getNome());
//                clienteAtualizado.setIdade(cliente.getIdade());
//                clienteAtualizado.setEmail(cliente.getEmail());
//
//                clienteRepository.save(clienteAtualizado);
//                return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
}
