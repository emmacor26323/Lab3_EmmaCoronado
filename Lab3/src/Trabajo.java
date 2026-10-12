public abstract class Trabajo {
	protected int codigo;
	protected String estudio;
	protected String proyecto;
	protected float horas;
	protected String horario;
	protected String estado;
	protected int intentosEjecutados;


	public Trabajo(int codigo, String estudio, String proyecto, float horas, String horario, String estado, int intentosEjecutados){
		this.codigo = codigo;
		this.estudio = estudio;
		this.horas = horas;
		this.horario = horario;
		this.estado = estado;
		this.intentosEjecutados = intentosEjecutados;
	}
	
	public void Setcodigo(int newcodigo) {
		this.codigo = newcodigo;
	}
	
	public int Getcodigo() {
		return this.codigo;
	}
	
	public void Setestudio(String newestudio) {
		this.estudio = newestudio;
	}
	
	public String Getestudio() {
		return this.estudio;
	}
	
	public void Setproyecto(String newproyecto) {
		this.proyecto = newproyecto;
	}
	
	public String Getproyecto() {
		return this.proyecto;
	}
	
	public void Sethoras(float newhoras) {
		this.horas = newhoras;
	}
	
	public float Gethoras() {
		return this.horas;
	}
	
	public void Sethorario(String newhorario) {
		this.horario = newhorario;
	}
	
	public String Gethorario() {
		return this.horario;
	}
	
	public void Setestado(String newestado) {
		this.estado = newestado;
	}
	
	public String Getestado() {
		return this.estado;
	}
	
	public void SetintentosEjecutados(int newintentosEjecutados) {
		this.intentosEjecutados = newintentosEjecutados;
	}
	
	public int GetintentosEjecutados() {
		return  intentosEjecutados;
	}
	
	public abstract String toString();
	
	public abstract float cotizar();
}
