import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
	
	private String login; // em vez de id, o usuario vai ter um login
	private String nome;
	private String senha;
	private int pontos;
	private ArrayList<Trofeu> trofeus = new ArrayList<>();
	private ArrayList<Livro> livrosLidos = new ArrayList<>();
	private Map<String,Integer> generosLidos = new HashMap<>();
	
	
	public Usuario(String login, String nome, String senha) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.pontos = 0;
		
	}
	
	public Usuario(String login, String nome, String senha, int pontos) {
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.pontos = pontos;
	}
	
	public Boolean marcarLivroComoLido(Livro livro) {
		
		if(this.livrosLidos.contains(livro)) {
			return false; // livro ja esta marcado
		}

		livrosLidos.add(livro);
		
		//atualiza o dicionario de generos lidos, os trofeus e os pontos
		this.atualizarGenerosLidos();
		return true;

	}
	
	
	private void atualizarGenerosLidos() {
		
		generosLidos.clear();
        trofeus.clear();
        this.pontos = 0;

        for (Livro livro : livrosLidos) {
            String estilo = livro.getEstilo();
            int count = generosLidos.getOrDefault(estilo, 0) + 1;
            generosLidos.put(estilo, count);
            
            //li o livro, ganhei 1 ponto
            this.pontos++;
            
          //+1 ponto a cada 100 paginas lidas
    		this.pontos += (int)livro.getNumPaginas()/100;
            
            // Atualiza os troféus
            if (count >= 5 && !trofeuJaAdicionado(estilo)) {
                Trofeu trofeu = new Trofeu(0, estilo);
                trofeus.add(trofeu);
            }
        }
	
	}
	
	
	public Boolean desmarcar(Livro livro) {
		
		if(!this.livrosLidos.contains(livro)) {
			return false;
		}
		
		this.livrosLidos.remove(livro);
		this.atualizarGenerosLidos();
		return true;
	}
	
	public int getPontos() {
		return this.pontos;
	}
	
	public void addTrofeu(Trofeu trofeu) {
		this.trofeus.add(trofeu);
	}
	
	public ArrayList<Trofeu> getTrofeus(){
		return this.trofeus;
	}
	
	public String getTrofeusDescricao() {
		String descricao = "";
		
		for(int i = 0; i<this.trofeus.size();i++) {
			if(i==this.trofeus.size()-1) {
				descricao = descricao + trofeus.get(i).getDescricao();
				break;
			}
			descricao = descricao + trofeus.get(i).getDescricao()+", ";
		}
		
		return descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public ArrayList<Livro> getLivrosLidos() {
		return this.livrosLidos;
	}
	
	public String detalhes() {
		return "nome: "+ nome+
				"\nTrofeus: " + this.getTrofeusDescricao()+
				"\nPontos: "+this.getPontos();
				//ranking :
				
	}
	
	private boolean trofeuJaAdicionado(String estilo) {
	        for (Trofeu trofeu : trofeus) {
	            if (trofeu.getEstilo().equals(estilo)) {
	                return true;
	            }
	        }
	        return false;
	    }
	
	
}
