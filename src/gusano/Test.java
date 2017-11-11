package gusano;

import java.io.File;

public class Test {
    
    public static void main(String[] args) throws Exception {
	File dir = new File(".//IN//");

	for (File arch : dir.listFiles()) {
	    Grafo grafo = new Grafo(arch);
	    grafo.resolver();

	}

    }

}
