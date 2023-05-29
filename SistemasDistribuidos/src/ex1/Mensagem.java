package ex1;

public class Mensagem {
	private Integer id_operacao;
	private String nome;
	private String email;
	private String senha;
	private String token;
	private Integer id_usuario;
	private String data;
	private String rodovia;
	private Integer km;
	private Integer tipo_incidente;
	private String faixa_km;
	private Integer codigo;
	
	//cadastro
	public Mensagem(Integer id_operacao, String nome, String email, String senha) {
		this.id_operacao = id_operacao;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	//login
	public Mensagem(Integer id_operacao, String email, String senha) {
		this.id_operacao = id_operacao;
		this.email = email;
		this.senha = senha;
	}
	
	//logout e confirmacao login
	public Mensagem(Integer id_operacao, Integer codigo, String token, int id_usuario) {
		this.id_operacao = id_operacao;
		this.codigo = codigo;
		this.token = token;
		this.id_usuario = id_usuario;
	}
	
	//atualizar cadastro
	public Mensagem(Integer id_operacao, String nome, String email, String senha, String token, int id_usuario) {
		this.id_operacao = id_operacao;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.token = token;
		this.id_usuario = id_usuario;
	}
	
	//reportar incidente
	public Mensagem(Integer id_operacao, String data, String rodovia, Integer km, Integer tipo_incidente, String token, Integer id_usuario) {
		this.id_operacao = id_operacao;
		this.token = token;
		this.id_usuario = id_usuario;
		this.data = data;
		this.rodovia = rodovia;
		this.km = km;
		this.tipo_incidente = tipo_incidente;
	}

	public int getId_operacao() {
		return id_operacao;
	}
	public void setId_operacao(int id_operacao) {
		this.id_operacao = id_operacao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
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
	public String getFaixa_km() {
		return faixa_km;
	}
	public void setFaixa_km(String faixa_km) {
		this.faixa_km = faixa_km;
	}
	
	@Override
	public String toString() {
		return "Mensagem [id_operacao=" + id_operacao + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", token=" + token + ", id_usuario=" + id_usuario + ", data=" + data + ", rodovia=" + rodovia
				+ ", km=" + km + ", tipo_incidente=" + tipo_incidente + ", faixa_km=" + faixa_km + "]";
	}
}
