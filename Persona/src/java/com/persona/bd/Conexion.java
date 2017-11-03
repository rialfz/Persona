/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RicardoZ
 */
public class Conexion {
    
    Connection conector;

    public Conexion() {
    }

    public Conexion(Connection conector) {
        this.conector = conector;
    }
    
    public void conectar()
    {
        //java se conecta con postgres necesito el servidor , puerto , nombre de la base de datos ,usuario,contraseña
      
        
        String cadenaConexion = "jdbc:postgresql://localhost:5432/personaDB";
        String usuario = "postgres";
        String pass = "kotegaeshi";
        
        try {
            Class.forName("org.postgresql.Driver");                              //que driver ocupo para postgres
            this.conector = DriverManager.getConnection(cadenaConexion,usuario,pass);     //abro  la conexion
            System.out.println("conecto satisfactoriamente");
             
            
            } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
           
        }  
    }
    
    public Connection getConexion()
    {
        return this.conector;
    }
    
}
