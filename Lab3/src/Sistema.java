import java.util.ArrayList;

public class Sistema {
	private float ingresos;
	private float ingresosIntentos;
	private ArrayList<Lote> lotes;
	private ArrayList<Nodo> nodos;
	private ArrayList<Trabajo> trabajos;
	
	public Sistema() {
		this.ingresos = 0;
		this.lotes = new ArrayList<>();
		this.nodos = new ArrayList<>();
		this.trabajos = new ArrayList<>();
	}
	
	public void setIngresos(float newingresos){
		this.ingresos = newingresos;
	}

	public float getIngrsos(){
		return ingresos;
	}

	public void Setlotes(ArrayList<Lote> newlotes) {
		this.lotes = newlotes;
	}
	
	public ArrayList<Lote> Getlotes() {
		return this.lotes;
	}
	
	public void SetNodos(ArrayList<Nodo> newNodos) {
		this.nodos = newNodos;
	}
	
	public ArrayList<Nodo> GetNodos() {
		return this.nodos;
	}
	
	public void SetTrabajos(ArrayList<Trabajo> newTrabajos) {
		this.trabajos = newTrabajos;
	}
	
	public ArrayList<Trabajo> GetTrabajos() {
		return this.trabajos;
	}
	
	public String cotizar(Trabajo t) {
		String cadena = "";
		cadena = t.toString(); //Datos del trabajo
		cadena += "\n-------------------------------\n";
		cadena += "Total cotizado: Q"+t.cotizar(); //Cotizacion

		return cadena;
	}
	
	public void registrar(int cod) {
		boolean e=false;
		for(Trabajo t:trabajos){
			if(t.Getcodigo()==cod){ //Busca el trabajo coreespondiente
				ingresos += t.cotizar();
				t.Setestado("en cola"); //Agrega ingresos y cambia estado
				e = true;
				trabajos.add(t);
			}
		}
		if(e==false){
			throw new RuntimeException("Trabajo no encontrado");
		}
	}
	
	public void registrarNodo(int codigo,int capacidad, boolean gpu) {
		Nodo n = new Nodo(codigo, capacidad, gpu); //Crea nuevo nodo
		nodos.add(n); //Registra el nodo
	}
	
	public void asignarTrabajo(Nodo n, Trabajo t) {
		n.GetTrabajos().add(t); //Asigna trabajo a lista de nodo
		t.Setestado("asignado"); //Cambia estado de trabajo
	}
	
	public void retirarTrabajo(Nodo n, Trabajo t) {
		n.GetTrabajos().remove(t); //Elimina el trabajo
		t.Setestado("en cola"); //Cambia estado de trabajo
	}
	
	public void crearLote(int id) {
		Lote l = new Lote(id, "preparacion"); //Crea lote
		lotes.add(l); //Registra el lote
	}
	
	public void asignarNodo(Lote lote, Nodo nodo) {
		lote.Getnodos().add(nodo); //Agrega el nodo a la lista de lote
	}
	
	public void RetirarNodo(Lote lote, Nodo nodo) {
		lote.Getnodos().remove(nodo); //Elimina el nodo de lista
	}
	
	public String IniciarLote(int id) {
		Lote l = new Lote();
		boolean e = false;
		for (Lote lote:lotes){ //Busca el lote
			if(lote.Getcodigo()==id){
				l = lote;
				e =true;
			}
		}

		if(e==false){return "No se encontró el lote";}

		if(l.Getestado().equals("preparacion")){ //Compueba estado de Lote
			String m=""; //Variable para mensajes

			l.Setestado("ejecucion"); //Cambia estado de trabajo

			for(Nodo n:l.Getnodos()){ //PARA CADA NODO
				int sumaH = 0;

				if (n.GetTrabajos().isEmpty()){m += "No se pueden iniciar nodos vacios.\n";}

				for (Trabajo t : n.GetTrabajos()) { //Suma de horas 
					sumaH += t.Gethoras();
					t.SetintentosEjecutados(t.GetintentosEjecutados()+1);
				}
				if (sumaH>n.Getcapacidad()){ //Valida capacidad
					m += "El nodo: "+n.Getcodigo()+" no se pudo ejecutar por falta de capacidad.\n";
				}else{
					for (Trabajo t : n.GetTrabajos()) { //Ejecuta
						t.Setestado("ejecucion");
						if (t.GetintentosEjecutados()>1){ingresosIntentos += 25;}
					}

					m += "Nodo "+n.Getcodigo()+" ejecutado.";
				}
			}

			return m;
		}else{return "El lote no el estado adecuado para inciarlo. Ya se incio, completo o cancelo."; }
	}
	
