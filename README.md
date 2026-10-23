### Requisito 3: Resolução do Chamado

Esta fase do projeto é focada na equipe técnica. É a parte do sistema que permite encerrar um chamado após o problema ter sido consertado.

Quando o técnico envia a solução através do método de atualização (`PUT`), o nosso código faz o trabalho duro por trás dos panos:
1. Pega a explicação de como o problema foi resolvido.
2. Registra qual técnico fez o atendimento.
3. Muda automaticamente o status de `ABERTO` para `RESOLVIDO`.
4. Carimba a data e a hora exata em que o conserto foi finalizado.

**Como testar esta etapa:**
Envie as informações de resolução para `http://localhost:8080/api/chamados/{id_do_chamado}/resolver` com o seguinte formato:
```json
{
  "solucao": "Substituído o cabo DisplayPort da docking station.",
  "tecnico": "tec_suporte"
}
```

O sistema devolverá o chamado atualizado, mostrando a data de resolução e o novo status.
