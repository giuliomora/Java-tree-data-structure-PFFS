// Giulio Morandini matricola 7030209

package AlberoPFFS;

import java.util.LinkedList;
import java.util.Stack;

public class AlberoPFFS<T> {
	private NodoPFFS<T> radice;
	private int numNodi;
	private int altezza;

	// costruttore
	public AlberoPFFS() {
		radice = null;
		numNodi = 0;
	}

	// imposto la radice
	public NodoPFFS<T> aggiungiRadice(T info) {
		if (radice != null)
			return null;
		numNodi++;
		NodoPFFS<T> x = new NodoPFFS<T>(info);
		x.setInfo(info);
		radice = x;
		return radice;
	}

	// inserisce una nuova radice
	public NodoPFFS<T> nuovaRadice(T info) {
		if (radice == null)
			return null;
		numNodi++;
		altezza++;
		NodoPFFS<T> x = new NodoPFFS<T>(info);
		x.setInfo(info);
		x.setPadre(null);
		x.setprimoF(radice);
		radice.setPadre(x);
		radice = x;
		return radice;
	}

	// restituire la radice
	public NodoPFFS<T> getRadice() {
		return radice;
	}

	// aggiungo un nuovo nodo v come figlio di u e conoscendo info
	public NodoPFFS<T> aggiungiNodo(NodoPFFS<T> u, T info) {
		NodoPFFS<T> v = new NodoPFFS<T>(info);
		if (u.getPrimoF() == null) {
			u.setprimoF(v);
			v.setPadre(u);
			v.setInfo(info);
			numNodi++;
		} else {
			NodoPFFS<T> x = new NodoPFFS<T>(null);
			x = u.getPrimoF();
			while (x.getFratello() != null) {
				x = x.getFratello();
			}
			x.setFratello(v);
			v.setPadre(u);
			v.setInfo(info);
			numNodi++;
		}
		if (v.Livello() > altezza)
			altezza = v.Livello();
		return v;
	}

	// restituire il numero dei nodi
	public int Nodi() {
		return numNodi;
	}

	// visita in profondità
	public LinkedList<T> VisitaProf() {
		LinkedList<T> nodiAlbero_prof = new LinkedList<>();
		Stack<NodoPFFS<T>> pila = new Stack<NodoPFFS<T>>();
		pila.push(radice);
		while (!pila.isEmpty()) {
			NodoPFFS<T> u = pila.pop();
			if (u != null) {
				nodiAlbero_prof.addLast(u.getInfo());
				pila.push(u.getFratello());
				pila.push(u.getPrimoF());
			}
		}
		return nodiAlbero_prof;
	}

	// visita in ampiezza
	public LinkedList<T> VisitaAmp() {
		LinkedList<T> nodiAlbero_amp = new LinkedList<>();
		LinkedList<NodoPFFS<T>> coda = new LinkedList<>();
		coda.addFirst(radice);
		while (!coda.isEmpty()) {
			NodoPFFS<T> u = coda.remove();
			if (u != null) {
				nodiAlbero_amp.add(u.getInfo());
				coda.addFirst(u.getFratello());
				coda.add(u.getPrimoF());
			}
		}
		return nodiAlbero_amp;
	}

	// lista dei figli di un nodo
	public LinkedList<T> ListaFigli(NodoPFFS<T> u) {
		LinkedList<T> ListaFigli = new LinkedList<>();
		if (u.getPrimoF() == null)
			return null;
		else {
			NodoPFFS<T> t = u.getPrimoF();
			ListaFigli.add(t.getInfo());
			while (t.getFratello() != null) {
				ListaFigli.add(t.getFratello().getInfo());
				t = t.getFratello();
			}
		}
		return ListaFigli;
	}

	// numero figli di un nodo
	public int NumFigli(NodoPFFS<T> u) {
		if (u.getPrimoF() == null)
			return 0;
		int counter = ListaFigli(u).size();
		return counter;
	}

	// numero delle foglie dell'albero
	public int NumFoglie() {
		LinkedList<NodoPFFS<T>> Foglie = new LinkedList<>();
		LinkedList<NodoPFFS<T>> coda = new LinkedList<>();
		coda.addFirst(radice);
		while (!coda.isEmpty()) {
			NodoPFFS<T> u = coda.remove();
			if (u != null) {
				if (u.getPrimoF() == null) {
					Foglie.add(u);
				}
				coda.add(u.getPrimoF());
				coda.add(u.getFratello());
			}
		}
		return Foglie.size();
	}

	// altezza dell'albero
	public int Altezza() {
		return altezza + 1;
	}

	// stringa rappresentativa
	public String toString() {
		String[] t = { "" };
		if (radice != null)
			t[0] = t[0] + radice.getInfo();
		if (radice.getPrimoF() != null)
			t[0] = t[0] + "[";
		f(radice.getPrimoF(), t);
		return t[0];
	}

	private void f(NodoPFFS<T> v, String[] t) {
		if (v.getInfo() == null) {
			t[0] = t[0] + "null";
			return;
		}
		if (v.getInfo() != null) {
			t[0] = t[0] + v.getInfo();
			if (v.getPrimoF() != null) {
				t[0] = t[0] + "[";
				f(v.getPrimoF(), t);
			}
			if (v.getFratello() != null) {
				t[0] = t[0] + ",";
				f(v.getFratello(), t);
			} else
				t[0] = t[0] + "]";
		}
	}
}
