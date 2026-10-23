### 2. Branch: `feature/req2-consulta-acompanhamento`

# 🔍 Requisito 2: Consulta e Acompanhamento

Após a criação dos chamados, o sistema precisa permitir que os usuários acompanhem o andamento das suas solicitações. Esta etapa foca na leitura e visualização dos dados.

Foram criadas duas portas de consulta (métodos `GET`):
1. **Lista do Usuário:** Busca no banco de dados absolutamente todos os chamados que pertencem a um usuário específico.
2. **Busca Individual:** Procura um chamado único usando o seu ID, perfeito para ver os detalhes de uma solicitação específica.

**Como testar esta etapa:**
* Para ver a lista de um usuário, acesse: `http://localhost:8080/api/chamados/usuario/{nome_do_usuario}`
* Para ver um chamado específico, acesse: `http://localhost:8080/api/chamados/{id_do_chamado}`

O sistema devolverá as informações cadastradas de forma estruturada e fácil de ler.
