package ex1;

public class Confirmacao {
	private int codigo;
	private String mensagem;
	private String token;
	
	public Confirmacao() {
		this.codigo = 200;
		this.mensagem = null;
		this.token = null;
	}
	
	public Confirmacao(String mensagem) {
		this.codigo = 500;
		this.mensagem = mensagem;
	}
	
	public Confirmacao(int codigo, String token) {
		this.codigo = 200;
		this.token = token;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}