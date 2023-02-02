package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "vacinacao")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 60)
	private String nome;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(length = 1)
	private Character sexo;
	
	@Column(length = 60)
	private String lougradouro;
	
	private Double numero;
	
	@Column(length = 40)
	private String setor;
	
	@Column(length = 40)
	private String cidade;

	@Column(length = 2)
	private String uf;
	
	@OneToMany(mappedBy = "usuario")
	private List<Agenda> agendas = new ArrayList<>();
		
	@ManyToMany
	@JoinTable(name = "usuarios_alergias", joinColumns = @JoinColumn(name ="id_usuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_alergia", referencedColumnName = "id"))
	private List<Alergia> alergias = new ArrayList<>();
	
	
	public Usuario() {
	
	}

	public Usuario(String nome, LocalDate dataNascimento, Character sexo, String lougradouro, Double numero, String setor, String cidade, String uf) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.lougradouro = lougradouro;
		this.numero = numero;
		this.setor = setor;
		this.cidade = cidade;
		this.uf = uf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getLougradouro() {
		return lougradouro;
	}

	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}

	public Double getNumero() {
		return numero;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}
		
}
