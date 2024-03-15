// Giulio Morandini matricola 7030209

package AlberoPFFS;

public class Run {

	public static void main(String[] args) {
		AlberoPFFS<String> T = new AlberoPFFS<String>();

		// inserisco la radice
		NodoPFFS<String> radice = T.aggiungiRadice("Carlo");

		// aggiungo i vari nodi
		NodoPFFS<String> figlio = T.aggiungiNodo(radice, "Figlio");
		NodoPFFS<String> nipote = T.aggiungiNodo(figlio, "Nipote");
		NodoPFFS<String> fratello = T.aggiungiNodo(radice, "Fratello");
		NodoPFFS<String> sorella = T.aggiungiNodo(radice, "Sorella");
		NodoPFFS<String> cugino = T.aggiungiNodo(sorella, "Cugino");
		NodoPFFS<String> cugina = T.aggiungiNodo(fratello, "Cugina");
		NodoPFFS<String> bob = T.aggiungiNodo(sorella, "Bob");

		// cambio la radice
		NodoPFFS<String> Nonno = T.nuovaRadice("Nonno");

		// cambio contenuto di un nodo
		radice.setInfo("Radice");

		// visite dell'albero in ampiezza e profondità
		System.out.print("Visita in profondità dell'albero: [ ");
		for (int i = 0; i < T.VisitaProf().size(); i++) {
			System.out.print(T.VisitaProf().get(i) + " ");
		}
		System.out.println("];");
		System.out.print("Visita in ampiezza dell'albero: [ ");
		for (int i = 0; i < T.VisitaAmp().size(); i++) {
			System.out.print(T.VisitaAmp().get(i) + " ");
		}
		System.out.println("];");

		// restituisco il numero dei nodi
		System.out.print("Numero dei nodi dell'albero: ");
		System.out.println(T.Nodi() + ";");

		// restituisco i vari numeri dei figli
		System.out.println("Restituisco quanti figli ha ogni nodo:");
		System.out.print("Nonno:" + T.NumFigli(Nonno) + " ");
		System.out.print("Carlo:" + T.NumFigli(radice) + " ");
		System.out.print("Figlio:" + T.NumFigli(figlio) + " ");
		System.out.print("Fratello:" + T.NumFigli(fratello) + " ");
		System.out.print("Sorella:" + T.NumFigli(sorella) + " ");
		System.out.print("Nipote:" + T.NumFigli(nipote) + " ");
		System.out.print("Cugina:" + T.NumFigli(cugina) + " ");
		System.out.print("Cugino:" + T.NumFigli(cugino) + " ");
		System.out.println("Bob:" + T.NumFigli(bob) + ";");

		// restituisco due liste dei figli
		System.out.print("Lista dei figli di 'radice': ");
		System.out.println(T.ListaFigli(radice).toString() + ";");
		System.out.print("Lista dei figli di 'nipote': ");
		System.out.println(T.ListaFigli(nipote) + ";");
		System.out.print("Lista dei figli di 'sorella': ");
		System.out.println(T.ListaFigli(sorella).toString() + ";");

		// restituisco il contenuto di un nodo
		System.out.println("Contenuto della variabile radice: " + radice.toString() + ";");// oppure radice.getInfo()

		// restituisco la radice
		System.out.println("La radice dell'albero e': " + T.getRadice().toString() + ";");

		// restituisco il padre di un nodo
		System.out.println("Il padre di '" + cugino.toString() + "' e': " + cugino.getPadre().toString() + ";");

		// restituisco il numero delle foglie dell'albero
		System.out.println("Il numero delle foglie dell'albero e': " + T.NumFoglie() + ";");

		// restituisco l'altezza dell'albero
		System.out.println("L'altezza dell'albero e': " + T.Altezza() + ";");

		// restituisco livelli di vari nodi
		System.out.println("Il livello del nodo '" + Nonno.toString() + "' e': " + Nonno.Livello() + ";");
		System.out.println("Il livello del nodo '" + radice.toString() + "' e': " + radice.Livello() + ";");
		System.out.println("Il livello del nodo '" + figlio.toString() + "' e': " + figlio.Livello() + ";");
		System.out.println("Il livello del nodo '" + fratello.toString() + "' e': " + fratello.Livello() + ";");
		System.out.println("Il livello del nodo '" + nipote.toString() + "' e': " + nipote.Livello() + ";");

		// stringa rappresentativa dell'albero
		System.out.println(T.toString() + ";");
	}
}
