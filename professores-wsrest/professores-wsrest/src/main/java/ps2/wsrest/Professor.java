package ps2.wsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professores")
public class Professor {
	@Id @GeneratedValue
	private long id;
	private String nome;
	private int matricula;
	private String area;
	public Professor() {}
	public Professor (long id, String nome, int matricula, String area) {
		super();
		this.id = id;
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setArea(area);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
