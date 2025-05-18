package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Suscripcion {

    private int id_suscripcion, id_tipo_suscripcion, entidad_id;
    private Date fecha_inicio, fecha_fin;
    private Timestamp fecha_solicitud, fecha_pago;
    private String estado_pago, tipo_entidad; // ENUM('centro', 'usuario')
    private boolean confirmada;

    @Override
    public String toString() {
        return "Suscripcion [id_suscripcion=" + id_suscripcion + ", id_tipo_suscripcion=" + id_tipo_suscripcion
                + ", entidad_id=" + entidad_id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
                + ", fecha_solicitud=" + fecha_solicitud + ", fecha_pago=" + fecha_pago + ", estado_pago="
                + estado_pago + ", tipo_entidad=" + tipo_entidad + ", confirmada=" + confirmada + "]";
    }

    public Suscripcion(int id_suscripcion, int id_tipo_suscripcion, int entidad_id, Date fecha_inicio, Date fecha_fin,
                       Timestamp fecha_solicitud, Timestamp fecha_pago, String estado_pago, String tipo_entidad,
                       boolean confirmada) {
        this.id_suscripcion = id_suscripcion;
        this.id_tipo_suscripcion = id_tipo_suscripcion;
        this.entidad_id = entidad_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_pago = fecha_pago;
        this.estado_pago = estado_pago;
        this.tipo_entidad = tipo_entidad;
        this.confirmada = confirmada;
    }

    public Suscripcion() {
    }

    public int getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(int id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public int getId_tipo_suscripcion() {
        return id_tipo_suscripcion;
    }

    public void setId_tipo_suscripcion(int id_tipo_suscripcion) {
        this.id_tipo_suscripcion = id_tipo_suscripcion;
    }

    public int getEntidad_id() {
        return entidad_id;
    }

    public void setEntidad_id(int entidad_id) {
        this.entidad_id = entidad_id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Timestamp getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Timestamp fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Timestamp getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Timestamp fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public String getTipo_entidad() {
        return tipo_entidad;
    }

    public void setTipo_entidad(String tipo_entidad) {
        this.tipo_entidad = tipo_entidad;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
}