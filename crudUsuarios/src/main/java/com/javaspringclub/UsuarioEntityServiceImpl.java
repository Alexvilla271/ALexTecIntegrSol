package com.javaspringclub;

//import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioEntityServiceImpl implements UsuarioEntityService {

	@Override
	public UsuarioEntity getEntityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity getEntityByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity addEntity(UsuarioEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEntity(UsuarioEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntityById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*private UsuarioEntityRepository repository;
	
	public UsuarioEntityServiceImpl() {
		
	}
	
	@Autowired
	public UsuarioEntityServiceImpl(UsuarioEntityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UsuarioEntity getEntityById(long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public UsuarioEntity getEntityByNombre(String nombre) {
		return this.repository.findByNombre(nombre);
	}

	@Override
	public List<UsuarioEntity> getAllEntities() {
		List<UsuarioEntity> list = new ArrayList<>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public UsuarioEntity addEntity(UsuarioEntity entity) {
		try {
			return  this.repository.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateEntity(UsuarioEntity entity) {
		try {
		   this.repository.save(entity);
		   return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEntityById(long id) {
		try {
			this.repository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public UsuarioEntity getEntityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity getEntityByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioEntity addEntity(UsuarioEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEntity(UsuarioEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}*/

	

}
