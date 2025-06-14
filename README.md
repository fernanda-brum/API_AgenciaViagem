# AgenciaViagemAPI

API REST para gerenciamento de destinos de viagens.

---

## 📦 Requisitos

- Java 17 ou superior
- Gradle (ou use o Gradle Wrapper: `./gradlew` ou `gradlew.bat`)
- IDE recomendada: VS Code ou IntelliJ
- Postman (para testar os endpoints)

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/fernanda-brum/API_AgenciaViagem.git
cd AgenciaViagemAPI
```

### 2. Compile o projeto e baixe dependências

#### Usando o Gradle Wrapper:

- No Linux/macOS:

  ```bash
  ./gradlew build
  ```

- No Windows:

  ```bash
  gradlew.bat build
  ```

### 3. Rode a aplicação

```bash
./gradlew bootRun
```

> Ou abra o projeto no VS Code com a extensão 'Extension Pack for Java' instalada, e vá até a classe 'src\main\java\br\com\senai\agenciaviagem\agenciaviagemapi\AgenciaViagemAppAPI.java' e clique em **Run**.

---

## 🔀 Testando os Endpoints com Postman

### Base URL:

```
http://localhost:8080
```

---

## 📨 Endpoints

### ✅ Criar destino

- **POST** `/destinos`
- **Body JSON:**

```json
{
  "nome": "Fernando de Noronha",
  "local": "Pernambuco",
  "descricao": "Ilha paradisíaca com praias incríveis e natureza preservada."
}
```

---

### 📋 Listar todos os destinos

- **GET** `/destinos`

---

### 🔎 Buscar destinos por nome/local

- **GET** `/destinos/buscar?nome=Noronha&local=Pernambuco`

---

### 🧭 Detalhes do destino (com reservas)

- **GET** `/destinos/1`

---

### ✏️ Avaliar destino

- **POST** `/destinos/1/avaliacao/9`

> Avalia o destino com a nota 9 (de 1 a 10).

---

### ❌ Excluir destino

- **DELETE** `/destinos/1`

---

### 📅 Criar nova reserva

- **POST** `/destinos/1/reservas`
- **Body JSON:**

```json
{
  "nomeCliente": "Ana Souza",
  "quantidadePessoas": 2,
  "dataViagem": "2024-11-15"
}
```

---

### 📋 Listar todas as reservas de um destino

- **GET** `/destinos/1/reservas`

---

### ❌ Excluir uma reserva específica

- **DELETE** `/destinos/1/reservas/3`

---

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Gradle
- REST APIs
- JSON

---

## 💡 Observações

- Certifique-se de que a porta `8080` está livre no seu sistema.
- Use o Postman para testar os endpoints após a aplicação estar rodando.

