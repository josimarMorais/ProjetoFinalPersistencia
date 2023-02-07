package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacinas")
public class Vacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false)
	private String titulo;

	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private int doses;
	
	@Column(nullable = true)
	private int periocidade;
	
	@Column(nullable = true)
	private int intervalo;
	
	
	
	public Vacina() {
		
	}

	public Vacina(String titulo, String descricao, int doses, int periocidade, int intervalo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.doses = doses;
		this.periocidade = periocidade;
		this.intervalo = intervalo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}

	public int getPeriocidade() {
		return periocidade;
	}

	public void setPeriocidade(int periocidade) {
		this.periocidade = periocidade;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
}
