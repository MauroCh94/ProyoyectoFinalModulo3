package com.devmaos.service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devmaos.model.Tarea;
import com.devmaos.exceptions.InvalidTareaException;

public class tareaservice {

    private static final Logger LOG = LoggerFactory.getLogger(tareaservice.class);
    
    private List<Tarea> tareas;

    public tareaservice() {
        tareas = new ArrayList<>();
    }   

    public void agregarTarea(int id, String titulo, String descripcion,boolean completada) {
        LOG.info("Agregando tarea con ID: " + id);

        
        // Validaciones de dominio
        if (id <= 0) {
            LOG.warn("ID inválido al agregar tarea: {}", id);
            throw new InvalidTareaException("El ID debe ser un entero positivo.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            LOG.warn("Título inválido al agregar tarea. ID: {}", id);
            throw new InvalidTareaException("El título no puede estar vacío.");
        }
        
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                LOG.warn("Intento de agregar tarea con ID duplicado: " + id);
                throw new InvalidTareaException("Ya existe una tarea con el ID " + id);
            }
        }
        tareas.add(new Tarea(id, titulo, descripcion));
        LOG.info("Tarea agregada exitosamente: " + id);
    }


    public List<Tarea> listaTareas() {
        LOG.info("Listando todas las tareas");
        return tareas;
    }

    public void marcarCompletada(int id) {
        LOG.info("Marcando tarea como completada con ID: " + id);
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                break;
            }
        }
    }
    public void eliminarTarea(int id) {
        LOG.info("Eliminando tarea con ID: " + id);
        tareas.removeIf(tarea -> tarea.getId() == id);
    }
}
