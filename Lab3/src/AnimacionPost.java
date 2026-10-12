public class AnimacionPost extends Animacion {
	public String composicion;
	public float licencias;

	public AnimacionPost(int codigo, String estudio, String proyecto, String horario, String estado, int intentosEjecutados, int fotogramas, String composicion, float licencias) {
		super(codigo, estudio, proyecto, 12, horario, estado, intentosEjecutados, fotogramas);
		this.composicion = composicion;
		this.licencias = licencias;
	}
	
	public void Setcomposicion(String newcomposicion) {
		this.composicion = newcomposicion;
	}
	
	public String Getcomposicion() {
		return this.composicion;
	}
	
	public void Setlicencias(float newlicencias) {
		this.licencias = newlicencias;
	}
	
	public float Getlicencias() {
		return licencias;
	}
	
	public String toString() {
		String cadena = "Trabajo: Animacion Postproduccion";
		cadena += " |Codigo: "+codigo+" |Estudio: "+estudio+" |Proyecto: "+proyecto+" |Horas: "+horas+" |Horario: "+horario+" |Estado: "+estado+" |Intentos ejecutados: "+intentosEjecutados+" |Fotogramas: "+fotogramas;
		cadena += " |Coposicion: "+composicion+" |Licencias: "+licencias;
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
		costo += 80; //Recargo por composicion
		costo += licencias*0.5; //5% del costo de las licencias

		return costo;
	}
}
