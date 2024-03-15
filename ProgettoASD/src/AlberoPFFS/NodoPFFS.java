// Giulio Morandini matricola 7030209

package AlberoPFFS;

public class NodoPFFS<T> {
	private T info;
	private NodoPFFS<T> PrimoF, Padre, Fratello; //PrimoF puntatore al primo figlio, Fratello puntatore al primo fratello

	// costruttore
	public NodoPFFS(T data) {
		data = info;
		PrimoF = null;
		Padre = null;
		Fratello = null;
	}

	// accessori e mutatori
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NodoPFFS<T> getPrimoF() {
		return PrimoF;
	}

	public void setprimoF(NodoPFFS<T> primoF) {
		this.PrimoF = primoF;
	}

	public NodoPFFS<T> getPadre() {
		return Padre;
	}

	public void setPadre(NodoPFFS<T> padre) {
		this.Padre = padre;
	}

	public NodoPFFS<T> getFratello() {
		return Fratello;
	}

	public void setFratello(NodoPFFS<T> Fratello) {
		this.Fratello = Fratello;
	}

	public int Livello() {
		int livello = 0;
		NodoPFFS<T> lev = this.getPadre();
		while (lev != null) {
			livello++;
			lev = lev.getPadre();
		}
		return livello;
	}

	public String toString() {
		if (info == null)
			return null;
		return info.toString();
	}
}
