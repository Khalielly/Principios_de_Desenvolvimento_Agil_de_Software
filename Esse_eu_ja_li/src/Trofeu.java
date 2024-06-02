
public class Trofeu {
	
	private int idTrofeu;
	private String estilo;
	
	
	public Trofeu(int id, String estilo) {
		this.idTrofeu = id;
		this.estilo = estilo;
	
	}
	
	public int getIdTrofeu() {
		return this.idTrofeu;
	}
	
	public String getDescricao() {
		return "Leitor de " + this.estilo;	
	}
	
	public String getEstilo() {
		return this.estilo;
	}
	
}
