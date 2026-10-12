public class Animacion extends Trabajo {
	protected int fotogramas;
	
	public Animacion(int codigo, String estudio, String proyecto, float horas, String horario, String estado, int intentosEjecutados, int fotogramas) {
		if (horario.equals("diurno")){
			horas +=  24;
		}else{
			horas += 36;
		}
		super(codigo, estudio, proyecto, horas, horario, estado, intentosEjecutados);
		this.fotogramas = fotogramas;
	}
	
	public void Setfotogramas(int newfotogramas) {
		this.fotogramas =newfotogramas;
	}
	
	public int Getfotogramas() {
		return this.fotogramas;
	}
	
	public String toString() {
		String cadena = "Trabajo: Animacion";
		cadena += " |Codigo: "+codigo+" |Estudio: "+estudio+" |Proyecto: "+proyecto+" |Horas: "+horas+" |Horario: "+horario+" |Estado: "+estado+" |Intentos ejecutados: "+intentosEjecutados+" |Fotogramas: "+fotogramas;
		return cadena;
	}
	
	public float cotizar() {
		float costo = 0;
		if (horario.equals("diurno")){
			costo = 60;
		}else{
			costo = 40;
		}

		float horasFacturables = (int) Math.ceil(fotogramas * 0.02); //Funcion techo, calculo de horas por fotogramas

		if (horasFacturables<horas){horasFacturables=horas;} //Si las horas estimadas son más se remplaza el valor de horas facturables.

		costo += 15*horasFacturables; //Se suma el extra por horas facturables a la base

		return costo;
		
	}
}
