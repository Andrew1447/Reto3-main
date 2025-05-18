package model;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class Partida {

    private int cod_partida, id_centro, id_sala, id_aula, num_jugadores;
    private String nombre_aula_partida, dificultad, codigo_acceso;
    private Timestamp fecha_inicio, fecha_fin;
    private BigDecimal puntuacion_total;

    @Override
    public String toString() {
        return "Partida [cod_partida=" + cod_partida + ", id_centro=" + id_centro + ", id_sala=" + id_sala
                + ", id_aula=" + id_aula + ", num_jugadores=" + num_jugadores + ", nombre_aula_partida="
                + nombre_aula_partida + ", dificultad=" + dificultad + ", codigo_acceso=" + codigo_acceso
                + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", puntuacion_total="
                + puntuacion_total + "]";
    }

    public Partida(int cod_partida, int id_centro, int id_sala, int id_aula, int num_jugadores,
                   String nombre_aula_partida, String dificultad, String codigo_acceso, Timestamp fecha_inicio,
                   Timestamp fecha_fin, BigDecimal puntuacion_total) {
        this.cod_partida = cod_partida;
        this.id_centro = id_centro;
        this.id_sala = id_sala;
        this.id_aula = id_aula;
        this.num_jugadores = num_jugadores;
        this.nombre_aula_partida = nombre_aula_partida;
        this.dificultad = dificultad;
        this.codigo_acceso = codigo_acceso;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.puntuacion_total = puntuacion_total;
    }

    public Partida() {
    }

    public int getCod_partida() {
        return cod_partida;
    }

    public void setCod_partida(int cod_partida) {
        this.cod_partida = cod_partida;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public int getNum_jugadores() {
        return num_jugadores;
    }

    public void setNum_jugadores(int num_jugadores) {
        this.num_jugadores = num_jugadores;
    }

    public String getNombre_aula_partida() {
        return nombre_aula_partida;
    }

    public void setNombre_aula_partida(String nombre_aula_partida) {
        this.nombre_aula_partida = nombre_aula_partida;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getCodigo_acceso() {
        return codigo_acceso;
    }

    public void setCodigo_acceso(String codigo_acceso) {
        this.codigo_acceso = codigo_acceso;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BigDecimal getPuntuacion_total() {
        return puntuacion_total;
    }

    public void setPuntuacion_total(BigDecimal puntuacion_total) {
        this.puntuacion_total = puntuacion_total;
    }
}