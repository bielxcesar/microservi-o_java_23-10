package com.pfc.thindesk.dto;


import javax.validation.constraints.NotBlank;

public record ResolverChamadoDTO(
        @NotBlank(message = "A solução aplicada é obrigatória.") String solucao,
        String tecnicoId
) {}