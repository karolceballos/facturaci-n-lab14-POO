package org.example.model;

public class Item {

    private String nombre;
    private Integer cantidad;
    private Integer precio_unitario;
    private float precio;
    //----------------------------------------------------------------------------------------------------------------------

    public Item(String nombre, Integer cantidad, Integer precio_unitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    //-------------------------------------------------------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Integer precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }






}

