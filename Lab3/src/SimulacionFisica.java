public class SimulacionFisica extends Trabajo {
	private float resolucion;
	
	public SimulacionFisica(int codigo, String estudio, String proyecto, String horario, String estado, int intentosEjecutados, float resolucion) {
		super(codigo, estudio, proyecto, 18, horario, estado, intentosEjecutados);
		this.resolucion = resolucion;
	}

	public void setResolucion(float newresolucion){
		this.resolucion = newresolucion;
	}

	public float getResolucion(){
		return this.resolucion;
	}
	
	public String toString() {
		String cadena = "Trabajo: Simulacion Fisica";
		cadena += " |Codigo: "+codigo+" |Estudio: "+estudio+" |Proyecto: "+proyecto+" |Horas: "+horas+" |Horario: "+horario+" |Estado: "+estado+" |Intentos ejecutados: "+intentosEjecutados+" |Resolucion: "+resolucion;
		return cadena;
	}
	
	public float cotizar() {
		float costo = 40; //Costo base

		costo += 22*horas; //Costo por horas estimadas
		costo += 65; //Cargo por uso de gpu.
		
		return costo;
	}
	
}
