package com.mycompany.proyecto2programacion3;

import java.util.*;

public class ConstruirMatrizDinamica {

    private Nodo inicio;

    public ConstruirMatrizDinamica() {
        this.inicio = null;
    }

    public void insertarVehiculo(String placa, String color, String linea, String modelo, String propietario) {
        Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
        Nodo nuevoNodo = new Nodo(vehiculo);

        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            // Insertar el nuevo nodo al final de la matriz
            Nodo ultimo = encontrarUltimoNodo();
            ultimo.setDerecha(nuevoNodo);
            nuevoNodo.setIzquierda(ultimo);
        }
    }

    private Nodo encontrarUltimoNodo() {
        Nodo current = inicio;
        while (current.getDerecha() != null) {
            current = current.getDerecha();
        }
        return current;
    }

    public void mostrarMatriz() {
        Nodo currentRow = inicio;
        while (currentRow != null) {
            Nodo currentCol = currentRow;
            while (currentCol != null) {
                System.out.print(currentCol.getVehiculo() + " -> ");
                currentCol = currentCol.getDerecha();
            }
            System.out.println("null");
            currentRow = currentRow.getAbajo();
        }
    }

    public Nodo buscarVehiculo(String placa) {
        Nodo current = inicio;
        while (current != null) {
            if (current.getVehiculo().getPlaca().equals(placa)) {
                return current;
            }
            current = current.getDerecha();
        }
        return null; // Vehículo no encontrado
    }

    public void eliminarVehiculo(String placa) {
        Nodo nodoAEliminar = buscarVehiculo(placa);
        if (nodoAEliminar != null) {
            if (nodoAEliminar.getIzquierda() != null) {
                nodoAEliminar.getIzquierda().setDerecha(nodoAEliminar.getDerecha());
            }
            if (nodoAEliminar.getDerecha() != null) {
                nodoAEliminar.getDerecha().setIzquierda(nodoAEliminar.getIzquierda());
            }
        }
    }
}
