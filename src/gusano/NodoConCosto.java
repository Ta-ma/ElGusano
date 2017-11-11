package gusano;

public class NodoConCosto implements Comparable<NodoConCosto> {
    private int nombre;
    private int costo;
    
    public NodoConCosto(int nombre, int costo) {
	super();
	this.nombre = nombre;
	this.costo = costo;
    }
    
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    public int getId() {
	return this.nombre - 1;
    }

    @Override
    public String toString() {
	return "NodoConCosto [nombre=" + nombre + ", costo=" + costo + "]";
    }

    @Override
    public int compareTo(NodoConCosto o) {
	return ((Integer) this.costo).compareTo(o.costo);
    }

}
