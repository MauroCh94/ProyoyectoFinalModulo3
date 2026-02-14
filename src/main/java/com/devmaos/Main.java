package com.devmaos;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devmaos.service.tareaservice;

public class Main {
    public static Logger LOG = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        tareaservice servicio = new tareaservice();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            try {
                LOG.info("1. Agregar tarea");
                LOG.info("2. Listar tareas");
                LOG.info("3. Marcar tarea como completada");
                LOG.info("4. Eliminar tarea");
                LOG.info("5. Salir");
                LOG.info("Seleccione una opcion: ");
                opcion = scanner.nextInt();
            } catch (Exception e) {
                
                if (opcion>5) {
                    LOG.warn("Opcion no valida, Por favor, seleccione una opcion entre 1 y 5.");
                    opcion = 0; // Reiniciar la opción para que el bucle continúe

                }
                e.printStackTrace();
            }    
            

            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    //System.out.print("ID: ");
                    LOG.info("introduce el ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    LOG.info("escribe el Título: ");
                    String titulo = scanner.nextLine();
                    LOG.info("Descripción tarea : ");
                    String descripcion = scanner.nextLine();
                    servicio.agregarTarea(id, titulo, descripcion,false);
                    break;
                case 2:
                    LOG.info("Lista de tareas:");
                    servicio.listaTareas().forEach(tarea -> LOG.info(tarea.toString()));
                    break;
                case 3:
                    LOG.info("ID de la tarea a marcar como completada: ");
                    servicio.marcarCompletada(scanner.nextInt());
                    break;
                case 4:
                    LOG.info("ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    servicio.eliminarTarea(idEliminar);
                    break;
                case 5:
                    LOG.info("Saliendo...");
                    break;
                default:
                    LOG.warn("Opción no válida.");
            }
        } while (opcion != 5);
        LOG.info("Gracias por usar el gestor de tareas.");
        scanner.close();
         
    }
}