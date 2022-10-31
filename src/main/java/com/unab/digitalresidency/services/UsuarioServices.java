package com.unab.digitalresidency.services;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unab.digitalresidency.data.entidades.UsuarioEntity;
import com.unab.digitalresidency.data.repositorios.IUsuarioRepository;
import com.unab.digitalresidency.shared.UsuarioDto;

@Service // debo decirle que es un servicio
public class UsuarioServices implements IUsuarioServices {

    @Autowired //tomar todos los objetos, ponerlos globales en todo el proyecto, sin necesidad de instanciarlos
    ModelMapper modelMapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository; // Por que vamos a usar el repositorio que tiene el codigo sql

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioCrearDto) {
        
        System.out.println(usuarioCrearDto);

        if(iUsuarioRepository.findByDocumIden(usuarioCrearDto.getDocumIden()) !=null){
            throw new RuntimeException("Este documento ya existe");
        }

        if(iUsuarioRepository.findBynombre(usuarioCrearDto.getNombre()) !=null){
            throw new RuntimeException("Este nombre ya existe");
        }

        if(iUsuarioRepository.findByapellido(usuarioCrearDto.getApellido()) !=null){
            throw new RuntimeException("Este apellido ya existe");
        }

        UsuarioEntity usuarioEntityDto = modelMapper.map(usuarioCrearDto, UsuarioEntity.class);
        usuarioEntityDto.setIdUsuario(UUID.randomUUID().toString());
        usuarioEntityDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));

        UsuarioEntity usuarioEntity = iUsuarioRepository.save(usuarioEntityDto); // envio a la tabla el usuario creado ya mapeado

        UsuarioDto usuarioDto = modelMapper.map(usuarioEntity, UsuarioDto.class);
        return usuarioDto; // se retorna al controlador que hizo el llamado
    }

    @Override
    public UsuarioDto leerUsuario(String username) {
        
        UsuarioEntity usuarioEntity=iUsuarioRepository.findByusername(username);
        
        if(usuarioEntity==null){
            throw new UsernameNotFoundException(username);
        }

        UsuarioDto usuarioDto= modelMapper.map(usuarioEntity,UsuarioDto.class);
        
        return usuarioDto;
    }
    
}
