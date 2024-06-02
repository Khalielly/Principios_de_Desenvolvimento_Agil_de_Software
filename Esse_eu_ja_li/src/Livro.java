
public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private int numPaginas;
	private String estilo;
	private String sinopse;
	
	public Livro(int id,String titulo,String autor, String sinopse, String estilo, int numPaginas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopse = sinopse;
		this.estilo = estilo;
		this.numPaginas = numPaginas;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getNumPaginas() {
		return this.numPaginas;
	}
	
	public String getEstilo() {
		return this.estilo;
	}
	
	public String detalhes() {
		String detalhes = "titulo: "+this.titulo+
				"\n°Autor:  "+ this.autor +
				"\n°Sinopse: " + this.sinopse+
				"\n°Estilo: " + this.estilo+
				"\n°Numero de Paginas: " + this.numPaginas;
		return detalhes;
		
		
		//titulo
		//autor
		//sinopse
		//estilo
		//numpaginas
	}
	
}
