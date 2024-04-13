/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto2programacion3;

import java.util.*;

public class Proyecto2Programacion3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConstruirMatrizDinamica matriz = new ConstruirMatrizDinamica();
        int opcion;
        int salir = 0;
        while (salir != 1) {
            Menu();
            opcion = entrada.nextInt();
            switch (opcion) {
	            case 1://Ingresar vehiculo
	                entrada.nextLine();
	                System.out.println("Ingrese los datos del vehículo a ingresar:");
	                System.out.print("Placa: ");
	                String placa = entrada.next();
	                System.out.print("Color: ");
	                String color = entrada.next();
	                System.out.print("Línea: ");
	                String linea = entrada.next();
	                System.out.print("Modelo: ");
	                String modelo = entrada.next();
	                System.out.print("Propietario: ");
	                String propietario = entrada.next();
	                System.out.print("Ahora ingrese las coordenadas del nodo donde desea registrar el vehículo\n");
	                System.out.print("Fila: ");
	                int fila = entrada.nextInt();
	                System.out.print("Columna: ");
	                int columna = entrada.nextInt();
	                matriz.agregar(placa, color, linea, modelo, propietario, fila, columna);
	                break;
                case 2://buscar
                	System.out.print("Ingrese los datos del vehículo que desea buscar (placa, color, linea, modelo, propietario): ");
                    String datoBuscar = entrada.next();
                    List<Nodo> nodosEncontrados = matriz.buscar(datoBuscar);
                    if (!nodosEncontrados.isEmpty()) {
                        System.out.println("Vehículos encontrados:");
                        for (Nodo nodoEncontrado : nodosEncontrados) {
                            System.out.println(nodoEncontrado.getVehiculo());
                        }
                    } else {
                        System.out.println("¡¡Vehículo no encontrado!!");
                    }
                    break;
                case 3://eliminar
                	System.out.print("Ingrese la placa del vehículo que desea eliminar: ");
                    String placaEliminar = entrada.next();
                    List<Nodo> nodosAEliminar = matriz.buscar(placaEliminar);
                    if (!nodosAEliminar.isEmpty()) {
                        for (Nodo nodoAEliminar : nodosAEliminar) {
                            System.out.println("Vehículo encontrado:");
                            System.out.println(nodoAEliminar.getVehiculo());
                            System.out.print("¿Está seguro que desea eliminar permanentemente este vehículo? (si/no): ");
                            String confirmacion = entrada.next();
                            if (confirmacion.equalsIgnoreCase("si")) {
                                matriz.eliminar(placaEliminar);
                                System.out.println("¡¡Vehículo eliminado exitosamente!!");
                            } else {
                                System.out.println("¡¡Eliminación cancelada!!");
                            }
                        }
                    } else {
                        System.out.println("¡¡Vehículo no encontrado!!");
                    }
                    break;
                case 4:
                    salir = 1;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    public static void Menu() {//menu principal
        System.out.println("\n\t MENU PRINCIPAL ");
        System.out.println("1. Agregar Vehiculo");
        System.out.println("2. Buscar Vehiculo");
        System.out.println("3. Eliminar Vehiculo");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opción:");
    }
}

