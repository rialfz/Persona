/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.bd;

import com.persona.modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RicardoZ
 */
public class PersonaDao {
    
    Connection conexcion;
    
    
    
    public void crear(Persona p) throws SQLException
    {
        PreparedStatement prepararSentencia =null;
        Conexion conectar = new Conexion();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
       try {
        String sql = "insert into \"PERSONA\" (\"NOMBRE\",\"IDENTIFICACION\",\"APELLIDO\",\"TELEFONO\",\"DIRECCION\") values ('"+p.getNombre()+"','"+p.getIdentificacion()+
                "','"+p.getApellido()+"','"+p.getTelefono()+"','"+p.getDireccion()+"');";
        
       
            prepararSentencia = this.conexcion.prepareStatement(sql);
            prepararSentencia.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       conexcion.close();
     }
    
    public void actualizar(Persona p) throws SQLException
    {
        
        PreparedStatement prepararSentencia =null;
        Conexion conectar = new Conexion();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
       try {
       String sql = "update \"PERSONA\" set \"NOMBRE\"='"+p.getNombre()+"',";
                    sql+="\"APELLIDO\"='"+p.getApellido()+"',";
                    sql+="\"TELEFONO\"='"+p.getTelefono()+"',";
                    sql+="\"DIRECCION\"='"+p.getDireccion()+"',";
                     sql+="\"IDENTIFICACION\"='"+Integer.parseInt(p.getIdentificacion())+"' where \"IDENTIFICACION\"='"+Integer.parseInt(p.getIdentificacion())+"'";
                    
        
       
            prepararSentencia = this.conexcion.prepareStatement(sql);
            prepararSentencia.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexcion.close();
        
    }
    
    
    public void eliminar(String id) throws SQLException
    {
        PreparedStatement prepararSentencia =null;
        Conexion conectar = new Conexion();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
       try {
       
           String borrar = "delete from \"PERSONA\" where \"IDENTIFICACION\"='"+Integer.parseInt(id)+"'";
           
                    
        
       
            prepararSentencia = this.conexcion.prepareStatement(borrar);
            prepararSentencia.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       conexcion.close();
        
    }
    
    
     public ArrayList<Persona> listar() throws SQLException
    {
        
        
        
        Conexion conectar = new Conexion();
        conectar.conectar();
       
        this.conexcion = conectar.getConexion();        
          java.sql.Statement st = conexcion.createStatement();  
          
        
            String sql ="SELECT * FROM \"PERSONA\"";
            ArrayList<Persona> personas = new ArrayList<>();
            ResultSet result =st.executeQuery(sql);  
               while(result.next())
            {
                
                Persona p = new Persona();
                String nombre = result.getString("NOMBRE");
                String apellido = result.getString("APELLIDO");
                String id = result.getString("IDENTIFICACION");
                String telefon = result.getString("TELEFONO");
                String direccion = result.getString("DIRECCION");
                
                p.setApellido(apellido);
                p.setIdentificacion(id);
                p.setNombre(nombre);
                p.setTelefono(telefon);
                p.setDireccion(direccion);
                
                personas.add(p);
            }
           
           conexcion.close();
           return personas;
           
        
    }
    
}
