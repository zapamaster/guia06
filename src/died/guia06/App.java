package died.guia06;

public class App {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		Curso curso2 = new Curso(200);
		Curso curso3 = new Curso(200);
		Curso curso4 = new Curso(200);
		Alumno a1 = new Alumno();
		a1.cursar(curso2);
		a1.cursar(curso3);
		a1.cursar(curso4);
	
		
		try {
		curso1.inscribirAlumno(a1);
		}
		catch(CreditosInsuficientes | CuposInsuficientes | CursandoMasMaterias ex){
			System.out.println(ex.getMessage());
		}
		
	}
}
