package com.pfc.thindesk.repository;

import com.pfc.thindesk.entity.Chamado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends MongoRepository<Chamado, String> {
    List<Chamado> findByUsuario(String usuario);
}