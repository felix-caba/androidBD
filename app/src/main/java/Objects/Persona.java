package Objects;

import etc.Genero;

public class Persona{

    private int idPersona;
    private String nombre;
    private String domicilio;
    private String movil;
    private String email;
    private String fechaNacimiento;
    private Genero genero;

    public Persona(String nombreStr, String fechaNacimientoStr, String domicilioStr, String movilStr, String emailStr) {

        this.nombre = nombreStr;
        this.fechaNacimiento = fechaNacimientoStr;
        this.domicilio = domicilioStr;
        this.movil = movilStr;
        this.email = emailStr;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
