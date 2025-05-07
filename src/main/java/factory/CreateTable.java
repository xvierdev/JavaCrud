package factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {
        final Connection connection;
        try {
            connection = new ConnectionFactory().getConnection();
            System.out.println("Conexão estabelecida com sucesso!");

            // Cria um Statement para executar comandos SQL
            try (Statement statement = connection.createStatement()) {
                String useDatabaseSQL = "USE cadastro";
                statement.executeUpdate(useDatabaseSQL);

                String createTableSQL = "CREATE TABLE IF NOT EXISTS clientes ("
                        + "cpf VARCHAR(15) PRIMARY KEY, "
                        + "nome VARCHAR(30) NOT NULL, "
                        + "email VARCHAR(50) NOT NULL, "
                        + "telefone VARCHAR(15) NOT NULL, "
                        + "endereco VARCHAR(255) NOT NULL, "
                        + "data_nascimento DATE NOT NULL"
                        + ")";
                // Executa o comando para criar a tabela
                statement.executeUpdate(createTableSQL);
                System.out.println("Tabela 'clientes' criada com sucesso!");
                // Fecha o Statement e a Conexão
            }
            connection.close();

        } catch (SQLException e) {
            System.err.println("Erro durante a operação no banco de dados: " + e.getMessage());
        }
    }
}
