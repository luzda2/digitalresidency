package com.unab.digitalresidency.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.digitalresidency.models.peticiones.UsuarioCrearRequestModel;
import com.unab.digitalresidency.models.respuestas.UsuarioDataRestModel;
import com.unab.digitalresidency.services.IUsuarioServices;
import com.unab.digitalresidency.shared.UsuarioDto;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired //tomar todos los objetos, ponerlos globales en todo el proyecto, sin necesidad de instanciarlos
    ModelMapper modelMapper;

    @Autowired
    IUsuarioServices iUsuarioServices;

    @GetMapping  // obtener informacion de un usuario
    public String leerUsuario(){
        return "Digital Residency";
    }
    @PostMapping // crear un  usuario
    public UsuarioDataRestModel crearUsuario(@RequestBody UsuarioCrearRequestModel usuarioCrearRequestModel){

        UsuarioDto usuarioCrearDto= modelMapper.map(usuarioCrearRequestModel, UsuarioDto.class);// se filtra y utilizo solo los que quiero
        UsuarioDto usuarioDto = iUsuarioServices.crearUsuario(usuarioCrearDto); // aqui lo estoy mandando el que acabe de mapear
        
        UsuarioDataRestModel usuarioDataRestModel = modelMapper.map(usuarioDto, UsuarioDataRestModel.class);
        
        return usuarioDataRestModel;
        
       // return "Ha creado un usuario con exito";
    }
    
}
