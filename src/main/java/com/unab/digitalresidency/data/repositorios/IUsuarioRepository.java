package com.unab.digitalresidency.data.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.digitalresidency.data.entidades.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> { // permite aislar las consultas del controlador
 
    public UsuarioEntity findByDocumIden(String documIden);
    public UsuarioEntity findBynombre(String nombre);
    public UsuarioEntity findByapellido(String apellido);
    public UsuarioEntity findByusername(String username);

}
