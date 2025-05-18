package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Cupon {

    private String id_cupon;
    private int id_suscripcion;
    private Timestamp fecha_compra;
    private Date fecha_uso;
    private boolean usado;
    private boolean reembolsado;
    private Date fecha_reembolso;

    @Override
    public String toString() {
        return "Cupon [id_cupon=" + id_cupon + ", id_suscripcion=" + id_suscripcion + ", fecha_compra=" + fecha_compra
                + ", fecha_uso=" + fecha_uso + ", usado=" + usado + ", reembolsado=" + reembolsado
                + ", fecha_reembolso=" + fecha_reembolso + "]";
    }

    public Cupon(String id_cupon, int id_suscripcion, Timestamp fecha_compra, Date fecha_uso, boolean usado,
                 boolean reembolsado, Date fecha_reembolso) {
        this.id_cupon = id_cupon;
        this.id_suscripcion = id_suscripcion;
        this.fecha_compra = fecha_compra;
        this.fecha_uso = fecha_uso;
        this.usado = usado;
        this.reembolsado = reembolsado;
        this.fecha_reembolso = fecha_reembolso;
    }

    public Cupon() {
    }

    public String getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(String id_cupon) {
        this.id_cupon = id_cupon;
    }

    public int getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(int id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public Timestamp getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Timestamp fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getFecha_uso() {
        return fecha_uso;
    }

    public void setFecha_uso(Date fecha_uso) {
        this.fecha_uso = fecha_uso;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public boolean isReembolsado() {
        return reembolsado;
    }

    public void setReembolsado(boolean reembolsado) {
        this.reembolsado = reembolsado;
    }

    public Date getFecha_reembolso() {
        return fecha_reembolso;
    }

    public void setFecha_reembolso(Date fecha_reembolso) {
        this.fecha_reembolso = fecha_reembolso;
    }
}