/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto2programacion3;

import java.util.Scanner;

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
                case 1:
                    System.out.println("Ingrese los datos del vehículo:");
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

                    matriz.insertarVehiculo(placa, color, linea, modelo, propietario);
                    break;

                case 2:
                    System.out.print("Ingrese la placa del vehículo a buscar: ");
                    String placaBuscar = entrada.next();
                    Nodo nodoEncontrado = matriz.buscarVehiculo(placaBuscar);
                    if (nodoEncontrado != null) {
                        System.out.println("Vehículo encontrado:");
                        System.out.println(nodoEncontrado.getVehiculo());
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la placa del vehículo a eliminar: ");
                    String placaEliminar = entrada.next();
                    matriz.eliminarVehiculo(placaEliminar);
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

    public static void Menu() {
        System.out.println("\n\t MENU PRINCIPAL PARQUEO\n");
        System.out.println("1.\t Ingresar Vehiculo");
        System.out.println("2.\t Buscar Vehiculo");
        System.out.println("3.\t Eliminar Vehiculo");
        System.out.println("4.\t Salir");
        System.out.println("\nSeleccione una opción: ");
    }
}

