package com.catalisa.agendatel.controller;

// anotação para indicar que o controlador é do tipo rest com os 4 endpoints do CRUD

import com.catalisa.agendatel.model.ContatoModel;
import com.catalisa.agendatel.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContatosController {

    @Autowired
    ContatoService contatoService;

    // ENDPOINTS

    // REQUISIÇÃO GET - buscar contatos dentro do banco de dados

    //mapeando os metodos como get
    @GetMapping(path = "/contatos")
    public List<ContatoModel> buscaTodosContatos(){
        return contatoService.buscarTodos();
    }

    //mapeando os metodos como get
    @GetMapping(path = "/contatos/{id}")
    public Optional<ContatoModel> buscarContatoPorId(@PathVariable Long id){
        return contatoService.buscarPorId(id);
    }

    // ENDPOINT DE INSERÇÃO
    // Requisição post - Insere algum dado dentro do banco
    @PostMapping(path = "/contatos")
    // anotação para mostrar resposta de criação pro usuario
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoModel cadastrarNovoContato(@RequestBody ContatoModel contatoModel){
        return contatoService.cadastrar(contatoModel);
    }

    // ENDPOINT DE ALTERAÇÃO
    // Requisição PUT
    @PutMapping(path = "/contatos/{id}")
    public ContatoModel alteraContato(@PathVariable Long id, @RequestBody ContatoModel contatoModel){
        return contatoService.alterar(id, contatoModel);
    }

    // ENDPOINT PARA DELETAR
    // Requisição do tipo DELETE - deleta algum dado dentro do banco
    @DeleteMapping(path = "/contatos/{id}")
    public void deletaContato(@PathVariable Long id){
        contatoService.deletar(id);
    }


}
