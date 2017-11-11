package gusano;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Grafo {

    List<PcInfectada> pcsInfectadas;
    Map<Integer, Nodo> nodos;

    public Grafo(File arch) throws IOException {
	Scanner sc = new Scanner(arch);
	int cantAristas = sc.nextInt();
	nodos = new HashMap<Integer, Nodo>();
	pcsInfectadas = new ArrayList<PcInfectada>();

	for (int i = 0; i < cantAristas; i++) {
	    int nodoO = sc.nextInt();

	    if (!nodos.containsKey(nodoO)) {
		nodos.put(nodoO, new Nodo(nodoO));
	    }

	    int costo = sc.nextInt();
	    int nodoD = sc.nextInt();

	    if (!nodos.containsKey(nodoD)) {
		nodos.put(nodoD, new Nodo(nodoD));
	    }

	    nodos.get(nodoO).agregarArista(new Arista(nodoD, costo));
	    nodos.get(nodoD).agregarArista(new Arista(nodoO, costo));
	}

	/*
	 * for (Map.Entry<Integer, Nodo> entry : nodos.entrySet()) {
	 * System.out.println(entry.getValue()); }
	 */

	int cantPcs = sc.nextInt();

	for (int i = 0; i < cantPcs; i++) {
	    int nodo = sc.nextInt();
	    int tiempo = sc.nextInt();
	    pcsInfectadas.add(new PcInfectada(nodo, tiempo));
	}

	/*
	 * for (Map.Entry<Integer, Integer> entry : pcsInfectadas.entrySet()) {
	 * System.out.println(entry.getKey() + " " + entry.getValue()); }
	 */

	sc.close();
    }

    public int[] dijkstra(int nodoPartida) {
	nodoPartida--;
	Set<Integer> v = new HashSet<Integer>();
	Queue<NodoConCosto> cola = new PriorityQueue<NodoConCosto>();
	int[] costos = new int[nodos.size()];

	for (int i = 0; i < nodos.size(); i++)
	    costos[i] = 9999;

	// costo al nodo origen = 0
	costos[nodoPartida] = 0;
	cola.add(new NodoConCosto(nodoPartida + 1, 0));

	while (!cola.isEmpty()) {
	    NodoConCosto nodoC = cola.poll();
	    int nodoCid = nodoC.getId();

	    v.add(nodoCid);
	    List<Arista> aristas = nodos.get(nodoCid + 1).aristas;

	    for (Arista a : aristas) {
		int nodoD = a.getNodoD() - 1;

		if (!v.contains(nodoD) && costos[nodoD] > nodoC.getCosto() + a.getCosto()) {
		    costos[nodoD] = nodoC.getCosto() + a.getCosto();
		    cola.add(new NodoConCosto(nodoD + 1, costos[nodoD]));
		}
	    }
	}

	return costos;
    }

    public void resolver() {

	// pude haber usado cola o lista
	Stack<Integer> pila = new Stack<Integer>();

	// agarro la primera pc y hago dijkstra de esa
	PcInfectada pc = pcsInfectadas.get(0);
	int costos[] = dijkstra(pc.getNum());

	// me fijo cuantos nodos hay que coincidan el costo con el tiempo de
	// infección
	for (int i = 0; i < costos.length; i++) {
	    if (costos[i] == pc.getTiempo())
		pila.push(i + 1);
	}

	// hago dijkstra de los nodos que quedaron en la pila, si todas los
	// tiempos de infección de todas las pcs coinciden con los respectivos
	// nodos, entonces el virus se originó alli.
	while(!pila.isEmpty()) {
	    boolean encontreOrigen = true;
	    int nodo = pila.pop();
	    costos = dijkstra(nodo);
	    
	    for(PcInfectada p : pcsInfectadas) {
		if (p.getTiempo() != costos[p.getNum() - 1])
		    encontreOrigen = false;
	    }
	    
	    if(encontreOrigen) {
		System.out.println("el virus se originó en la pc: " + nodo);
		return;
	    }
		
	}
	
	System.out.println("no se puede determinar el origen.");
    }
}
