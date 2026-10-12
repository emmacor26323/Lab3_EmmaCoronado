import java.util.ArrayList;

public class Lote {
	private int codigo;
	private String estado;
	private ArrayList<Nodo> nodos;

	public Lote(){
		
	}
	
	public Lote(int codigo, String estado) {
		this.codigo = codigo;
		this.estado = estado;
		this.nodos = new ArrayList<>();
	}
	
	public void Setcodigo(int newcodigo) {
		this.codigo = newcodigo;
	}
	
	public int Getcodigo() {
		return this.codigo;
	}
	
	public void Setestado(String newestado) {
		this.estado = newestado;
	}
	
	public String Getestado() {
		return this.estado;
	}
	
	public void Setnodos(ArrayList<Nodo> newnodos) {
		this.nodos = newnodos;
	}
	
	public ArrayList<Nodo> Getnodos() {
		return this.nodos;
	}
}
