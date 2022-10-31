package com.unab.digitalresidency.services;

import com.unab.digitalresidency.shared.UsuarioDto;


public interface IUsuarioServices {
    
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto); // objeto Dto es el intermediario
    public UsuarioDto leerUsuario(String username); // leer usuario le enviamos el username para que lo traiga

}
