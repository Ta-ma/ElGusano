package gusano;

public class Arista {

    private int nodoD;
    private int costo;

    public Arista(int nodoD, int costo) {
	super();
	this.nodoD = nodoD;
	this.costo = costo;
    }

    public int getNodoD() {
	return nodoD;
    }

    public void setNodoD(int nodoD) {
	this.nodoD = nodoD;
    }

    public int getCosto() {
	return costo;
    }

    public void setCosto(int costo) {
	this.costo = costo;
    }

    @Override
    public String toString() {
	return "Arista [nodoD=" + nodoD + ", costo=" + costo + "]";
    }

}
