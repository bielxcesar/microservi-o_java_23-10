package com.pfc.thindesk.dto;


import javax.validation.constraints.NotBlank;

public record AbrirChamadoDTO(
        @NotBlank(message = "O título é obrigatório.") String titulo,
        @NotBlank(message = "A descrição é obrigatória.") String descricao,
        @NotBlank(message = "O ID do solicitante é obrigatório.") String solicitanteId,
        String solicitanteNome
) {}