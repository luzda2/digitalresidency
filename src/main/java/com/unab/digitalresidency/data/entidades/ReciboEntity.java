package com.unab.digitalresidency.data.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "recibos")
@EntityListeners(AuditingEntityListener.class) // escuche eventos como el de la fecha automatica

public class ReciboEntity implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @GeneratedValue
    @Column(nullable = false)
    private String numRecibo;

    @Column(nullable = false)
    private String tipoGasto;

    @Column(nullable = false)
    private Date creado;

    @Column(nullable = false)
    private long valor;

    @Column(nullable = false, length = 200)
    private String observacion;

    @ManyToOne
    @JoinColumn(name= "docum_Iden")
    private UsuarioEntity usuarioEntity;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumRecibo() {
        return this.numRecibo;
    }

    public void setNumRecibo(String numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getTipoGasto() {
        return this.tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Date getCreado() {
        return this.creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public long getValor() {
        return this.valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public UsuarioEntity getUsuarioEntity() {
        return this.usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
    
}
