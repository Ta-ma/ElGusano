package gusano;

public class PcInfectada {
    private int num;
    private int tiempo;
    
    public PcInfectada(int num, int tiempo) {
	super();
	this.num = num;
	this.tiempo = tiempo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
