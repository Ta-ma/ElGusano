package gusano;

import java.util.LinkedList;
import java.util.List;

public class Nodo{

    private int nombre;
    List<Arista> aristas;

    public Nodo(int nombre) {
	this.nombre = nombre;
	aristas = new LinkedList<Arista>();
    }

    public void agregarArista(Arista arista) {
	aristas.add(arista);
    }

    public int getNombre() {
	return nombre;
    }

    public void setNombre(int nombre) {
	this.nombre = nombre;
    }

    public int getId() {
	return nombre - 1;
    }
    public List<Arista> getAristas() {
	return aristas;
    }

    public void setAristas(List<Arista> aristas) {
	this.aristas = aristas;
    }

    @Override
    public String toString() {
	return "Nodo [nombre=" + nombre + ", aristas=" + aristas + "]";
    }

}
