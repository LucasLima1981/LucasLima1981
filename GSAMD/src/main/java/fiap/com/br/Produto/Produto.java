package fiap.com.br.Produto;

import java.math.BigDecimal;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTOS")
public class Produto {
	
	@Id
	@SequenceGenerator(name = "SEQPRODUTO", sequenceName = "SEQ_PRODUTOS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQPRODUTO")
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "preço")
	private Double preco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	public Vector<String> getData() {
		Vector<String> columns = new Vector<String>();
		columns.add(String.valueOf(id));
		columns.add(nome);
		columns.add(rua);
		columns.add(bairro);
		columns.add(cidade);
		columns.add(String.valueOf(preco));
		columns.add(estado);
		
		return columns;
	}
}
