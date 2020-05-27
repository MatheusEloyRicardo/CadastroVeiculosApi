package model;

public class CarroBean {
	private int id;
	private String veiculo;
	private String marca;
	private int ano;
	private String descricao;
	private boolean vendido;
	
	public CarroBean() {}
	
	public CarroBean(
			String veiculo,
			String marca,
			int ano,
			String descricao,
			boolean vendido
			) {
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public CarroBean(
			int id,
			String veiculo,
			String marca,
			int ano,
			String descricao,
			boolean vendido
			) {
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isVendido() {
		return vendido;
	}
	
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
}
