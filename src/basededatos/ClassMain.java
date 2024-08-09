/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;

/**
 *
 * @author casa
 */
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClassMain {

    public static void main(String[] args) throws SQLException {
        VehiculoDAO dao = new VehiculoDAO();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Agregar vehículo");
                System.out.println("2. Mostrar vehículos");
                System.out.println("3. Actualizar vehículo");
                System.out.println("4. Eliminar vehículo");
                System.out.println("5. Salir");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Salto de línea
                
                switch (opcion) {
                    case 1 -> { 
                        // Agregar vehículo
                        System.out.println("Ingrese el nombre del propietario/conductor:");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese la placa del vehículo:");
                        String placa = scanner.nextLine();
                        System.out.println("Ingrese el tipo de vehículo:");
                        String tipo = scanner.nextLine();
                        System.out.println("Ingrese el número de teléfono:");
                        String telefono = scanner.nextLine();
                        dao.agregarVehiculo(nombre, placa, tipo, telefono);
                        System.out.println("Vehículo agregado exitosamente.");
                    }
                    
                    case 2 -> {
                        // Mostrar vehículos
                        List<Vehiculo> vehiculos = dao.obtenerVehiculos();
                        for (Vehiculo v : vehiculos) {
                            System.out.println(v);
                        }
                    }
                    
                    case 3 -> {
                        // Actualizar vehículo
                        System.out.println("Ingrese el ID del vehículo a actualizar:");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // salto de linea
                        System.out.println("Ingrese el nuevo nombre del propietario/conductor:");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese la nueva placa del vehículo:");
                        String nuevaPlaca = scanner.nextLine();
                        System.out.println("Ingrese el nuevo tipo de vehículo:");
                        String nuevoTipo = scanner.nextLine();
                        System.out.println("Ingrese el nuevo número de teléfono:");
                        String nuevoTelefono = scanner.nextLine();
                        dao.actualizarVehiculo(idActualizar, nuevoNombre, nuevaPlaca, nuevoTipo, nuevoTelefono);
                        System.out.println("Vehículo actualizado exitosamente.");
                    }
                    
                    case 4 -> {
                        // Eliminar vehículo
                        System.out.println("Ingrese el ID del vehículo a eliminar:");
                        int idEliminar = scanner.nextInt();
                        dao.eliminarVehiculo(idEliminar);
                        System.out.println("Vehículo eliminado exitosamente.");
                    }
                    
                    case 5 -> {
                        // Salir
                        salir = true;
                        System.out.println("Saliendo...");
                    }
                    
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        }
    }
}
