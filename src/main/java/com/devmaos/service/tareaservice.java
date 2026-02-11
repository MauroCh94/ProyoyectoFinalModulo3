package com.devmaos.service;
import java.util.ArrayList;
import java.util.List;
import com.devmaos.model.Tarea;
// aqui hacemos todos los requerimientos de la logica de negocio, como crear tareas, marcar como completada, eliminar, etc.
public class tareaservice {
    
    private List<Tarea> tareas;

    public tareaservice() {
        tareas = new ArrayList<>();
    }   

    public void agregarTarea(int id, String titulo, String descripcion,boolean completada) {
//manejo de excepciones.
        tareas.add(new Tarea(id, titulo, descripcion));
    }
    public List<Tarea> listaTareas() {
        return tareas;
    }

    public void marcarCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                break;
            }
        }
    }
    public void eliminarTarea(int id) {
        tareas.removeIf(tarea -> tarea.getId() == id);
    }
}
