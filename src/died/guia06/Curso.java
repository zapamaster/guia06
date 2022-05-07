package died.guia06;

import java.util.ArrayList;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditosRequeridos = 1000;
		this.cupo=0;
	}
	public Curso(int cred) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditosRequeridos = cred;
	}
	
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a){
		try {
		log.registrar(this, "inscribir ",a.toString());
		}
		catch(Exception e1) {
			System.out.println("Error");
			e1.printStackTrace();
		}
		return false;
		}
	
	public void inscribirAlumno(Alumno a) throws  CreditosInsuficientes, CuposInsuficientes, CursandoMasMaterias{

		if(this.creditosRequeridos > a.creditosObtenidos()) {
			throw new CreditosInsuficientes("No tiene creditos suficientes");
		}
		if(this.inscriptos.size() > this.cupo) {
			throw new CuposInsuficientes("No hay cupo");
		}
		if(a.materiasCursando() >= 3){
			throw new CursandoMasMaterias("Ya est� cursando m�s de 3(tres) materias");
		}
		else {
			this.inscriptos.add(a);
			System.out.println("Se ha inscripto el alumno");
		}
		
	} 
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch(Exception e2) {
			System.out.println("Error");
		}
	}


}
