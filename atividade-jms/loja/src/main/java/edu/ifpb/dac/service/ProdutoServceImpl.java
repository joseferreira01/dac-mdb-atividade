/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;


import br.edu.ifpb.dac.shared.Produto;
import edu.ifpb.dac.repositorio.RepositorioJPAImpl;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author jose2
 */
@Stateless
@Local(Service.class)
public class ProdutoServceImpl implements Service {
    @EJB
    private  RepositorioJPAImpl<Produto> repositorio;
    
    @Override
     public void add(Produto produto){
         repositorio.add(produto);
     }

    @Override
    public Produto  find(int key){
      return repositorio.find(key, Produto.class);
    }

    @Override
    public List<Produto> findAll(){
        return repositorio.findAll(Produto.class);
    }

    @Override
    public Produto update(Produto produto){
        return repositorio.update(produto);
    }

    @Override
    public void remove(Produto produto){
        repositorio.remove(produto);
        
    }

    //@Override
    public Produto produtoVitrine() {
        List<Produto> lista = findAll();
        Random r = new Random(lista.size());
        return lista.get(r.nextInt());
    }
}
