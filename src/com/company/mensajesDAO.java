package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_conect = new Conexion();
        try (Connection conexion = db_conect.get_connection()){
            PreparedStatement ps=null;
            try{
               String query="INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
               ps=conexion.prepareStatement(query);
               ps.setString(1,mensaje.getMensaje());
               ps.setString(2,mensaje.getAutor_mensaje());
               ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            }catch (SQLException ex) {
                System.out.println("ex");
            }

        }catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void leerMensajesDB(){
        Conexion db_conect = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;

        try (Connection conexion = db_conect.get_connection()){
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje :" + rs.getString("mensaje"));
                System.out.println("Autor :" + rs.getString("autor_mensaje"));
                System.out.println("Fecha :" + rs.getString("Fecha"));
                System.out.println(" ");
            }
        }catch (SQLException ex) {
            System.out.println("No se pudieron recuperar los mensajes");
        System.out.println("ex");
    }

    }
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_conect = new Conexion();

        try (Connection conexion = db_conect.get_connection()){
            PreparedStatement ps=null;

            try{
                String query="DELETE FROM mensajes WHERE id_mensaje=?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ah sido borrado");
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo borrar mensaje");
            }

        }catch (SQLException e) {
        System.out.println(e);
    }

    }
    public static void actualizarMensajeDB (Mensajes mensajes){
        Conexion db_conect = new Conexion();
        try (Connection conexion = db_conect.get_connection()){
            PreparedStatement ps=null;

            try{
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setInt(2,mensajes.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo correctamente");
            }catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("No se pudo actualizar mensaje");
            }

        }catch (SQLException e) {
            System.out.println(e);
        }

    }
}
