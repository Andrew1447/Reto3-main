package model;

import java.sql.Timestamp;

public class CentroEducativo {

    private int id_centro, num_alumnos, id_ciudad, id_suscripcion, saldo_cupones;
    private String nombre_centro, correo, cod_acceso;
    private Timestamp fecha_registro;

    @Override
    public String toString() {
        return "CentroEducativo [id_centro=" + id_centro + ", num_alumnos=" + num_alumnos + ", id_ciudad=" + id_ciudad
                + ", id_suscripcion=" + id_suscripcion + ", saldo_cupones=" + saldo_cupones + ", nombre_centro="
                + nombre_centro + ", correo=" + correo + ", cod_acceso=" + cod_acceso + ", fecha_registro="
                + fecha_registro + "]";
    }

    public CentroEducativo(int id_centro, int num_alumnos, int id_ciudad, int id_suscripcion, int saldo_cupones,
                            String nombre_centro, String correo, String cod_acceso, Timestamp fecha_registro) {
        this.id_centro = id_centro;
        this.num_alumnos = num_alumnos;
        this.id_ciudad = id_ciudad;
        this.id_suscripcion = id_suscripcion;
        this.saldo_cupones = saldo_cupones;
        this.nombre_centro = nombre_centro;
        this.correo = correo;
        this.cod_acceso = cod_acceso;
        this.fecha_registro = fecha_registro;
    }

    public CentroEducativo() {
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(int id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public int getSaldo_cupones() {
        return saldo_cupones;
    }

    public void setSaldo_cupones(int saldo_cupones) {
        this.saldo_cupones = saldo_cupones;
    }

    public String getNombre_centro() {
        return nombre_centro;
    }

    public void setNombre_centro(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCod_acceso() {
        return cod_acceso;
    }

    public void setCod_acceso(String cod_acceso) {
        this.cod_acceso = cod_acceso;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}