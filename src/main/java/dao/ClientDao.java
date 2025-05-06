/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Client;

/**
 *
 * @author Family
 */
public class ClientDao {

    private final Connection connection;

    public ClientDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addClient(Client client) {
        String sql = "INSERT INTO clientes (cpf, nome, email, telefone, endereco, data_nascimento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getCpf());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setString(5, client.getAddress());
            stmt.setDate(6, new java.sql.Date(client.getBirthdate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar cliente.", e);
        }
    }

    public int updateClient(Client client) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, endereco = ?, data_nascimento = ? WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getAddress());
            stmt.setDate(5, new java.sql.Date(client.getBirthdate().getTime()));
            stmt.setString(6, client.getCpf());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente.", e);
        }
    }

    public int deleteClient(String cpf) {
        String sql = "DELETE FROM clientes WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente com CPF: " + cpf, e);
        }
    }

    public Client getClientByCpf(String cpf) {
        String sql = "SELECT cpf, nome, email, telefone, endereco, data_nascimento FROM clientes WHERE cpf = ?";
        Client client = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                client = mapResultSetToClient(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente com CPF: " + cpf, e);
        }

        return client;
    }

    private Client mapResultSetToClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setCpf(rs.getString("cpf"));
        client.setName(rs.getString("nome"));
        client.setEmail(rs.getString("email"));
        client.setPhone(rs.getString("telefone"));
        client.setAddress(rs.getString("endereco"));
        client.setBirthdate(rs.getDate("data_nascimento"));

        return client;
    }
}