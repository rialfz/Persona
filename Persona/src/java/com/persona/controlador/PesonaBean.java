/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.controlador;

import com.persona.bd.PersonaDao;
import com.persona.modelo.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static sun.management.Agent.error;

/**
 *
 * @author RicardoZ
 */
@ManagedBean(name="personaBean")
@ViewScoped
public class PesonaBean {
    
    private Persona pers;
    private Persona personaSelect;
    private Persona actualizado;
    private ArrayList<Persona> personas;
    private PersonaDao conector;

    public PesonaBean() {
        pers = new Persona();
        actualizado = new Persona();
        personas = new ArrayList<Persona>();
        conector = new PersonaDao();
        personaSelect = new Persona();
    }
    
    
    public void crear() throws SQLException{
        conector.crear(pers);
      
    }
    
    public void ver(Persona p){
        //System.out.println("-******Actualizndo*************");
        actualizado=p;
        //conector.actualizar(p);
    }
    
    public void actualiza(Persona p){
        //System.out.println("-******Actualizndo*************");
        actualizado=p;
        
        //conector.actualizar(p);
    }
    
    public void actualizar() throws SQLException{
        System.out.println("Actualizando*****************************");
        System.out.println("Nombre********"+personaSelect.getNombre());
        conector.actualizar(personaSelect);
       // return "actualizar.xhtml";
    }
    
    
    public void eliminar(Persona p) throws SQLException{
        conector.eliminar(p.getIdentificacion());
    }
    
    public ArrayList<Persona> listar() throws SQLException{
        //System.out.println("********************************************");
        personas = conector.listar();
        return personas;
    }

    public Persona getPers() {
        return pers;
    }

    public void setPers(Persona pers) {
        this.pers = pers;
    }

    public Persona getActualizado() {
        return actualizado;
    }

    public void setActualizado(Persona actualizado) {
        this.actualizado = actualizado;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public PersonaDao getConector() {
        return conector;
    }

    public void setConector(PersonaDao conector) {
        this.conector = conector;
    }

    public Persona getPersonaSelect() {
        return personaSelect;
    }

    public void setPersonaSelect(Persona personaSelect) {
        this.personaSelect = personaSelect;
    }
    
    
    
}
