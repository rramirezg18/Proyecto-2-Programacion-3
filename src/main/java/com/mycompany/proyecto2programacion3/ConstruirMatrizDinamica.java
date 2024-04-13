package com.mycompany.proyecto2programacion3;

import java.util.*;

public class ConstruirMatrizDinamica {
    private Nodo inicio;//Representa el inicio de la matriz
    private Nodo cabezaFila;//Nodo inicial en una fila
    private Nodo cabezaColumna;//Nodo inical en una columna

    public ConstruirMatrizDinamica() {
        this.inicio = null;
        this.cabezaFila = null;
        this.cabezaColumna = null;
    }

    public void agregar(String placa, String color, String linea, String modelo, String propietario, int fila, int columna) {
        // Verificar si el nodo en la posición ya está ocupado
        Nodo nodoExistente = buscarNodo(fila, columna);
        if (nodoExistente != null) {
            System.out.println("¡¡Error!! Ya existe un registro en el nodo (" + fila + "," + columna + ")");
            return;
        }else {
            System.out.print("Vehículo registrado correctamente en el nodo (" + fila + "," + columna + ")");
        }

        // Si no existe un vehículo en la posición, proceder a agregar el nuevo vehículo
        Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
        Nodo nuevoNodo = new Nodo(vehiculo, fila, columna);
        // Insertar cabeza de fila si no existe
        if (buscarFila(fila) == null) {
            insertarFila(fila);
        }
        // Insertar cabeza de columna si no existe
        if (buscarColumna(columna) == null) {
            insertarColumna(columna);
        }
        // Insertar nodo en la posición ingresada
        Nodo nodoFila = buscarFila(fila);
        Nodo nodoColumna = buscarColumna(columna);

        // Conectar nodos en fila
        Nodo temp = nodoFila.getApuntadorDerecho();
        while (temp != null && temp.getColumna() < columna) {
            nodoFila = temp;
            temp = temp.getApuntadorDerecho();
        }
        nuevoNodo.setApuntadorDerecho(temp);
        nodoFila.setApuntadorDerecho(nuevoNodo);

        // Conectar nodos en columna
        temp = nodoColumna.getApuntadorAbajo();
        while (temp != null && temp.getFila() < fila) {
            nodoColumna = temp;
            temp = temp.getApuntadorAbajo();
        }
        nuevoNodo.setApuntadorAbajo(temp);
        nodoColumna.setApuntadorAbajo(nuevoNodo);
    }

    // Método auxiliar para buscar un nodo en una posición específica
    private Nodo buscarNodo(int fila, int columna) {
        Nodo tempFila = cabezaFila;
        while (tempFila != null) {
            Nodo temp = tempFila.getApuntadorDerecho();
            while (temp != null) {
                if (temp.getFila() == fila && temp.getColumna() == columna) {
                    return temp;
                }
                temp = temp.getApuntadorDerecho();
            }
            tempFila = tempFila.getApuntadorAbajo();
        }
        return null;
    }

    private void insertarFila(int fila) {
    	Nodo nuevaFila = new Nodo(null, fila, -1); // -1 para identificar una cabeza de fila
        if (cabezaFila == null) {
            cabezaFila = nuevaFila;
        } else {
            Nodo temp = cabezaFila;
            while (temp.getApuntadorAbajo() != null) {
                temp = temp.getApuntadorAbajo();
            }
            temp.setApuntadorAbajo(nuevaFila);
        }
    }

    private void insertarColumna(int columna) {
    	Nodo nuevaColumna = new Nodo(null, -1, columna); // -1 para identificar una cabeza de columna
        if (cabezaColumna == null) {
            cabezaColumna = nuevaColumna;
        } else {
            Nodo temp = cabezaColumna;
            while (temp.getApuntadorDerecho() != null) {
                temp = temp.getApuntadorDerecho();
            }
            temp.setApuntadorDerecho(nuevaColumna);
        }
    }

