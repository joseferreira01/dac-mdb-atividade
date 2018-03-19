/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.repositorio;

import java.util.List;

/**
 *
 * @author jose
 */
public interface Repository<T> {

//    void salvar(T entity);
//
//    void atualizar(T entity);
//
//    void deletar(int chavePrimaria);
///**
 
 
    T buscar(String atributo, Object valor);

    List<T> buscarTodos();

}
