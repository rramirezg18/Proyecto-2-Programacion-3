package com.mycompany.proyecto2programacion3;

public class Nodo {
    private Vehiculo vehiculo;//Los atributos del vehiculo soon los datos que se ingresaran en cada nodo
    //Apuntadores
    private Nodo apuntadorArriba;
    private Nodo apuntadorAbajo;
    private Nodo apuntadorIzquierdo;
    private Nodo apuntadorDerecho;
    private int fila;
    private int columna;
    //constructor
    public Nodo(Vehiculo vehiculo, int fila, int columna) {
        this.vehiculo = vehiculo;
        this.apuntadorArriba = null;
        this.apuntadorAbajo = null;
        this.apuntadorIzquierdo = null;
        this.apuntadorDerecho = null;
        this.fila = fila;
        this.columna = columna;
    }
    //setters y getters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Nodo getApuntadorArriba() {
        return apuntadorArriba;
    }

    public void setApuntadorArriba(Nodo apuntadorArriba) {
        this.apuntadorArriba = apuntadorArriba;
    }

    public Nodo getApuntadorAbajo() {
        return apuntadorAbajo;
    }

    public void setApuntadorAbajo(Nodo apuntadorAbajo) {
        this.apuntadorAbajo = apuntadorAbajo;
    }

    public Nodo getApuntadorIzquierdo() {
        return apuntadorIzquierdo;
    }

    public void setApuntadorIzquierdo(Nodo apuntadorIzquierdo) {
        this.apuntadorIzquierdo = apuntadorIzquierdo;
    }

    public Nodo getApuntadorDerecho() {
        return apuntadorDerecho;
    }

    public void setApuntadorDerecho(Nodo apuntadorDerecho) {
        this.apuntadorDerecho = apuntadorDerecho;
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}