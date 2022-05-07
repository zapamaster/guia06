package died.guia06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	private int creditos;

	public Alumno() {
		super();
		this.nombre = "Juan Perez";
		this.creditos = 10000;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public int asignarCreditos(int num) {
		return this.creditos = num;
	}
	public int creditosObtenidos() {
		return this.creditos;
	}
	
	public void cursar(Curso c) {
		this.cursando.add(c);
	}
	
	public int materiasCursando() {
		return this.cursando.size();
		}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nroLibreta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nroLibreta, other.nroLibreta);
	}
	@Override
	public int compareTo(Alumno o) {
		if(this.nombre == o.nombre) return 1;
		if(this.nombre != o.nombre) return -1;
		return 0;
	}
}

