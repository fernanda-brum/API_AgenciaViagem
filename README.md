# AgenciaViagemAPI

API REST para gerenciamento de destinos de viagens.

---

## 📦 Requisitos

- Java 17 ou superior
- Gradle (ou use o Gradle Wrapper: `./gradlew` ou `gradlew.bat`)
- **PostgreSQL:** Uma instância do banco de dados PostgreSQL rodando (preferencialmente na porta padrão 5432).
- IDE recomendada: VS Code ou IntelliJ
- Postman (para testar os endpoints)

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone [https://github.com/fernanda-brum/API_AgenciaViagem.git](https://github.com/fernanda-brum/API_AgenciaViagem.git)
cd AgenciaViagemAPI
````
### 2. Configure o Banco de Dados

    Antes de rodar a aplicação, certifique-se de que você tem uma instância do PostgreSQL rodando e que as credenciais no src/main/resources/application.properties correspondem às do seu banco de dados.

Exemplo de application.properties:
```
Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/agenciaviagem
spring.datasource.username=postgres
spring.datasource.password=123
 ... outras configurações
 
```


### 3. Compile o projeto e baixe dependências
Usando o Gradle Wrapper:

```
./gradlew build
```
```
./gradlew bootRun

```


    Ou abra o projeto no VS Code com a extensão 'Extension Pack for Java' instalada, e vá até a classe 'src\main\java\br\com\senai\agenciaviagem\agenciaviagemapi\AgenciaViagemAppAPI.java' e clique em Run.

🔀 Testando os Endpoints com Postman
Base URL:

http://localhost:8080

🔒 Autenticação para as Requisições

Esta API requer autenticação Basic Auth para a maioria dos endpoints. Use as seguintes credenciais:

    Username: admin
    Password: password

Como configurar no Postman:

Para cada requisição que você for fazer (POST, GET, DELETE), siga estes passos no Postman:

    Na aba da requisição, clique em Authorization.
    No campo TYPE, selecione **`Basic Auth``.
    Preencha o Username com admin.
    Preencha o Password com password.

Após configurar, o Postman irá automaticamente incluir o cabeçalho de autenticação nas suas requisições.
📨 Endpoints
✅ Criar destino

    POST /destinos
    Autenticação: Necessária (Basic Auth)
    Body JSON:

<!-- end list -->
JSON

{
  "nome": "Fernando de Noronha",
  "local": "Pernambuco",
  "descricao": "Ilha paradisíaca com praias incríveis e natureza preservada."
}

📋 Listar todos os destinos

    GET /destinos
    Autenticação: Necessária (Basic Auth)

🔎 Buscar destinos por nome/local

    GET /destinos/buscar?nome=Noronha&local=Pernambuco
    Autenticação: Necessária (Basic Auth)

🧭 Detalhes do destino (com reservas)

    GET /destinos/1
    Autenticação: Necessária (Basic Auth)

✏️ Avaliar destino

    POST /destinos/1/avaliacao/9
    Autenticação: Necessária (Basic Auth)

    Avalia o destino com a nota 9 (de 1 a 10).

❌ Excluir destino

    DELETE /destinos/1
    Autenticação: Necessária (Basic Auth)

📅 Criar nova reserva

    POST /destinos/1/reservas
    Autenticação: Necessária (Basic Auth)
    Body JSON:

<!-- end list -->
JSON

{
  "nomeCliente": "Ana Souza",
  "quantidadePessoas": 2,
  "dataViagem": "2024-11-15"
}

📋 Listar todas as reservas de um destino

    GET /destinos/1/reservas
    Autenticação: Necessária (Basic Auth)

❌ Excluir uma reserva específica

    DELETE /destinos/1/reservas/3
    Autenticação: Necessária (Basic Auth)

🛠️ Tecnologias

    Java 17
    Spring Boot
    Gradle
    REST APIs
    JSON
    PostgreSQL

💡 Observações

    Certifique-se de que a porta 8080 está livre no seu sistema.
    É necessário ter uma instância do PostgreSQL rodando, preferencialmente na porta padrão (5432), para que a aplicação possa se conectar ao banco de dados.
    Use o Postman para testar os endpoints após a aplicação estar rodando.
    Caso encontre problemas de autenticação (erro 401), verifique as credenciais admin:password na seção Authorization do Postman e também a configuração de segurança da API em seu código Spring Boot (geralmente via Spring Security).