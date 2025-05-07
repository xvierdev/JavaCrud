# CRUD de Cadastro de Clientes com Banco de Dados

Este repositório contém o código-fonte de um sistema de Cadastro de Clientes desenvolvido em Java, conforme os requisitos especificados no enunciado. O sistema implementa as operações CRUD (Create, Read, Update, Delete) para o gerenciamento de dados de clientes, armazenando-os em um banco de dados MySQL.

## Funcionalidades Implementadas

* **Cadastro de Cliente (Create):** Permite o cadastro de novos clientes com os seguintes dados:
    * Nome (String)
    * CPF (String) - Validação de formato implementada.
    * E-mail (String) - Validação de formato implementada.
    * Telefone (String) - Validação de formato implementada.
    * Endereço (String)
    * Data de Nascimento (Date) - Armazenada no formato AAAA-MM-DD.
    * Garante a unicidade do CPF, impedindo cadastros duplicados.

* **Visualização de Cliente (Read):**
    * Permite visualizar todos os clientes cadastrados.
    * Permite buscar clientes por CPF ou nome, exibindo todas as suas informações, incluindo a data de nascimento.

* **Alteração de Cliente (Update):**
    * Permite a edição dos dados de um cliente existente, com exceção do CPF (imutável).
    * Possibilita a atualização de todos os outros campos, incluindo a data de nascimento.

* **Exclusão de Cliente (Delete):**
    * Permite a remoção de um cliente do banco de dados através do seu CPF.

* **Validação e Tratamento de Erros:**
    * Validação robusta dos dados de entrada, incluindo formato de CPF, telefone, e-mail e data de nascimento.
    * Garante que campos obrigatórios não sejam cadastrados em branco.
    * Apresentação de mensagens de erro claras e informativas para diversas situações, como tentativas de cadastrar CPF duplicado, excluir cliente inexistente ou editar com CPF inválido.

## Requisitos Técnicos Cumpridos

* **Linguagem de Programação:** Java
* **Paradigma de Programação:** Orientação a Objetos (OO)
* **Sistema de Gerenciamento de Banco de Dados (SGBD):** MySQL
* **Conexão com o Banco de Dados:** JDBC (Java Database Connectivity)
* **Gerenciamento de Dependências e Build:** Maven

## Estrutura do Banco de Dados

Foi criada uma tabela chamada `clientes` no banco de dados MySQL com a seguinte estrutura:

| Campo            | Tipo         | Atributos                      |
| ---------------- | ------------ | ------------------------------ |
| `id`             | INT          | AUTO\_INCREMENT, PRIMARY KEY |
| `nome`           | VARCHAR      |                                |
| `cpf`            | VARCHAR      | UNIQUE                         |
| `email`          | VARCHAR      |                                |
| `telefone`       | VARCHAR      |                                |
| `endereco`       | VARCHAR      |                                |
| `data_nascimento`| DATE         |                                |

## Ambiente de Desenvolvimento

Este projeto foi desenvolvido utilizando o ambiente de desenvolvimento integrado **NetBeans**.

## Driver JDBC

Para a conexão com o banco de dados MySQL, foi utilizado o driver JDBC apropriado. As dependências do driver são gerenciadas pelo Maven no arquivo `pom.xml`.

## Como Executar o Projeto

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) instalado.
    * MySQL Server instalado e em execução.
    * Uma base de dados MySQL criada (você pode adaptar as configurações de conexão no código).
    * NetBeans instalado (opcional, mas o projeto foi desenvolvido nele).

2.  **Clonar o Repositório (se aplicável):**
    ```bash
    git clone [https://github.com/xvierdev/JavaCrud](https://github.com/xvierdev/JavaCrud)
    cd [JavaCrud]
    ```

3.  **Configurar a Conexão com o Banco de Dados:**
    * Localize o arquivo de configuração de conexão com o banco de dados no projeto Java (geralmente em uma classe de utilitários ou arquivo de propriedades).
    * Atualize as informações de conexão (URL do banco de dados, nome de usuário, senha) para corresponder à sua configuração do MySQL.

4.  **Construir o Projeto (com Maven):**
    * Abra um terminal ou prompt de comando na raiz do projeto.
    * Execute o seguinte comando Maven:
        ```bash
        mvn clean install
        ```

5.  **Executar o Projeto:**
    * Abra o projeto no NetBeans.
    * Localize a classe principal (geralmente com um método `main`).
    * Execute a classe principal no NetBeans.

    Ou, se preferir executar fora do NetBeans após a construção com Maven:
    * Navegue até o diretório onde o arquivo JAR executável foi gerado (geralmente em `target`).
    * Execute o JAR utilizando o seguinte comando:
        ```bash
        java -jar [nome do arquivo JAR].jar
        ```

## Autor

Wesley Xavier  
Turma: ADS - 2  
Professora: Juliana Forin Pasquini Martinez  
Data: 31/03/2025