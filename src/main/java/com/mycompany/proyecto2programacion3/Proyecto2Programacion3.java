/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto2programacion3;

/**PROYECTO NO. 2
 * El proyecto consiste en crear una matriz ortogonal o dinamica para la administracion eficiente de memoria
 * La matriz almacera datos de vehiculos y permitira ingresar, buscar y eliminar
 * Jean Klaus Castañeda Santos		7690-22-892
 * Roberto Antonio Ramírez Gómez	7690-22-12700		
 * Jonathan Joel Chan Cuellar		7690-22-1805
 */
import java.util.*;
public class Proyecto2Programacion3 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int salir = 0;
        while(salir !=1) {
            Menu();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1://insertar

                    break;
                case 2://buscar
                    
                    break;
                case 3://eliminar
                    
                    break;
                case 4:
                    salir = 1;
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
