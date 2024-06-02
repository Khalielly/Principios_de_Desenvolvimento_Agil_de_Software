import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Sistema {

	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<Usuario> ranqueamento = new ArrayList<>();
	
	public Sistema() {
		
	}
	
	public Usuario fazerLogin(String login, String senha) {
		
		
		for(int i = 0; i<usuarios.size();i++) {
			if(usuarios.get(i).getLogin().compareTo(login)== 0 && usuarios.get(i).getSenha().compareTo(senha)==0) {
				return usuarios.get(i);
			}
		}
		
		return null;
		
	}
	
	public void atualizarRanking() {
		
		this.ranqueamento.sort(new Comparator<Usuario>() {
			public int compare(Usuario a, Usuario b) {
				return Integer.compare(b.getPontos(), a.getPontos());
			}
		
		});
		
	}
	
	public ArrayList<Livro> getLivros(){
		return this.livros;
	}
	
	
	public Boolean marcarLivroComoLido(Usuario usuario,Livro livro) {
	    //se o usuario existir no sistema, marcamos o livro como lido
		if(usuarios.contains(usuario)) {
			usuario.marcarLivroComoLido(livro);
			
			//atualizar o ranking
			this.atualizarRanking();
			return true;
		}
		
		//caso o usuario nao exista no sistema
		else {
			return false;
		}
	
	}
	
	
	public void mostrarRanqueamento() {
		for(int i = 0; i<this.ranqueamento.size();i++) {
			System.out.println(i+1+"° - "+this.ranqueamento.get(i).getNome() + "  Pontuacao:"+this.ranqueamento.get(i).getPontos());
		}
	}
	
	public Livro selecionarLivro(int id) {
		return this.livros.get(id);
	}
	
	public void mostrarLivros() {
		
		for(int i = 0; i<this.livros.size();i++) {
			System.out.println(i + "  |" + livros.get(i).getTitulo());
		}
	}
	
	public void adicionarUsuario(Usuario a) {
		usuarios.add(a);
		this.ranqueamento.add(a);
		
	}
	
	public void addLivro(Livro livro) {
		livros.add(livro);
	}
	
	public int getRanking(Usuario a) {
		this.atualizarRanking();
		return this.ranqueamento.indexOf(a)+1;
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
}
