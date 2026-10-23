package com.pfc.thindesk.service;

import com.pfc.thindesk.entity.Chamado;
import com.pfc.thindesk.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    // 1. Requisito: Abertura de Chamado
    public Chamado criarChamado(Chamado chamado) {
        chamado.setStatus("ABERTO");
        chamado.setDataAbertura(LocalDateTime.now());
        return chamadoRepository.save(chamado);
    }

    // 2. Requisito: Consultar por ID
    public Chamado buscarPorId(String id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Chamado não encontrado com id: " + id));
    }

    // 2. Requisito: Listar Chamados do Usuário
    public List<Chamado> listarPorUsuario(String usuario) {
        return chamadoRepository.findByUsuario(usuario);
    }

    // Listar todos os chamados (resolve o listarChamados())
    public List<Chamado> listarChamados() {
        return chamadoRepository.findAll();
    }

    // 3 e 4. Requisitos: Resolução e Trava de Alteração
    public Chamado resolverChamado(String id, String solucao, String tecnico) {
        Chamado chamado = buscarPorId(id);

        // Regra de Negócio: Impede alteração se já estiver RESOLVIDO
        if ("RESOLVIDO".equalsIgnoreCase(chamado.getStatus())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Regra de Negócio: Chamados já resolvidos não podem ser alterados.");
        }

        chamado.setSolucao(solucao);
        if (tecnico != null && !tecnico.isBlank()) {
            chamado.setTecnico(tecnico);
        }
        chamado.setStatus("RESOLVIDO");
        chamado.setDataResolucao(LocalDateTime.now());

        return chamadoRepository.save(chamado);
    }
}