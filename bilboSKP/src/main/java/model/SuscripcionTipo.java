package model;

public class SuscripcionTipo {

    private int id_tipo_suscripcion;
    private String nombre_tipo, descripcion;
    private double precio;
    private int duracion_dias, num_cupones;
    private String tipo_entidad; // ENUM('centro', 'usuario')

    @Override
    public String toString() {
        return "SuscripcionTipo [id_tipo_suscripcion=" + id_tipo_suscripcion + ", nombre_tipo=" + nombre_tipo
                + ", descripcion=" + descripcion + ", precio=" + precio + ", duracion_dias=" + duracion_dias
                + ", num_cupones=" + num_cupones + ", tipo_entidad=" + tipo_entidad + "]";
    }

    public SuscripcionTipo(int id_tipo_suscripcion, String nombre_tipo, String descripcion, double precio,
                            int duracion_dias, int num_cupones, String tipo_entidad) {
        this.id_tipo_suscripcion = id_tipo_suscripcion;
        this.nombre_tipo = nombre_tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion_dias = duracion_dias;
        this.num_cupones = num_cupones;
        this.tipo_entidad = tipo_entidad;
    }

    public SuscripcionTipo() {
    }

    public int getId_tipo_suscripcion() {
        return id_tipo_suscripcion;
    }

    public void setId_tipo_suscripcion(int id_tipo_suscripcion) {
        this.id_tipo_suscripcion = id_tipo_suscripcion;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion_dias() {
        return duracion_dias;
    }

    public void setDuracion_dias(int duracion_dias) {
        this.duracion_dias = duracion_dias;
    }

    public int getNum_cupones() {
        return num_cupones;
    }

    public void setNum_cupones(int num_cupones) {
        this.num_cupones = num_cupones;
    }

    public String getTipo_entidad() {
        return tipo_entidad;
    }

    public void setTipo_entidad(String tipo_entidad) {
        this.tipo_entidad = tipo_entidad;
    }
}