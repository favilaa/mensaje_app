package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion=0;

        do{
            System.out.println("-----------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1: Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            //Leer la opcion del usuario
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    mensajesService.crearMensaje();
                    break;
                case 2:
                    mensajesService.listarMensajes();
                    break;
                case 3:
                    mensajesService.borrarMensaje();
                    break;
                case 4:
                    mensajesService.editarMensaje();
                    break;
                case 5:
                    break;
            }

        }while(opcion != 5);


    }
}
