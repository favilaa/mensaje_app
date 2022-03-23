package com.company;

import java.util.Scanner;

public class mensajesService {
    public static void crearMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = scanner.nextLine();

        System.out.println("Tu nombre");
        String nombre = scanner.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        mensajesDAO.crearMensajeDB(registro);
    }

    public static void  listarMensajes(){
        mensajesDAO.leerMensajesDB();

    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje= sc.nextInt();
        mensajesDAO.borrarMensajeDB(id_mensaje);

    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("¿Cual es el ID a modificar?");
        int id_mensaje = sc.nextInt();

        Mensajes update = new Mensajes();
        update.setId_mensaje(id_mensaje);
        update.setMensaje(mensaje);
        mensajesDAO.actualizarMensajeDB(update);

    }
}
