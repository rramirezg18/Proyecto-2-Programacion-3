/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2programacion3;

/**
 *
 * @author ianto
 */
public class Nodo {
    private Nodo apuntadorArriba;
    private Nodo apuntadorAbajo;
    private Nodo apuntadorDerecho;
    private Nodo apuntadorIzquierdo;
    
    public Nodo (){
        this.apuntadorArriba = null;
        this.apuntadorAbajo = null;
        this.apuntadorDerecho = null;
        this.apuntadorIzquierdo = null;
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

    public Nodo getApuntadorDerecho() {
        return apuntadorDerecho;
    }

    public void setApuntadorDerecho(Nodo apuntadorDerecho) {
        this.apuntadorDerecho = apuntadorDerecho;
    }

    public Nodo getApuntadorIzquierdo() {
        return apuntadorIzquierdo;
    }

    public void setApuntadorIzquierdo(Nodo apuntadorIzquierdo) {
        this.apuntadorIzquierdo = apuntadorIzquierdo;
    }
}
