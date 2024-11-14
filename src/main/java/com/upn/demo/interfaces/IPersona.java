package com.upn.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upn.demo.models.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
