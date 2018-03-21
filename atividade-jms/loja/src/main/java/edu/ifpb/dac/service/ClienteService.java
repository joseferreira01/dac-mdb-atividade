/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;

import br.edu.ifpb.dac.shared.Cliente;
import java.util.List;

/**
 *
 * @author jose
 */
public interface ClienteService {

    void add(Cliente c);

    Cliente find(int key);

    List<Cliente> findAll();

    void remove(Cliente c);

    Cliente update(Cliente c);
    
}
