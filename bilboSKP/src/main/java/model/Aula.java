package model;

public class Aula {

    private int id_aula, id_centro;
    private String nombre_aula;

    @Override
    public String toString() {
        return "Aula [id_aula=" + id_aula + ", nombre_aula=" + nombre_aula + ", id_centro=" + id_centro + "]";
    }

    public Aula(int id_aula, String nombre_aula, int id_centro) {
        this.id_aula = id_aula;
        this.nombre_aula = nombre_aula;
        this.id_centro = id_centro;
    }

    public Aula() {
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public String getNombre_aula() {
        return nombre_aula;
    }

    public void setNombre_aula(String nombre_aula) {
        this.nombre_aula = nombre_aula;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }
}