package model;

public class SalaEscape {

    private int id_sala;
    private String nombre_sala;
    private String descripcion;
    private boolean es_exclusiva_centro;

    @Override
    public String toString() {
        return "SalaEscape [id_sala=" + id_sala + ", nombre_sala=" + nombre_sala + ", descripcion=" + descripcion
                + ", es_exclusiva_centro=" + es_exclusiva_centro + "]";
    }

    public SalaEscape(int id_sala, String nombre_sala, String descripcion, boolean es_exclusiva_centro) {
        this.id_sala = id_sala;
        this.nombre_sala = nombre_sala;
        this.descripcion = descripcion;
        this.es_exclusiva_centro = es_exclusiva_centro;
    }

    public SalaEscape() {
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEs_exclusiva_centro() {
        return es_exclusiva_centro;
    }

    public void setEs_exclusiva_centro(boolean es_exclusiva_centro) {
        this.es_exclusiva_centro = es_exclusiva_centro;
    }
}