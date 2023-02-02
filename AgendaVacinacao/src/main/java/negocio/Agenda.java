package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agendas", schema = "vacinacao")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate data;
	private LocalTime hora;
	
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private EnumTipo situacao;
	
	@Column(nullable = true, name = "data_situacao")
	private LocalDate dataSituacao;
	
	@Column(nullable = true, length = 200)
	private String observacoes;
	
	@ManyToOne	
	private Usuario usuario;
	
	@ManyToOne
	private Vacina vacina;
	
	public Agenda() {
		
	}

	public Agenda(LocalDate data, LocalTime hora, EnumTipo situacao, LocalDate dataSituacao, String observacoes) {
		this.data = data;
		this.hora = hora;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.observacoes = observacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EnumTipo getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumTipo situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(LocalDate dataSituacao) {
		this.dataSituacao = dataSituacao;
	}
	

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
