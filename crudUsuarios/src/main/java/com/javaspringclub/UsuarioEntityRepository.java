package com.javaspringclub;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEntityRepository extends CrudRepository<UsuarioEntity, Long> {

	public UsuarioEntity findByNombre(String nombre);
}
