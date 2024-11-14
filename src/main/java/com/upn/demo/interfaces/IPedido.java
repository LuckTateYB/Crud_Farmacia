package com.upn.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upn.demo.models.Pedido;

@Repository
public interface IPedido extends CrudRepository<Pedido, Integer>{

}
