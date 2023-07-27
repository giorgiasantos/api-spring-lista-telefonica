package com.catalisa.agendatel.repository;
// anotação para o spring identificar que é um repositório

import com.catalisa.agendatel.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<ContatoModel, Long> { //possar a classe modelo e o tipo do ID

}
