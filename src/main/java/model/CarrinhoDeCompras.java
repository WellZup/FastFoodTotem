package model;

import connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoDeCompras {
    private Map<String, Integer> itens;
    private static final Map<String, Double> precos = new HashMap<>();



    public CarrinhoDeCompras() {
        this.itens = new HashMap<>();
        carregarPrecosDoBancoDeDados();
    }

    private void carregarPrecosDoBancoDeDados() {
        try (Connection connection = Conexao.getConnection()) {
            String query = "SELECT nome, valor FROM lanche";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                precos.put(nome, valor);
            }

            query = "SELECT nome, valor FROM bebida";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                precos.put(nome, valor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void adicionarItem(String item, int quantidade) {
        itens.put(item, itens.getOrDefault(item, 0) + quantidade);
    }

    public void removerItem(String item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : itens.entrySet()) {
            String item = entry.getKey();
            int quantidade = entry.getValue();
            double preco = precos.get(item);
            total += quantidade * preco;
        }
        return total;
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    public static int criarCarrinhoNoBancoDeDados(double total) {
        int carrinhoId = -1;
        try (Connection connection = Conexao.getConnection()) {
            String query = "INSERT INTO carrinho (valor_total) VALUES (?) RETURNING id";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, total);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carrinhoId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinhoId;
    }

    // Inserir o item no carrinho no banco de dados
    public static void inserirItemNoBancoDeDados(int carrinhoId, int opcao, int quantidade) {
        try (Connection connection = Conexao.getConnection()) {
            String tabela;
            String campo;
            if (opcao == 1 || opcao == 2) {
                tabela = "lanche";
                campo = "lanche_id";
            } else {
                tabela = "bebida";
                campo = "bebida_id";
            }

            String query = "INSERT INTO item_carrinho (carrinho_id, " + campo + ", quantidade) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, carrinhoId);
            ps.setInt(2, opcao);
            ps.setInt(3, quantidade);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

