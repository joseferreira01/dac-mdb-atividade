/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;


import br.edu.ifpb.dac.shared.Cliente;
import br.edu.ifpb.dac.shared.Produto;
import edu.ifpb.dac.repositorio.RepositorioJPAImpl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author jose2
 */
@Stateless
@Local(ClienteService.class)
public class ClienteServceImpl implements ClienteService  {
    @EJB
    private  RepositorioJPAImpl<Cliente> repositorio;
    
    @Override
     public void add(Cliente c){
         repositorio.add(c);
     }

    @Override
    public Cliente  find(int key){
      return repositorio.find(key, Cliente.class);
    }

    @Override
    public List<Cliente> findAll(){
        return repositorio.findAll(Cliente.class);
    }

    
    @Override
    public Cliente update(Cliente c){
        return repositorio.update(c);
    }

    
    @Override
    public void remove(Cliente c){
        repositorio.remove(c);
        
    }
}
