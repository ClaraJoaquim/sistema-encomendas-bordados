# 🧵 Sistema de Gestão de Encomendas de Bordado

Este projeto é um sistema web desenvolvido em **Spring Boot** para gerenciar pedidos de bordados personalizados. Ele permite o cadastro de clientes, itens de bordado, pagamentos e pedidos, com relacionamentos bem definidos entre as entidades.

---

## 📁 Estrutura do Projeto

O sistema contém cinco tabelas principais:

1. **Cliente**
2. **Item** (item de bordado)
3. **Pagamento**
4. **Pedido**
5. **PedidoItem** (relacionamento entre Item e Pedido)

---

## 🧩 Funcionalidades

### 📌 Cliente
- Cadastro de novos clientes
- Atualização de dados
- Listagem de todos os clientes
- Consulta por ID
- Remoção de clientes

### 📌 Item
- Cadastro de itens de bordado
- Atualização de informações
- Listagem de itens disponíveis
- Consulta por ID
- Exclusão de itens

### 📌 Pagamento
- Registro de pagamentos
- Atualização de dados do pagamento
- Listagem e consulta de pagamentos
- Exclusão de registros

### 📌 Pedido
- Criação de pedidos associados a um cliente
- Adição de itens ao pedido
- Associação de pagamento
- Listagem e consulta por ID
- Atualização e remoção

### 🔗 PedidoItem
- Relaciona pedidos com múltiplos itens de bordado
- Gerencia quantidade e detalhes da associação
- Não possui CRUD direto (controlado via Pedido)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.1**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Validation**
- **Maven**

---

## 🖱️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/ClaraJoaquim/sistema-encomendas-bordados

2. Navegue até a pasta do projeto:
   ```bash
   cd sistema-encomendas-bordados

3. Execute a aplicação;

4. Teste a manipulação dos dados através do Postman ou Insomnia
   - Os enpoints estão definidos nos controllers de cada entidade.

5. Visualize o banco de dados H2 em:
    ```bash
   http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (em branco)

---

## 📝 Observações Técnicas

- O projeto utiliza **JPA Query Methods** para facilitar buscas nos repositórios, como:
  - `findByNomeContainingIgnoreCase(String nome)`
  - `findByStatusAndDataCriacaoBetween(...)`
  - `findFirstByClienteIdOrderByDataCriacaoDesc(Long clienteId)`
  - `findByTotalGreaterThan(BigDecimal valor)`

- Tratamento global de erros implementado com:
  - `@ControllerAdvice` e `@ExceptionHandler`

- Conversões de datas com `LocalDate` e `LocalDateTime`

- Uso de **Lambda** e **Streams** para manipulação de coleções

---

## 👩‍💻 Autora

**[Clara Joaquim](https://github.com/ClaraJoaquim)**  
Estudante de Análise e Desenvolvimento de Sistemas, apaixonada por tecnologia e bordados 💻🪡✨

