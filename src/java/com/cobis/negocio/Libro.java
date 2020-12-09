package com.cobis.negocio;

import java.sql.Date;

public class Libro {

    private int id;
    private String nombreLibro;
    private String descripcion;
    private String autor;
    private Date fechaPublicacion;
    private int numeroEjemplares;
    private double costo;

    public Libro(int id) {
        this.id = id;
    }
    
    public Libro(int id, String nombreLibro, String descripcion, String autor, Date fechaPublicacion, int numeroEjemplares, double costo) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroEjemplares = numeroEjemplares;
        this.costo = costo;
    }

    public Libro(String nombreLibro, String descripcion, String autor, Date fechaPublicacion, int numeroEjemplares, double costo) {
        this.nombreLibro = nombreLibro;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroEjemplares = numeroEjemplares;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
