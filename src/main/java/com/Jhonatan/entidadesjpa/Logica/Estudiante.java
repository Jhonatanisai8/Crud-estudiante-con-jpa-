package com.Jhonatan.entidadesjpa.Logica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEstudiante;
    @Column(name = "nombre")
    private String nombre;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String nombre) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
