### 4 Funcionalidade: Listagem de Chamados

Esta branch é dedicada exclusivamente à funcionalidade de leitura e listagem dos chamados técnicos, essencial para que utilizadores e técnicos consigam acompanhar o estado das solicitações no ThinDesk.

A nossa API comunica diretamente com a coleção do MongoDB para recuperar os documentos de forma rápida e estruturada. O que foi implementado nesta fase:
1. **Listagem por Utilizador (Requisito 2):** Um endpoint focado em filtrar e devolver unicamente os chamados abertos por um utilizador específico.
2. **Listagem Geral (Extra de Apoio):** Um endpoint abrangente que lista todos os chamados registados no sistema, facilitando a auditoria e a gestão técnica.

**Como testar esta etapa no Insomnia / Postman:**

* **Listar os chamados de um utilizador específico:**
  Faça um pedido `GET` para `http://localhost:8080/api/chamados/usuario/{nome_do_usuario}` (ex: `usr_gabriel`).
  O sistema devolverá uma lista JSON `[ ]` contendo apenas os tickets pertencentes a esse utilizador.

* **Listar todos os chamados do sistema (Geral):**
  Faça um pedido `GET` para `http://localhost:8080/api/chamados`.
  O sistema devolverá o histórico completo de chamados guardados na base de dados.
