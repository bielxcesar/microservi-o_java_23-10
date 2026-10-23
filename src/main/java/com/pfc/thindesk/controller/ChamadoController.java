package com.pfc.thindesk.controller;

import com.pfc.thindesk.entity.Chamado;
import com.pfc.thindesk.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    // 1. Requisito: Abertura de chamado (POST /api/chamados)
    @PostMapping
    public ResponseEntity<Chamado> criarChamado(@RequestBody Chamado chamado) {
        Chamado novoChamado = chamadoService.criarChamado(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }

    // 2. Requisito: Listar chamados por usuário (GET /api/chamados/usuario/{id})
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Chamado>> listarPorUsuario(@PathVariable("id") String id) {
        List<Chamado> chamados = chamadoService.listarPorUsuario(id);
        return ResponseEntity.ok(chamados);
    }

    // 2. Requisito: Consultar chamado por ID (GET /api/chamados/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable("id") String id) {
        Chamado chamado = chamadoService.buscarPorId(id);
        return ResponseEntity.ok(chamado);
    }

    // 3. Requisito: Resolução do chamado (PUT /api/chamados/{id}/resolver)
    @PutMapping("/{id}/resolver")
    public ResponseEntity<Chamado> resolverChamado(
            @PathVariable("id") String id,
            @RequestBody Chamado dadosResolucao) {

        Chamado chamadoResolvido = chamadoService.resolverChamado(
                id,
                dadosResolucao.getSolucao(),
                dadosResolucao.getTecnico()
        );

        return ResponseEntity.ok(chamadoResolvido);
    }

    // Listar todos os chamados (Opcional para apoio)
    @GetMapping
    public ResponseEntity<List<Chamado>> listarTodos() {
        return ResponseEntity.ok(chamadoService.listarChamados());
    }
}