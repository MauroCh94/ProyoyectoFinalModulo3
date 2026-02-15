package com.devmaos.service;
import com.devmaos.model.Tarea;
import com.devmaos.exceptions.InvalidTareaException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class tareaserviceTest {

    private tareaservice servicio;

    @BeforeEach
    void setUp() {
        servicio = new tareaservice();
    }

    @Test
    @DisplayName("Test para agregar una tarea")
    void testAgregarTarea() {
        servicio.agregarTarea(1, "Tarea 1", "Descripción de la tarea 1", false);
        assertEquals(1, servicio.listaTareas().size());
        assertEquals("Tarea 1", servicio.listaTareas().get(0).getTitulo());
    }

    @Test
    @DisplayName("Test para marcar una tarea como completada")
    public void testMarcarTareaCompletada() {
        servicio.agregarTarea(2, "Tarea 2", "Descripción de la tarea 2", false);
        servicio.marcarCompletada(2);
        assertTrue(servicio.listaTareas().get(0).isCompletada());
    }

    @Test
    @DisplayName("Test para eliminar una tarea")
    public void testEliminarTarea() {
        servicio.agregarTarea(3, "Tarea 3", "Descripción de la tarea 3", false);
        servicio.eliminarTarea(3);
        assertTrue(servicio.listaTareas().isEmpty());
    }

    @Test
    @DisplayName("Test para listar todas las tareas")
    public void testListaTareas() {
        servicio.agregarTarea(4, "Tarea 4", "Descripción de la tarea 4", false);
        servicio.agregarTarea(5, "Tarea 5", "Descripción de la tarea 5", false);
        List<Tarea> tareas = servicio.listaTareas();
        assertEquals(2, tareas.size());
        assertEquals("Tarea 4", tareas.get(0).getTitulo());
        assertEquals("Tarea 5", tareas.get(1).getTitulo());
    }

    @Test
    @DisplayName("Test para agregar una tarea con ID duplicado")
    public void testAgregarTareaConIdDuplicado() {
        servicio.agregarTarea(6, "Tarea 6", "Descripción de la tarea 6", false);
        assertThrows(InvalidTareaException.class, () -> {
            servicio.agregarTarea(6, "Tarea 6 Duplicada", "Descripción de la tarea duplicada", false);
        });
        assertEquals(1, servicio.listaTareas().size());
    }

    @Test
    @DisplayName("Test para agregar una tarea con ID inválido")
    public void testAgregarTareaConIdInvalido() {
        assertThrows(InvalidTareaException.class, () -> {
            servicio.agregarTarea(0, "Tarea", "Descripción", false);
        });
        assertThrows(InvalidTareaException.class, () -> {
            servicio.agregarTarea(-1, "Tarea", "Descripción", false);
        });
    }

    @Test
    @DisplayName("Test para agregar una tarea con título vacío")
    public void testAgregarTareaConTituloVacio() {
        assertThrows(InvalidTareaException.class, () -> {
            servicio.agregarTarea(7, "", "Descripción", false);
        });
        assertThrows(InvalidTareaException.class, () -> {
            servicio.agregarTarea(8, null, "Descripción", false);
        });
    }


}