    public List<Nodo> buscar(String dato) {
        List<Nodo> nodosEncontrados = new ArrayList<>();
        Nodo tempFila = cabezaFila;
        while (tempFila != null) {
            Nodo temp = tempFila.getApuntadorDerecho();
            while (temp != null) {
                Vehiculo vehiculo = temp.getVehiculo();
                if (vehiculo != null) {
                    if (vehiculo.getPlaca().equalsIgnoreCase(dato) ||
                        vehiculo.getColor().equalsIgnoreCase(dato) ||
                        vehiculo.getLinea().equalsIgnoreCase(dato) ||
                        vehiculo.getModelo().equalsIgnoreCase(dato) ||
                        vehiculo.getPropietario().equalsIgnoreCase(dato)) {
                        nodosEncontrados.add(temp);
                    }
                }
                temp = temp.getApuntadorDerecho();
            }
            tempFila = tempFila.getApuntadorAbajo();
        }
        return nodosEncontrados;
    }

    public void eliminar(String placa) {
        Nodo nodoAnterior = null;
        Nodo tempFila = cabezaFila;
        while (tempFila != null) {
            Nodo temp = tempFila.getApuntadorDerecho();
            while (temp != null) {
                Vehiculo vehiculo = temp.getVehiculo();
                if (vehiculo != null && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                    // Elimina el nodo asociado a la placa ingresada
                    if (nodoAnterior != null) {
                        nodoAnterior.setApuntadorDerecho(temp.getApuntadorDerecho());
                    } else {
                        tempFila.setApuntadorDerecho(temp.getApuntadorDerecho());
                    }
                    Nodo tempColumna = cabezaColumna;
                    while (tempColumna != null) {
                        if (tempColumna.getFila() == temp.getFila()) {
                            Nodo columnaAnterior = null;
                            Nodo tempC = tempColumna.getApuntadorAbajo();
                            while (tempC != null) {
                                if (tempC.getColumna() == temp.getColumna()) {
                                    if (columnaAnterior != null) {
                                        columnaAnterior.setApuntadorAbajo(tempC.getApuntadorAbajo());
                                    } else {
                                        tempColumna.setApuntadorAbajo(tempC.getApuntadorAbajo());
                                    }
                                    break;
                                }
                                columnaAnterior = tempC;
                                tempC = tempC.getApuntadorAbajo();
                            }
                            break;
                        }
                        tempColumna = tempColumna.getApuntadorAbajo();
                    }
                    return;
                }
                nodoAnterior = temp;
                temp = temp.getApuntadorDerecho();
            }
            tempFila = tempFila.getApuntadorAbajo();
        }
        // Después de eliminar actualiza las cabezas de fila y columna
        actualizarCabezas();
    }
    
    //Metodo para actualizar las cabezas de las columnas y las filas
    private void actualizarCabezas() {
        Nodo tempFila = cabezaFila;//Filas
        while (tempFila != null && tempFila.getApuntadorDerecho() != null) {
            tempFila = tempFila.getApuntadorDerecho();
        }
        cabezaFila = tempFila;
        Nodo tempColumna = cabezaColumna;//columnas
        while (tempColumna != null && tempColumna.getApuntadorAbajo() != null) {
            tempColumna = tempColumna.getApuntadorAbajo();
        }
        cabezaColumna = tempColumna;
    }
    
    private Nodo buscarFila(int fila) {
        Nodo temp = cabezaFila;
        while (temp != null) {
            if (temp.getFila() == fila) {
                return temp;
            }
            temp = temp.getApuntadorAbajo();
        }
        return null;
    }

    private Nodo buscarColumna(int columna) {
        Nodo temp = cabezaColumna;
        while (temp != null) {
            if (temp.getColumna() == columna) {
                return temp;
            }
            temp = temp.getApuntadorDerecho();
        }
        return null;
    }
}
