package com.catalisa.agendatel.service;

import com.catalisa.agendatel.model.ContatoModel;
import com.catalisa.agendatel.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// anotação para indicar pro spring que essa classe é um serviço

// ESSA CLASSE VAI CONTER TODOS OS MÉTODOS E REGRAS DE NEGÓCIOS
@Service
public class ContatoService {

    // anotação para injetar a interface dentro da classe service
    @Autowired
    ContatosRepository contatosRepository;

    // método que busca todos os contatos do banco
    public List<ContatoModel> buscarTodos(){
        return contatosRepository.findAll();
    }

    // método que busca um contato pelo id
    public Optional<ContatoModel> buscarPorId(Long id){
        return contatosRepository.findById(id);
    }

    // método que cadastra um novo contato no banco
    public ContatoModel cadastrar(ContatoModel contatoModel){
        // DTO
//        contatoModel.getId();
//        contatoModel.getNome();
//        contatoModel.getTelefone();

        return contatosRepository.save(contatoModel);
    }

    // método para alterar um contato já existente
    public ContatoModel alterar(Long id, ContatoModel contatoModel){

        ContatoModel contatos = buscarPorId(id).get();

        if(contatoModel.getNome() != null){
            contatos.setNome(contatoModel.getNome());
        }
        if(contatoModel.getTelefone() != null){
            contatos.setTelefone(contatoModel.getTelefone());
        }
        return contatosRepository.save(contatos);
    }

    // método para deletar um contato já existente
    public void deletar(Long id){
        contatosRepository.deleteById(id);
    }

}
