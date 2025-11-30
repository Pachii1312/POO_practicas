package Ej3;

public class Alimentos {
	private String alimento;
	private String estado;
	private double calorias;
	private double grasas;
	private double proteinas;
	private double carbohidratos;
	private String tipo;
	
	public Alimentos () {
		
	}

	public Alimentos(String alimento, String estado, double calorias, double grasas, double proteinas,
			double carbohidratos, String tipo) {
		this.alimento = alimento;
		this.estado = estado;
		this.calorias = calorias;
		this.grasas = grasas;
		this.proteinas = proteinas;
		this.carbohidratos = carbohidratos;
		this.tipo = tipo;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alimentos:[alimento=" + alimento + ", estado=" + estado + ", calorias=" + calorias + ", grasas="
				+ grasas + ", proteinas=" + proteinas + ", carbohidratos=" + carbohidratos + ", tipo=" + tipo + "]";
	}
	
	
	
}
