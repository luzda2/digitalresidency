package com.unab.digitalresidency.models.respuestas;

public class UsuarioDataRestModel { // se convierte en Json para entregarsela al cliente
 
    private String idUsuario;
    private String casa;
    private String documIden;
    private String nombre;
    private String apellido;
    private String email;
    private String password;


    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCasa() {
        return this.casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getDocumIden() {
        return this.documIden;
    }

    public void setDocumIden(String documIden) {
        this.documIden = documIden;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
