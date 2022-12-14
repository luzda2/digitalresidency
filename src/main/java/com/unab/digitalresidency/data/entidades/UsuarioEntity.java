package com.unab.digitalresidency.data.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "usuario")
@Table(indexes = {
    @Index(columnList = "idUsuario", name = "index_idUsuario", unique = true),
    @Index(columnList = "documIden", name = "index_documIden", unique = true),
    @Index(columnList = "username", name = "index_username", unique = true)
})

public class UsuarioEntity implements Serializable {
 
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String idUsuario;

    @Column(nullable=false, length = 10)
    private String documIden;
    
    @Column(nullable=false, length = 100)
    private String nombre;
    
    @Column(nullable=false, length = 100)
    private String apellido;
    
    @Column(nullable=false, length = 2)
    private String casa;
    
    @Column(nullable=false, length = 50)
    private String email;
    
    @Column(nullable=false, length = 10)
    private String username;

    @Column(nullable=false, length = 20)
    private String password;
    
    @Column(nullable=false)
    private String passwordEncriptada;
    
    @Column(nullable=false, length = 11)
    private String telefono;
    
    @Column(nullable=false, length = 10)
    private String rol;
    
    @Column(nullable=false, length = 10)
    private String inicio;
    
    @Column(nullable=false, length = 10)
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEntity")
    public List<FacAdmonEntity> facAdmonEntityList = new ArrayList<>();


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCasa() {
        return this.casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordEncriptada() {
        return this.passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getInicio() {
        return this.inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<FacAdmonEntity> getFacAdmonEntityList() {
        return this.facAdmonEntityList;
    }

    public void setFacAdmonEntityList(List<FacAdmonEntity> facAdmonEntityList) {
        this.facAdmonEntityList = facAdmonEntityList;
    }

}
