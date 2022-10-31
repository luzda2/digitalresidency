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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "facAdmon")

@EntityListeners(AuditingEntityListener.class) // escuche eventos como el de la fecha automatica
public class FacAdmonEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @GeneratedValue
    @Column(nullable = false)
    private String numFac;

    @CreatedDate
    private Date fecha;

    @Column(nullable = false)
    private String mensualidad;

    @Column(nullable = false)
    private long valor;

    @Column(nullable = false)
    private String tipoAbono;

    @ManyToOne
    @JoinColumn(name= "docum_Iden")
    private UsuarioEntity usuarioEntity;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumFac() {
        return this.numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensualidad() {
        return this.mensualidad;
    }

    public void setMensualidad(String mensualidad) {
        this.mensualidad = mensualidad;
    }

    public long getValor() {
        return this.valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getTipoAbono() {
        return this.tipoAbono;
    }

    public void setTipoAbono(String tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public UsuarioEntity getUsuarioEntity() {
        return this.usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
    

}
