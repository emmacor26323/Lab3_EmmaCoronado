import java.util.ArrayList;

public class Nodo {
	private int codigo;
	private int capacidad;
	private boolean gpu;
	private ArrayList<Trabajo> trabajos;
	
	public Nodo(int codigo,int capacidad,boolean gpu) {
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.gpu = gpu;
		this.trabajos = new ArrayList<>();
	}
	
	public void Setcodigo(int newcodigo) {
		this.codigo = newcodigo;
	}
	
	public int Getcodigo() {
		return this.codigo;
	}
	
	public void Setcapacidad(int newcapacidad) {
		this.capacidad = newcapacidad;
	}
	
	public int Getcapacidad() {
		return this.capacidad;
	}
	
	public void Setgpu(boolean newgpu) {
		this.gpu = newgpu;
	}
	
	public boolean Getgpu() {
		return this.gpu;
	}
	
	public void SetTrabajos(ArrayList<Trabajo> newtrabajos) {
		this.trabajos = newtrabajos;
	}
	
	public ArrayList<Trabajo> GetTrabajos() {
		return this.trabajos;
	}
}
