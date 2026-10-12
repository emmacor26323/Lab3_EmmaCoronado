public class Imagen extends Trabajo {
	
	public Imagen(int codigo, String estudio, String proyecto, String horario, String estado, int intentosEjecutados) {
		float horas = 0;
		if (horario.equals("diurno")){
			horas +=  4;
		}else{
			horas += 10;
		}
		super(codigo, estudio, proyecto, horas, horario, estado, intentosEjecutados);
	}
	
	public String toString() {
		String cadena = "Trabajo: Imagen fija";
		cadena += " |Codigo: "+codigo+" |Estudio: "+estudio+" |Proyecto: "+proyecto+" |Horas: "+horas+" |Horario: "+horario+" |Estado: "+estado+" |Intentos ejecutados: "+intentosEjecutados;
		return cadena;
	}
	
	public float cotizar() {
		if (horario.equals("diurno")){
			return 45;
		}else{
			return 30;
		}
	}
}
