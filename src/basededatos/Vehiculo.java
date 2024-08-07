/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;

/**
 *
 * @author casa
 */
public class Vehiculo {
    private int id;
    private String nombre;
    private String placa;
    private String tipo;
    private String telefono;

    public Vehiculo(int id, String nombre, String placa, String tipo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.placa = placa;
        this.tipo = tipo;
        this.telefono = telefono;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
/*
    
    /*
    "toString" en Java es un método heredado de la clase "Object" que se usa para devolver una 
    representación en forma de cadena de un objeto. Sobrescribir este método permite que las 
    instancias de una clase tengan una representación legible y significativa cuando se convierten en cadenas, 
    lo que puede ser útil para la depuración y el registro (logging).
    */
    @Override
    public String toString() {
        return "Vehiculo{id=" + id + ", nombre='" + nombre + "', placa='" + placa + "', tipo='" + tipo + "', telefono='" + telefono + "'}";
    }
}

