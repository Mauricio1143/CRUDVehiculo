/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;

/**
 *
 * @author casa
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * VehiculoDAO es una clase que actúa como un Data Access Object (DAO) para la entidad Vehiculo. Un DAO es un patrón de diseño
 * que proporciona una abstracción para alguna operación de datos, usualmente con una base de datos. Este patrón permite separar la lógica de negocio de la
 * lógica de acceso a datos, facilitando el mantenimiento y la escalabilidad del código.
 */
public class VehiculoDAO {

    // Crear un nuevo vehículo
    public void agregarVehiculo(String nombre, String placa, String tipo, String telefono) throws SQLException {
        String sql = "INSERT INTO vehiculos (nombre, placa, tipo, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, placa);
            pstmt.setString(3, tipo);
            pstmt.setString(4, telefono);
            pstmt.executeUpdate();
        }
    }

    // Leer todos los vehículos
    public List<Vehiculo> obtenerVehiculos() throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("placa"),
                        rs.getString("tipo"),
                        rs.getString("telefono")
                );
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }

    // Actualizar un vehículo
    public void actualizarVehiculo(int id, String nombre, String placa, String tipo, String telefono) throws SQLException {
        String sql = "UPDATE vehiculos SET nombre = ?, placa = ?, tipo = ?, telefono = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, placa);
            pstmt.setString(3, tipo);
            pstmt.setString(4, telefono);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        }
    }

    // Eliminar un vehículo
    public void eliminarVehiculo(int id) throws SQLException {
        String sql = "DELETE FROM vehiculos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