	public String buscarTrabajo(int id) {
		for(Trabajo t:trabajos){
			if(t.Getcodigo()==id){ //Compruba id y devuelve informacion
				return t.toString();
			}
		}
		return "Trabajo no encontrado";
	}
	
	public String buscarNodo(int id) {
		for(Nodo n:nodos){
			if(n.Getcodigo()==id){ //Compruba id y devuelve informacion
				return n.toString();
			}
		}
		return "Trabajo no encontrado";
	}
	
	public String reporte(int tipo) {
		String cadena = "REPORTE\n----------------------------\n";
		switch (tipo) {
			case 1: //Trabajos
				int tAnimacion = 0;
				int tAnimacionP = 0;
				int tImagen = 0;
				int tSimu = 0;
				int tcola = 0;
				int tasignado = 0;
				int tejecución = 0;
				int tcompletado=0;
				int tcancelado = 0;

				for (Trabajo t:trabajos){ //Valida cada caso y suma
					if(t instanceof Animacion){tAnimacion++;}
					if(t instanceof AnimacionPost){tAnimacionP++;}
					if(t instanceof Imagen){tImagen++;}
					if(t instanceof SimulacionFisica){tSimu++;}

					if(t.Getestado().equals("en cola")){tcola++;}
					if(t.Getestado().equals("asignado")){tasignado++;}
					if(t.Getestado().equals("ejecucion")){tejecución++;}
					if(t.Getestado().equals("completado")){tcompletado++;}
					if(t.Getestado().equals("cancelado")){tcancelado++;}
				}

				cadena += "Trabajos de imagen fija: "+tImagen+"\n";
				cadena += "Trabajos de Animacion: "+tAnimacion+"\n";
				cadena += "Trabajos de Animacion Postproduccion: "+tAnimacionP+"\n";
				cadena += "Trabajos de Simulacion Fisica: "+tSimu+"\n";
				cadena += "Trabajos en cola: "+tcola+"\n";
				cadena += "Trabajos asignados: "+tasignado+"\n";
				cadena += "Trabajos en ejecucion: "+tejecución+"\n";
				cadena += "Trabajos completados: "+tcompletado+"\n";
				cadena += "Trabajos cancelados: "+tcancelado+"\n";
				
				break;
			
			case 2: 
					cadena += "Ingresos totales:"+ingresos+ingresosIntentos+"\n";
					cadena += "Ingresos por trabajos:"+ingresos+"\n";
					cadena += "Ingresos por Intentos:"+ingresosIntentos+"\n";
				break;

			case 3: //Lotes
					for(Lote l:lotes){
						if(l.Getestado()!="cerrado"){
							cadena+= "Lote "+l.Getcodigo()+"|Nodos: ";
							int horasT =0;
							int capacidad =0;
							for(Nodo n:nodos){
								cadena +=n.Getcodigo()+",";
								capacidad += n.Getcapacidad();
								for(Trabajo t:n.GetTrabajos()){
									horasT += t.Gethoras();
								}
							}
							cadena +="|Horas asignadas:"+horasT+" |Capacidad: "+capacidad+"\n";
						}
					}
				break;
			
		}
		return cadena;

	}
}
