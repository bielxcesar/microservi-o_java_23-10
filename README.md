# 🛠️ ThinDesk - Microserviço de Chamados Técnicos

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)

Este projeto é uma evolução do sistema **ThinDesk**, consistindo na implementação de um microserviço backend em Java com Spring Boot e MongoDB. A API REST é responsável pela abertura, acompanhamento e resolução de chamados técnicos, garantindo segurança e regras de negócio rigorosas.

---

## 🎯 Requisitos Atendidos

- **Abertura de chamado:** Geração automática da data de abertura, status inicial `ABERTO` e vínculo com o usuário solicitante.
-  **Consulta e acompanhamento:** Endpoints para listagem de chamados por usuário e detalhamento individual por ID.
-  **Resolução do chamado:** Registro da solução aplicada pelo técnico, gravação da data de resolução e alteração do status para `RESOLVIDO`.
-  **Regras de Negócio (Imutabilidade):** Trava de segurança que impede a alteração de chamados que já foram resolvidos (retornando erro `400 Bad Request`).
- **Integração e Segurança:** Dados persistidos em nuvem (MongoDB Atlas), rotas da API configuradas via Spring Security e credenciais de banco protegidas por variáveis de ambiente (`.env`).

---

## 🚀 Como Executar o Projeto Localmente

### 1. Clonar o repositório
```bash
git clone [https://github.com/SEU_USUARIO/Microservico-Chamados-Umc-estruturado.git](https://github.com/SEU_USUARIO/Microservico-Chamados-Umc-estruturado.git)
cd Microservico-Chamados-Umc-estruturado
```
---

### 2. Configurar Variáveis de Ambiente
   Para proteger as credenciais do banco de dados, este projeto utiliza variáveis de ambiente.

Na raiz do projeto, renomeie o arquivo .env.example para .env (ou crie um novo arquivo chamado .env).

Preencha com a sua URI do MongoDB:

```bash
MONGODB_URI=mongodb+srv://<usuario>:<senha>@cluster0...
ADMIN_USER=admin
ADMIN_PASSWORD=thindesk
```
---

### 3. Executar a Aplicação
   Inicie a aplicação pela sua IDE (IntelliJ / Eclipse) executando a classe ThindeskApplication, ou via terminal utilizando o Maven:
```bash
mvn spring-boot:run
```
A API estará disponível em: http://localhost:8080

---

Testando a API (Insomnia / Postman)
Abaixo estão os URL / JSONs prontos para testar o fluxo completo da aplicação.

**1. Abrir um Novo Chamado**
- Método: POST

- URL: http://localhost:8080/api/chamados

- Body (JSON):
```bash
{
  "titulo": "Monitor sem imagem",
  "descricao": "O monitor secundário não liga ao conectar na docking station.",
  "usuario": "usr_gabriel",
  "tipo": "Hardware"
}
```
Retorno (201 Created): Retorna o chamado com o ID gerado pelo MongoDB, a data de abertura automática e o status ABERTO.

---
 
**2. Listar Chamados de um Usuário**
- Método: GET

- URL: http://localhost:8080/api/chamados/usuario/usr_gabriel

Retorno (200 OK): Retorna um array [ ] com todos os chamados abertos por este usuário.

---

**3. Consultar Detalhes de um Chamado por ID**
- Método: GET

- URL: http://localhost:8080/api/chamados/{ID_DO_CHAMADO} (Substitua pelo ID gerado no passo 1)

Retorno (200 OK): Retorna o JSON com todos os dados individuais do chamado.

---

**4. Resolver o Chamado**
- Método: PUT

- URL: http://localhost:8080/api/chamados/{ID_DO_CHAMADO}/resolver

- Body (JSON):
```
{
"solucao": "Substituído o cabo DisplayPort da docking station.",
"tecnico": "tec_suporte"
}
```
Retorno (200 OK): O status muda para RESOLVIDO e a data de resolução é gravada automaticamente.

**Regra de Negócio: Trava de Alteração**
Se você tentar executar o passo 4 (Resolver o Chamado) novamente em um chamado que já está com o status RESOLVIDO, a API bloqueará a ação.

Retorno Esperado: 400 Bad Request - "Regra de Negócio: Chamados já resolvidos não podem ser alterados."