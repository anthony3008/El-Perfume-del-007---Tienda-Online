package com.perfumeshop.model;

import java.util.List;

public class Perfume {
    private String id;
    private String nombre;
    private String descripcion;
    private String origen;
    private double precio;
    private String categoria; // HOMBRE, MUJER, MIXTO
    private List<String> imagenes; // Lista de 3 URLs

    public Perfume() {}

    public Perfume(String id, String nombre, String descripcion, String origen, double precio, String categoria, List<String> imagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.origen = origen;
        this.precio = precio;
        this.categoria = categoria;
        this.imagenes = imagenes;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public List<String> getImagenes() { return imagenes; }
    public void setImagenes(List<String> imagenes) { this.imagenes = imagenes; }
}