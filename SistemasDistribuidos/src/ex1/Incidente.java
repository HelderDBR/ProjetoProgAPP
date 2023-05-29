package ex1;

public class Incidente {
	private int id;
	private String data;
	private String rodovia;
	private int km;
	private int tipo_incidente;
	
	public Incidente(int id, String data, String rodovia, int km, int tipo_incidente) {
		super();
		this.id = id;
		this.data = data;
		this.rodovia = rodovia;
		this.km = km;
		this.tipo_incidente = tipo_incidente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRodovia() {
		return rodovia;
	}

	public void setRodovia(String rodovia) {
		this.rodovia = rodovia;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getTipo_incidente() {
		return tipo_incidente;
	}

	public void setTipo_incidente(int tipo_incidente) {
		this.tipo_incidente = tipo_incidente;
	}
	
}
