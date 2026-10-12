import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Sistema s = new Sistema();

		System.out.println("¡Bienvenido!");

		int op = 0;
		while(op != 13){
			try{
			System.out.println("-----------------------Menu------------------------------");
			System.out.println("1. Cotizar/registrar Trabajo\n2. Registrar nodo\n3. Crear Lote\n4. Asignar Trabajo\n5. Asignar Lote\n6. Retirar Trabajo\n7. Iniciar Lote\n8. Buscar Trabajo\n9. Buscar Nodo\n10.Reportes\n11. Salir");
			System.out.println("---------------------------------------------------------");
			System.out.println("Ingrese la opción que desee:");
			op = teclado.nextInt(); teclado.nextLine(); }
			catch(Exception e){
				teclado.nextLine();
				System.out.println("Ha ingresado una opción no permitida.");
			}finally{
				System.out.println("---------------------------------------------------------");
			}
			
			boolean error=true;

			switch (op) {
				case 1: //Cotizar trabajo
					error = true;
					while (error) {
						try{
							System.out.println("Ingrese los datos del nuevo trabajo");
							System.out.println("Código:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							System.out.println("Estudio:");
							String estudio = teclado.nextLine();
							System.out.println("Proyecto:");
							String proyecto = teclado.nextLine();
							System.out.println("Horario: (diurno/nocturno)");
							String horario =  teclado.nextLine();

							System.out.println("Tipo (1. Imagen/ 2. Animacion/ 3.Animacion postproduccion/ 4. Simulacion Fisica");
							int tipo =  teclado.nextInt();teclado.nextLine();

							Trabajo t = null;
							if (tipo==1){
								t = new Imagen(codigo, estudio, proyecto, horario, "en cola",0);
							}
							if (tipo==2){
								System.out.println("Fotogramas:");
								int foto = teclado.nextInt(); teclado.nextLine();
								 t = new Animacion(codigo, estudio, proyecto,0, horario, "en cola",0,foto);
							}
							if (tipo==3){
								System.out.println("Fotogramas:");
								int foto = teclado.nextInt(); teclado.nextLine();
								System.out.println("Conposicion:");
								String composicion = teclado.nextLine();
								System.out.println("Licencias (Q.):");
								float licencias = teclado.nextFloat(); teclado.nextLine();
								 t = new AnimacionPost(codigo, estudio, proyecto, horario, "en cola",0,foto,composicion,licencias);
							}
							if (tipo==4){
								System.out.println("Resolucion:");
								float r = teclado.nextFloat(); teclado.nextLine();
								 t = new SimulacionFisica(codigo, estudio, proyecto, horario, "en cola",0,r);
							}
	
							error = false;
							System.out.print("----------------------------------------");
							System.out.println(s.cotizar(t));
							System.out.println("Desea registrar el trabajo (1.Si 2.No):");
							float r = teclado.nextFloat(); teclado.nextLine();
							if(r==1){
								s.registrar(codigo);
							}
		
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Trabajo registrado.\n--------------------------------------------------------");
				break;

				case 2:
					error = true;
					while (error) {
						try{
							System.out.println("Ingrese los datos del nuevo Nodo");
							System.out.println("Código:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							
							System.out.println("Capacidad:");
							int capacidad = teclado.nextInt(); teclado.nextLine();
							System.out.println("GPU: (1.Si 2.No");
							int gpu = teclado.nextInt(); teclado.nextLine();
							
							if(gpu==1){
								s.registrarNodo(codigo, capacidad, true);
							}else{
								s.registrarNodo(codigo, capacidad, false);
							}
							error = false;
							
		
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Nodo registrado");
						
				break;

				case 3:
					error = true;
					while (error) {
						try{
							System.out.println("Ingrese los datos del nuevo Lote");
							System.out.println("Código:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							
							s.crearLote(codigo);

							error = false;
							
		
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Lote registrado");
						
				break;

				case 4:
					error = true;
					while (error) {
						try{
							System.out.println("Asignar Trabajo");
							System.out.println("Código Trabajo:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							System.out.println("Código Nodo:");
							int codigoL = teclado.nextInt(); teclado.nextLine();
							
							Trabajo tr = null;
							Nodo nod = null;
							for (Trabajo t:s.GetTrabajos()){
								if(t.Getcodigo()==codigo){tr=t;}
							}
							for (Nodo n:s.GetNodos()){
								if(n.Getcodigo()==codigoL){nod = n;}
							}
							
							s.asignarTrabajo(nod, tr);
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Trabajo asignado");
						
				break;

				case 5:
					error = true;
					while (error) {
						try{
							System.out.println("Asignar Nodo");
							System.out.println("Código Nodo:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							System.out.println("Código Lote:");
							int codigoL = teclado.nextInt(); teclado.nextLine();
							
							Lote l = null;
							Nodo nod = null;
							for (Lote lo:s.Getlotes()){
								if(lo.Getcodigo()==codigo){l=lo;}
							}
							for (Nodo n:s.GetNodos()){
								if(n.Getcodigo()==codigoL){nod = n;}
							}
							
							s.asignarNodo(l, nod);
							
							error=false;
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Nodo asignado");
						
				break;

				case 6:
					error = true;
					while (error) {
						try{
							System.out.println("Retirar Trabajo");
							System.out.println("Código Trabajo:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							System.out.println("Código Nodo:");
							int codigoL = teclado.nextInt(); teclado.nextLine();
							
							Trabajo tr = null;
							Nodo nod = null;
							for (Trabajo t:s.GetTrabajos()){
								if(t.Getcodigo()==codigo){tr=t;}
							}
							for (Nodo n:s.GetNodos()){
								if(n.Getcodigo()==codigoL){nod = n;}
							}
							
							s.retirarTrabajo(nod, tr);
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
					System.out.println("Trabajo retirado");
						
				break;

				case 7:
					error = true;
					while (error) {
						try{
							System.out.println("Inciar Lote");
							System.out.println("Código Lote:");
							int codigoL = teclado.nextInt(); teclado.nextLine();
							
							System.out.println(s.IniciarLote(codigoL));
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}
						
				break;

				case 8:
					error = true;
					while (error) {
						try{
							System.out.println("Buscar Trabajo");
							System.out.println("Código Trabajo:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							
							System.out.println(s.buscarTrabajo(codigo));
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}						
				break;

				case 9:
					error = true;
					while (error) {
						try{
							System.out.println("Buscar Nodo");
							System.out.println("Código Nodo:");
							int codigo = teclado.nextInt(); teclado.nextLine();
							
							System.out.println(s.buscarNodo(codigo));
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}						
				break;
				
				case 10:
					error = true;
					while (error) {
						try{
							System.out.println("Generar Reporte");
							System.out.println("Tipo de reporte (1. Trabajos / 2.Ingresos / 3.Lotes):");
							int o = teclado.nextInt(); teclado.nextLine();
							
							System.out.println(s.reporte(o));
							error = false;
							
						}catch (Exception e){
							System.out.println("Ha ingresado el dato en un formato no permitido.");
						}
					}						
				break;
					

				
				case 11:
					System.out.println("Caso cerrado. ¡Adiós!");
					break;

				default:
					System.out.println("Ha ingresado una opción no permitida.");
				break;
			}
		}
	}
}

