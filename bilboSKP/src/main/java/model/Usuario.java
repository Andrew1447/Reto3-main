package model;

public class Usuario {

    private String usuario, correo, contrasena;
    private int id_rol, id_suscripcion, saldo_cupon;

    @Override
    public String toString() {
        return "Usuario [usuario=" + usuario + ", correo=" + correo + ", contrasena=" + contrasena + ", id_rol="
               + id_rol + ", id_suscripcion=" + id_suscripcion + ", saldo_cupon=" + saldo_cupon + "]";
    }

    public Usuario(String usuario, String correo, String contrasena, int id_rol, int id_suscripcion, int saldo_cupon) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.id_rol = id_rol;
        this.id_suscripcion = id_suscripcion;
        this.saldo_cupon = saldo_cupon;
    }

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_suscripcion() {
        return id_suscripcion;
    }

    public void setId_suscripcion(int id_suscripcion) {
        this.id_suscripcion = id_suscripcion;
    }

    public int getSaldo_cupon() {
        return saldo_cupon;
    }

    public void setSaldo_cupon(int saldo_cupon) {
        this.saldo_cupon = saldo_cupon;
    }
}