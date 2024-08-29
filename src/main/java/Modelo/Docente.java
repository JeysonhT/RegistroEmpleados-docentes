/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jason
 */
public class Docente {
    private Long id;
    private Long id_depto;
    private String nombre;
    private String apellido;
    private String cedula;
    
    public Docente(){
        
    }

    public Docente(Long id, Long id_depto, String nombre, String apellido, String cedula) {
        this.id = id;
        this.id_depto = id_depto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Docente(Long id_depto, String nombre, String apellido, String cedula) {
        this.id_depto = id_depto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_depto() {
        return id_depto;
    }

    public void setId_depto(Long id_depto) {
        this.id_depto = id_depto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
