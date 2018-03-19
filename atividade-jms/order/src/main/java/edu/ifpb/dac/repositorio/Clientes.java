/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.repositorio;

import br.edu.ifpb.dac.shared.Cliente;
import edu.ifpb.dac.conexao.Conexao;
import edu.ifpb.dac.conexao.DataBaseException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Clientes implements Repository<Cliente> {

    private Conexao conn;
    PreparedStatement stat;

    @Override
    public Cliente buscar(String atributo, Object valor) {
         StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM cliente");
        List<Cliente> resutado = null;
        try {
            resutado = queryBD(sql.toString());
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado.get(0);
    }

    @Override
    public List<Cliente> buscarTodos() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM cliente");
        List<Cliente> resutado = null;
        try {
            resutado = queryBD(sql.toString());
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado;
    }

    private List<Cliente> montarCliente(ResultSet rs) throws ParseException, SQLException {
        List<Cliente> list = new ArrayList<>();
        while (rs.next()) {
            Cliente novo = new Cliente(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email")
            );
            list.add(novo);

        }
        if (!list.isEmpty()) {

            return list;
        }
        return Collections.EMPTY_LIST;

    }

    private List<Cliente> queryBD(String query) throws URISyntaxException, ParseException, IOException, ClassNotFoundException, DataBaseException, SQLException {

        List<Cliente> result = null;
        Connection connection = conn.init();
        try {
            //  System.err.println("try list");
            System.err.println("sql " + query);
            stat = connection.prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            // System.err.println("passou conn");
            result = montarCliente(rs);

        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.fecharConexao(connection);
        }

        return result;
    }
}
