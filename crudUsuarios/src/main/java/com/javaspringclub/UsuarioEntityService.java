package com.javaspringclub;

import java.util.List;

public interface UsuarioEntityService {

	public UsuarioEntity getEntityById(long id);
	public UsuarioEntity getEntityByTitle(String title);
	public List<UsuarioEntity> getAllEntities();
	public UsuarioEntity addEntity(UsuarioEntity entity);
	public boolean updateEntity(UsuarioEntity entity);
	public boolean deleteEntityById(long id);
}
