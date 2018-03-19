/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.repositorio;

import br.edu.ifpb.dac.shared.Cliente;
import java.util.List;

/**
 *
 * @author jose
 */
public class Pedidos implements Repository<Cliente>{

    @Override
    public Cliente buscar(String atributo, Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
