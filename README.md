# 📚 Plataforma de Upskilling - Global Solution 2025

## 👥 Integrantes

- **Lucca Alexandre** - RM 99700
- **Victor Wittner** - RM 98667

---

## 🎯 Sobre o Projeto

Plataforma de gestão de capacitação profissional alinhada aos **ODS 4 (Educação de Qualidade)** e **ODS 8 (Trabalho Decente)**, facilitando upskilling/reskilling através de trilhas de aprendizado personalizadas.

---

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **H2 Database**
- **Maven**
- **Swagger UI**

---

## 🚀 Como Executar

```bash
mvn clean compile
mvn spring-boot:run
```

**Acessar:**
- Interface Web: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- Console H2: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:upskillingdb`
  - Username: `sa`
  - Password: *(vazio)*

---

## 📡 Endpoints da API

### Usuários (`/api/usuarios`)
- `GET /api/usuarios` - Lista todos
- `GET /api/usuarios/{id}` - Busca por ID
- `POST /api/usuarios` - Cria novo
- `PUT /api/usuarios/{id}` - Atualiza
- `DELETE /api/usuarios/{id}` - Remove

### Trilhas (`/api/trilhas`)
- `GET /api/trilhas` - Lista todas
- `GET /api/trilhas/{id}` - Busca por ID
- `POST /api/trilhas` - Cria nova
- `PUT /api/trilhas/{id}` - Atualiza
- `DELETE /api/trilhas/{id}` - Remove

### Competências (`/api/competencias`)
- `GET /api/competencias` - Lista todas
- `GET /api/competencias/{id}` - Busca por ID
- `POST /api/competencias` - Cria nova
- `PUT /api/competencias/{id}` - Atualiza
- `DELETE /api/competencias/{id}` - Remove

### Matrículas (`/api/matriculas`)
- `GET /api/matriculas` - Lista todas
- `GET /api/matriculas/{id}` - Busca por ID
- `POST /api/matriculas` - Cria nova
- `PUT /api/matriculas/{id}` - Atualiza
- `GET /api/matriculas/usuario/{usuarioId}` - Por usuário

---

## 📊 Modelo de Dados

**4 Entidades:** Usuario, Trilha, Competencia, Matricula

**Relacionamentos:**
- Usuario ↔ Matricula (1:N)
- Trilha ↔ Matricula (1:N)
- Trilha ↔ Competencia (N:M)

---

## ✅ Requisitos Atendidos

- ✅ 4 Entidades JPA com relacionamentos
- ✅ 4 Repositories Spring Data JPA
- ✅ 4 Services com lógica de negócio
- ✅ 4 Controllers REST completos
- ✅ Tratamento de exceções customizado
- ✅ Validações com Bean Validation
- ✅ Interface Web funcional
- ✅ Swagger UI documentado
- ✅ Alinhamento com ODS 4 e 8

---

**FIAP - Global Solution 2025 | Novembro 2025**
