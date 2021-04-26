package com.javaspringclub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javaspringclub.gs_ws.AddUsuarioRequest;
import com.javaspringclub.gs_ws.AddUsuarioResponse;
import com.javaspringclub.gs_ws.DeleteUsuarioRequest;
import com.javaspringclub.gs_ws.DeleteUsuarioResponse;
import com.javaspringclub.gs_ws.GetAllUsuariosRequest;
import com.javaspringclub.gs_ws.GetAllUsuariosResponse;
import com.javaspringclub.gs_ws.GetUsuarioByIdRequest;
import com.javaspringclub.gs_ws.GetUsuarioByIdResponse;
import com.javaspringclub.gs_ws.ServiceStatus;
import com.javaspringclub.gs_ws.UpdateUsuarioRequest;
import com.javaspringclub.gs_ws.UpdateUsuarioResponse;
import com.javaspringclub.gs_ws.UsuarioType;

@Endpoint
public class UsuarioEndpoint {

	public static final String NAMESPACE_URI = "http://www.tell.me/usuarios";

	private UsuarioEntityService service;

	public UsuarioEndpoint() {

	}

	@Autowired
	public UsuarioEndpoint(UsuarioEntityService service) {
		this.service = service;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioByIdRequest")
	@ResponsePayload
	public GetUsuarioByIdResponse getUsuarioById(@RequestPayload GetUsuarioByIdRequest request) {
		GetUsuarioByIdResponse response = new GetUsuarioByIdResponse();
		UsuarioEntity usuarioEntity = service.getEntityById(request.getUsuarioId());
		UsuarioType usuarioType = new UsuarioType();
		BeanUtils.copyProperties(usuarioEntity, usuarioType);
		response.setUsuarioType(usuarioType);
		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsuariosRequest")
	@ResponsePayload
	public GetAllUsuariosResponse getAllUsuarios(@RequestPayload GetAllUsuariosRequest request) {
		GetAllUsuariosResponse response = new GetAllUsuariosResponse();
		List<UsuarioType> usuarioTypeList = new ArrayList<UsuarioType>();
		List<UsuarioEntity> usuarioEntityList = service.getAllEntities();
		for (UsuarioEntity entity : usuarioEntityList) {
			UsuarioType usuarioType = new UsuarioType();
			BeanUtils.copyProperties(entity, usuarioType);
			usuarioTypeList.add(usuarioType);
		}
		response.getUsuarioType().addAll(usuarioTypeList);

		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUsuarioRequest")
	@ResponsePayload
	public AddUsuarioResponse addUsuario(@RequestPayload AddUsuarioRequest request) {
		AddUsuarioResponse response = new AddUsuarioResponse();
		UsuarioType newUsuarioType = new UsuarioType();
		ServiceStatus serviceStatus = new ServiceStatus();

		UsuarioEntity newUsuarioEntity = new UsuarioEntity(request.getNombre(), request.getTipo());
		UsuarioEntity savedUsuarioEntity = service.addEntity(newUsuarioEntity);

		if (savedUsuarioEntity == null) {
			serviceStatus.setStatusCode("CONFLICTO");
			serviceStatus.setMessage("Excepción al agregar Entidad");
		} else {

			BeanUtils.copyProperties(savedUsuarioEntity, newUsuarioType);
			serviceStatus.setStatusCode("ÉXITO");
			serviceStatus.setMessage("Contenido agregado con éxito");
		}

		response.setUsuarioType(newUsuarioType);
		response.setServiceStatus(serviceStatus);
		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUsuarioRequest")
	@ResponsePayload
	public UpdateUsuarioResponse updateUsuario(@RequestPayload UpdateUsuarioRequest request) {
		UpdateUsuarioResponse response = new UpdateUsuarioResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		// 1. Find if movie available
		UsuarioEntity usuarioFromDB = service.getEntityByNombre(request.getNombre());
		
		if(usuarioFromDB == null) {
			serviceStatus.setStatusCode("No encontrada");
			serviceStatus.setMessage("Usuario = " + request.getNombre() + " no encontrado (a)");
		}else {
			
			// 2. Get updated movie information from the request
			usuarioFromDB.setNombre(request.getNombre());
			//usuarioFromDB.setTipo(request.getTipo());
			// 3. update the movie in database
			
			boolean flag = service.updateEntity(usuarioFromDB);
			
			if(flag == false) {
				serviceStatus.setStatusCode("CONFLICTO");
				serviceStatus.setMessage("Excepción al actualizar la entidad=" + request.getNombre());;
			}else {
				serviceStatus.setStatusCode("ÉXITO");
				serviceStatus.setMessage("Contenido actualizado con éxito");
			}
			
			
		}
		
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUsuarioRequest")
	@ResponsePayload
	public DeleteUsuarioResponse deleteUsuario(@RequestPayload DeleteUsuarioRequest request) {
		DeleteUsuarioResponse response = new DeleteUsuarioResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		boolean flag = service.deleteEntityById(request.getUsuarioId());

		if (flag == false) {
			serviceStatus.setStatusCode("FALLIDO");
			serviceStatus.setMessage("Excepción al eliminar ID de la entidad=" + request.getUsuarioId());
		} else {
			serviceStatus.setStatusCode("ÉXITO");
			serviceStatus.setMessage("Contenido eliminado correctamente");
		}

		response.setServiceStatus(serviceStatus);
		return response;
	}

}
