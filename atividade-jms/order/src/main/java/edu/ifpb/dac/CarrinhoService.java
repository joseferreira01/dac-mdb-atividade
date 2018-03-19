/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac;

import br.edu.ifpb.dac.shared.Cliente;
import br.edu.ifpb.dac.shared.Pedido;
import br.edu.ifpb.dac.shared.Produto;
import javax.ejb.Stateful;

/**
 *
 * @author jose
 */
@Stateful
public class CarrinhoService {

    
    private Pedido pedidos;

    public CarrinhoService() {
    }

    public CarrinhoService(Cliente cliente) {
        this.pedidos =new Pedido() ;
        this.pedidos.setCliente(cliente);
        this.pedidos = pedidos;
    }
    

    public void addProduto(Produto produto) {
        pedidos.add(produto);
    }

    public void remoProduto(Produto produto) {
        pedidos.remove(produto);
    }

    public void finalizr() {

    }
}
