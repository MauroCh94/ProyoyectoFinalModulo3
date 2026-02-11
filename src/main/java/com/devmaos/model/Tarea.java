package com.devmaos.model;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public int getId() {
        return id;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String estado = completada ? "Completada" : "Pendiente";
        return id + ": " + titulo + " - " + descripcion + " [" + estado + "]";
    }



}
