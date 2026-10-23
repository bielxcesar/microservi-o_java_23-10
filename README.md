# 🚀 Requisito 1: Abertura de Chamado

Esta etapa do projeto é responsável por receber a solicitação inicial do usuário e criar o chamado no sistema. 

O objetivo principal aqui foi garantir que o usuário não precisasse preencher informações que o sistema pode descobrir sozinho. Quando a porta de entrada (o método `POST`) recebe o título e a descrição do problema, o nosso código entra em ação e automaticamente:
1. Registra o nome do solicitante.
2. Carimba a data e a hora exata da criação.
3. Define o status inicial como `ABERTO`.

**Como testar esta etapa:**
Envie as informações do chamado para o endereço `http://localhost:8080/api/chamados` utilizando o formato abaixo:
```json
{
  "titulo": "Monitor sem imagem",
  "descricao": "O monitor secundário não liga ao conectar na docking station.",
  "usuario": "usr_gabriel",
  "tipo": "Hardware"
}
```
O sistema devolverá a confirmação da criação, incluindo o ID único gerado para este chamado e a data de abertura automática.

