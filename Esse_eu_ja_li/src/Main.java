import java.util.Scanner;
import java.util.Random;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static Sistema sis = new Sistema();
	private static Usuario user;
	
	
	
	public static Boolean logar() {
		
		System.out.print("Login:");
		String login = scan.nextLine();
		System.out.print("Senha:");
		String senha = scan.nextLine();
		
		user = sis.fazerLogin(login, senha);
		if(user != null) {
			System.out.println("Login efetuado!");
			return true;
		}
		
		else {
			System.out.println("Erro ao efetuar o login :( ");
			return false;
		}
		
		
	
	}
	
	
	public static void mostrarLivros() {
		System.out.println("Livros disponiveis:");
		System.out.println("---------------------------------------------------");
		System.out.println("id |     Titulo");
		System.out.println("---------------------------------------------------");
		sis.mostrarLivros();
		System.out.println("---------------------------------------------------");
	}
	
	
	
	
	
	public static int menu() { 
		System.out.println("1- Selecionar livro.");
		System.out.println("2- Perfil.");
		System.out.println("3- Ranking.");
		System.out.println("4- Sair.");
		System.out.print("Opcao:");
		int opcao = Integer.parseInt(scan.nextLine());
		return opcao;
	}
	
	
	public static void MostrarPerfil() {
		System.out.println("\n\n\n\n");
		System.out.println(user.detalhes());
		System.out.println("Ranking: "+sis.getRanking(user));
		System.out.println("\n\n");
		System.out.println("1- Voltar");
		scan.nextLine();
	}
	
	public static void MostrarRanking() {
		System.out.println("\n\n");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("                Ranking");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		sis.mostrarRanqueamento();
		System.out.println("-------------------------------------------");
		System.out.println("1- Voltar.");
		scan.nextLine();
		
	}
	
	public static void desmarcarLivro(Livro livro) {
		user.desmarcar(livro);
		System.out.println("Livro desmarcado!\n\n");
	}
	
	public static void MarcarComoLido(Livro livro) {
		//caso o livro ja esteja marcado como lido
		if(user.getLivrosLidos().contains(livro)) {
			int op;
			System.out.println("Livro selecionado ja esta marcado, deseja desmarca-lo?\n1- Sim\n2- Nao");
			System.out.print("opcao:");
			op = Integer.parseInt(scan.nextLine());
			
			if(op==1) {
				desmarcarLivro(livro);
			}
			else {
				System.out.println("\n\n");
			}
		}

		else {
			sis.marcarLivroComoLido(user, livro);
			System.out.println("Livro marcado!\n\n\n");
		}
	}
	
	
	//menu-> opcao == 1
	public static void SelecionarLivro() {
		System.out.print("Digite o id do livro:");
		int id = Integer.parseInt(scan.nextLine());
		Livro livro = sis.selecionarLivro(id);
		System.out.println("---------------------------------------------------");
		System.out.println(livro.detalhes());
		
		//imprime se o livro foi lido
		if(user.getLivrosLidos().contains(livro))
			System.out.println("Lido: Sim");
		else 
			System.out.println("Lido: Nao");
		
		System.out.println("\n");
	
		int opcao = 0;
		while(opcao!=1) {
			System.out.println("1- Voltar.");
			System.out.println("2- Marcar Como Lido.");
			System.out.println("3- Desmarcar.");
			System.out.print("Opcao:");
			opcao = Integer.parseInt(scan.nextLine());
			
			switch (opcao) {
			case 1: {
				System.out.println("\n\n");
				break;
			}
			case 2: {
				MarcarComoLido(livro);
				break;
			}
			
			case 3:{
				desmarcarLivro(livro);
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		//criar usuarios
		//Usuario nome_variavel = new Usuario("login", "nome", "senha", pontos);
		Usuario lucas = new Usuario("lucas", "Lucas", "patos");
		Usuario dany = new Usuario("dany", "Dany", "patos1");
		Usuario maria = new Usuario("maria", "Maria", "patos2");
		Usuario gabriel = new Usuario("gabriel", "Gabriel", "patos3");
		Usuario arthur = new Usuario("arthur", "Arthur", "patos4");
		Usuario brena = new Usuario("brena", "Brena", "patos5");
		Usuario lorenzo = new Usuario("lorenzo", "Lorenzo", "patos6");
		Usuario amanda = new Usuario("amanda", "Amanda", "patos7");
		Usuario carol = new Usuario("carol", "Carol", "patos8");
		Usuario melissa = new Usuario("melissa", "Melissa", "patos9");
		Usuario matheus = new Usuario("matheus", "Matheus", "patos10");
		
	
		sis.adicionarUsuario(lucas);
		sis.adicionarUsuario(dany);
		sis.adicionarUsuario(maria);
		sis.adicionarUsuario(gabriel);
		sis.adicionarUsuario(arthur);
		sis.adicionarUsuario(brena);
		sis.adicionarUsuario(lorenzo);
		sis.adicionarUsuario(amanda);
		sis.adicionarUsuario(carol);
		sis.adicionarUsuario(melissa);
		sis.adicionarUsuario(matheus);
		sis.atualizarRanking();
		
		//------------------------------------------------
		//criar livros
		Livro livro1 = new Livro(0, "1984", "George Orwell","Um classico da distopia, \"1984\" descreve um futuro totalitario em que o governo controla todos os aspectos da vida dos cidadaos.","Ficção distópica",300);
		Livro livro2 = new Livro(1, "Admirável Mundo Novo", "Aldous Huxley", "Uma distopia futurista onde a sociedade é rigidamente controlada através de engenharia genética, condicionamento psicológico e uma hierarquia imutável.", "Ficção distópica", 311);
		Livro livro3 = new Livro(2, "Jogos Vorazes", "Suzanne Collins", "Em uma nação distópica, Katniss Everdeen se oferece para substituir sua irmã mais nova nos Jogos Vorazes, uma competição mortal televisionada onde apenas um sobrevivente é permitido.", "Ficção distópica", 374);
		Livro livro4 = new Livro(3, "A Revolução dos Bichos", "George Orwell", "Uma sátira política que retrata uma fazenda onde os animais se rebelam contra seus donos humanos, apenas para acabar sob um regime tão opressor quanto o anterior.", "Ficção distópica", 112);
		Livro livro5 = new Livro(4, "Divergente", "Veronica Roth", "Em uma Chicago futurista, a sociedade é dividida em cinco facções que representam diferentes virtudes. Beatrice Prior descobre que é divergente, alguém que não se encaixa em uma única facção, e precisa lidar com as consequências dessa revelação.", "Ficção distópica", 512);
		Livro livro6 = new Livro(5, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Harry Potter descobre que é um bruxo e vai para a Escola de Magia e Bruxaria de Hogwarts, onde enfrenta aventuras mágicas e o retorno do tenebroso Lord Voldemort.", "Infantojuvenil", 309);
		Livro livro7 = new Livro(6, "Percy Jackson e o Ladrão de Raios", "Rick Riordan", "Percy Jackson descobre que é um semideus e embarca em uma missão para encontrar o raio perdido de Zeus, enfrentando monstros mitológicos e deuses ao longo do caminho.", "Infantojuvenil", 377);
		Livro livro8 = new Livro(7, "As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", "Quatro crianças descobrem um guarda-roupa mágico que as transporta para a terra de Nárnia, onde devem lutar ao lado do leão Aslan contra a terrível Feiticeira Branca.", "Infantojuvenil", 208);
		Livro livro9 = new Livro(8, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Um piloto perdido no deserto encontra um pequeno príncipe de outro planeta e aprende lições sobre amor, amizade e vida.", "Infantojuvenil", 96);
		Livro livro10 = new Livro(9, "Alice no País das Maravilhas", "Lewis Carroll", "Uma menina chamada Alice cai em um buraco de coelho e entra em um mundo mágico e surreal, onde encontra criaturas estranhas e vive aventuras inusitadas.", "Infantojuvenil", 288);
		Livro livro11 = new Livro(10, "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Frodo Bolseiro, um hobbit, recebe a missão de destruir um anel poderoso que pode trazer destruição ao mundo, acompanhado por uma sociedade de amigos e aliados.", "Fantasia", 423);
		Livro livro12 = new Livro(11, "Harry Potter e o Cálice de Fogo", "J.K. Rowling", "Harry Potter participa do Torneio Tribruxo entre as três maiores escolas de magia da Europa, enfrentando desafios mortais e descobrindo segredos sombrios.", "Fantasia", 592);
		Livro livro13 = new Livro(12, "Percy Jackson e o Ladrao de Raios","Rick Riordan"," Percy Jackson descobre que é um semideus e embarca em uma missão para encontrar o raio perdido de Zeus, enfrentando monstros mitológicos e deuses ao longo do caminho.","Fantasia",377);
		Livro livro14 = new Livro(13, "It: A coisa", "Stephen King", "Em Derry, uma pequena cidade no Maine, um grupo de crianças enfrenta um ser maligno que se alimenta dos medos de suas vítimas e retorna a cada 27 anos. Agora, adultos, eles devem confrontar seus traumas passados para derrotar a criatura de uma vez por todas.", "Ação", 1138);
		Livro livro15 = new Livro(14, "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", "Frodo Bolseiro, um hobbit, recebe a missão de destruir um anel poderoso que pode trazer destruição ao mundo, acompanhado por uma sociedade de amigos e aliados.", "Fantasia", 423);
		Livro livro16 = new Livro(15, "Admirável Mundo Novo", "Aldous Huxley", "Uma distopia futurista onde a sociedade é rigidamente controlada através de engenharia genética, condicionamento psicológico e uma hierarquia imutável.", "Ficção distópica", 311);
		Livro livro17 = new Livro(16, "O Ritual", "Adam Nevill", "Quatro amigos de faculdade se reúnem para uma caminhada nas florestas remotas da Suécia. Quando se perdem, descobrem uma antiga presença maligna que os caça, transformando a viagem em uma luta desesperada pela sobrevivência.", "Terror", 448);
		Livro livro18= new Livro(17, "As Crônicas de Nárnia: O Leão, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", "Quatro crianças descobrem um guarda-roupa mágico que as transporta para a terra de Nárnia, onde devem lutar ao lado do leão Aslan contra a terrível Feiticeira Branca.", "Infantojuvenil", 208);
		Livro livro19 = new Livro(18, "Moby Dick", "Herman Melville", "A obsessiva caçada do capitão Ahab pela baleia branca Moby Dick, que já o mutilou antes, e a jornada do navio Pequod pelos mares.", "Aventura", 635);
		Livro livro20 = new Livro(19, "O Conde de Monte Cristo", "Alexandre Dumas", "A história de Edmond Dantès, um jovem marinheiro injustamente preso, que escapa da prisão, enriquece misteriosamente e busca vingança contra aqueles que o traíram.", "Aventura", 1243);
		Livro livro21 = new Livro(20, "Harry Potter e o Cálice de Fogo", "J.K. Rowling", "Harry Potter participa do Torneio Tribruxo entre as três maiores escolas de magia da Europa, enfrentando desafios mortais e descobrindo segredos sombrios.", "Fantasia", 592);
		Livro livro22 = new Livro(21, "A Menina que Roubava Livros", "Markus Zusak", "Durante a Segunda Guerra Mundial, a jovem Liesel Meminger encontra consolo roubando livros e compartilhando-os com seus vizinhos e o judeu escondido em sua casa.", "Drama", 552);
		Livro livro23 = new Livro(22, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Harry Potter descobre que é um bruxo e vai para a Escola de Magia e Bruxaria de Hogwarts, onde enfrenta aventuras mágicas e o retorno do tenebroso Lord Voldemort.", "Fantasia", 309);
		Livro livro24 = new Livro(23, "Dom Quixote", "Miguel de Cervantes", "As aventuras de um fidalgo que, após ler muitos romances de cavalaria, decide se tornar um cavaleiro andante, acompanhado por seu fiel escudeiro, Sancho Pança.", "Clássico", 1072);
		Livro livro25 = new Livro(24, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Um piloto perdido no deserto encontra um pequeno príncipe de outro planeta e aprende lições sobre amor, amizade e vida.", "Fábula", 96);
		Livro livro26 = new Livro(25, "Os Miseráveis", "Victor Hugo", "A história de Jean Valjean, um ex-presidiário que busca redenção, e de outros personagens em meio à Revolução Francesa, explorando temas de justiça, amor e redenção.", "Clássico", 1463);
		Livro livro27 = new Livro(26, "Crime e Castigo", "Fiódor Dostoiévski", "A história de Raskólnikov, um ex-estudante que comete um assassinato e lida com as consequências psicológicas e morais de seus atos.", "Drama psicológico", 551);
		Livro livro28 = new Livro(27, "A Revolta de Atlas", "Ayn Rand", "Um épico filosófico que narra a luta de indivíduos criativos e empreendedores contra a opressão de um governo controlador que sufoca a inovação e a liberdade individual.", "Romance filosófico", 1168);
		Livro livro29 = new Livro(28, "O Nome do Vento", "Patrick Rothfuss", "A vida de Kvothe, um famoso músico e arcanista, contada por ele mesmo, desde sua infância como órfão até suas aventuras e desventuras na Universidade.", "Fantasia", 662);
		Livro livro30 = new Livro(29, "A Sangue Frio", "Truman Capote", "Um relato verdadeiro e perturbador do brutal assassinato de uma família no Kansas e das consequências do crime na pequena cidade onde ocorreu.", "Não-ficção", 352);
		Livro livro31 = new Livro(30, "Jogos Vorazes", "Suzanne Collins", "Em uma nação distópica, Katniss Everdeen se oferece para substituir sua irmã mais nova nos Jogos Vorazes, uma competição mortal televisionada onde apenas um sobrevivente é permitido.", "Ficção distópica", 374);
		Livro livro32 = new Livro(31, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Um piloto perdido no deserto encontra um pequeno príncipe de outro planeta e aprende lições sobre amor, amizade e vida.", "Romance", 96);
		Livro livro33 = new Livro(32, "Orgulho e Preconceito", "Jane Austen", "A história de Elizabeth Bennet enquanto ela lida com questões de moralidade, educação e casamento na sociedade aristocrática da Inglaterra do século XIX.", "Romance", 279);
		Livro livro34 = new Livro(33, "O Guia do Mochileiro das Galáxias", "Douglas Adams", "Arthur Dent é salvo por seu amigo Ford Prefect pouco antes de a Terra ser destruída para dar lugar a uma via expressa espacial. Juntos, eles embarcam em uma série de aventuras absurdas pela galáxia.", "Comédia", 224);
		Livro livro35 = new Livro(34, "O Iluminado", "Stephen King", "Jack Torrance, sua esposa e seu filho se mudam para o isolado Hotel Overlook, onde forças sobrenaturais começam a afetar Jack e ameaçar sua família.", "Terror", 659);
		Livro livro36 = new Livro(35, "It: A Coisa", "Stephen King", "Em Derry, uma pequena cidade no Maine, um grupo de crianças enfrenta um ser maligno que se alimenta dos medos de suas vítimas e retorna a cada 27 anos. Agora, adultos, eles devem confrontar seus traumas passados para derrotar a criatura de uma vez por todas.", "Terror", 1138);
		Livro livro37 = new Livro(36, "Cem Anos de Solidão", "Gabriel García Márquez", "A história da família Buendía ao longo de várias gerações em Macondo, uma cidade fictícia na América Latina, misturando realismo mágico com elementos históricos e políticos.", "Romance", 368);
		Livro livro38 = new Livro(37, "O Sol é para Todos", "Harper Lee", "A história de Scout Finch, uma menina que cresce no sul dos Estados Unidos durante a Grande Depressão, e sua jornada para entender a injustiça racial e a natureza humana.", "Romance", 364);
		Livro livro39 = new Livro(38, "O Guia do Mochileiro das Galáxias", "Douglas Adams", "Arthur Dent é salvo por seu amigo Ford Prefect pouco antes de a Terra ser destruída para dar lugar a uma via expressa espacial. Juntos, eles embarcam em uma série de aventuras absurdas pela galáxia.", "Comédia", 224);
		Livro livro40 = new Livro(39, "O Hobbit", "J.R.R. Tolkien", "Bilbo Bolseiro, um hobbit pacato, é arrastado em uma aventura épica por Gandalf, o mago, e um grupo de anões, em busca do tesouro guardado pelo dragão Smaug.", "Fantasia", 288);
		Livro livro41 = new Livro(40, "O Exorcista", "William Peter Blatty", "Uma jovem garota é possuída por uma entidade demoníaca, levando dois padres a realizarem um exorcismo para salvá-la de sua terrível condição.", "Terror", 368);
		Livro livro42 = new Livro(41, "De Volta para o Futuro", "George Gipe", "Um adolescente é acidentalmente enviado de volta no tempo para 1955, onde conhece seus futuros pais na escola e precisa garantir que eles se apaixonem para garantir sua própria existência no futuro.", "Comédia", 320);
		Livro livro43 = new Livro(42, "O Chamado de Cthulhu", "H.P. Lovecraft", "Um conto que introduz o mito de Cthulhu, uma entidade cósmica adormecida que espera despertar e trazer caos ao mundo, revelando segredos antigos e insondáveis para aqueles que o encontram.", "Terror", 224);
		Livro livro44 = new Livro(43, "O Morro dos Ventos Uivantes", "Emily Brontë", "A história de amor tumultuada entre Heathcliff e Catherine Earnshaw, e como sua paixão destrutiva reverbera através das gerações.", "Romance", 400);
		Livro livro45 = new Livro(44, "O Iluminado", "Stephen King", "Jack Torrance, sua esposa e seu filho se mudam para o isolado Hotel Overlook, onde forças sobrenaturais começam a afetar Jack e ameaçar sua família.", "Terror", 659);
		Livro livro46 = new Livro(45, "O Grande Gatsby", "F. Scott Fitzgerald", "A história de Jay Gatsby, um milionário excêntrico que vive em Long Island durante os loucos anos 1920, e sua busca pelo amor perdido.", "Romance", 200);

		// livro1: Ficção distópica
		// livro2: Ficção distópica
		// livro3: Ficção distópica
		// livro4: Ficção distópica
		// livro5: Ficção distópica
		// livro6: Infantojuvenil
		// livro7: Infantojuvenil
		// livro8: Infantojuvenil
		// livro9: Infantojuvenil
		// livro10: Infantojuvenil
		// livro11: Fantasia
		// livro12: Fantasia
		// livro13: Fantasia
		// livro14: Ação
		// livro15: Fantasia
		// livro16: Ficção distópica
		// livro17: Terror
		// livro18: Infantojuvenil
		// livro19: Aventura
		// livro20: Aventura
		// livro21: Fantasia
		// livro22: Drama
		// livro23: Fantasia
		// livro24: Clássico
		// livro25: Fábula
		// livro26: Clássico
		// livro27: Drama psicológico
		// livro28: Romance filosófico
		// livro29: Fantasia
		// livro30: Não-ficção
		// livro31: Ficção distópica
		// livro37: Romance  
		// livro38: Romance  
		// livro39: Comédia 
		// livro40: Fantasia 
		// livro41: Terror 
		// livro42: Comédia 
		// livro43: Terror 
		// livro44: Romance 
		// livro45: Terror 
		// livro46: Romance 
		
		
		sis.addLivro(livro1);
		sis.addLivro(livro2);
		sis.addLivro(livro3);
		sis.addLivro(livro4);
		sis.addLivro(livro5);
		sis.addLivro(livro6);
		sis.addLivro(livro7);
		sis.addLivro(livro8);
		sis.addLivro(livro9);
		sis.addLivro(livro10);
		sis.addLivro(livro11);
		sis.addLivro(livro12);
		sis.addLivro(livro13);
		sis.addLivro(livro14);
		sis.addLivro(livro15);
		sis.addLivro(livro16);
		sis.addLivro(livro17);
		sis.addLivro(livro18);
		sis.addLivro(livro19);
		sis.addLivro(livro20);
		sis.addLivro(livro21);
		sis.addLivro(livro22);
		sis.addLivro(livro23);
		sis.addLivro(livro24);
		sis.addLivro(livro25);
		sis.addLivro(livro26);
		sis.addLivro(livro27);
		sis.addLivro(livro28);
		sis.addLivro(livro29);
		sis.addLivro(livro30);
		sis.addLivro(livro31);
		sis.addLivro(livro32);
		sis.addLivro(livro33);
		sis.addLivro(livro34);
		sis.addLivro(livro35);
		sis.addLivro(livro36);
		sis.addLivro(livro37);
		sis.addLivro(livro38);
		sis.addLivro(livro39);
		sis.addLivro(livro40);
		sis.addLivro(livro41);
		sis.addLivro(livro42);
		sis.addLivro(livro43);
		sis.addLivro(livro44);
		sis.addLivro(livro45);
		sis.addLivro(livro46);
		
		
		//marca 5 livros aleatoriamente para cada usuarios
		for(int i = 0; i<sis.getUsuarios().size();i++) {
			Random random = new Random();
			Usuario u = sis.getUsuarios().get(i);
			for(int j = 0; j<5;j++) {
				int numAleatorio = random.nextInt(sis.getLivros().size());
				sis.marcarLivroComoLido(u, sis.getLivros().get(numAleatorio));
			}
			
		}
		
		
		//---------------------------------------------
		
		
		
		while(true) {
			
			
			if(logar()) {
			
				int opcao = 0;
				while(opcao!= 4) {
					mostrarLivros();
					opcao = menu();
					
					switch (opcao) {
						case 1: {//opcao para selecionar o livro
							SelecionarLivro();
							break;
						}
						
						case 2:{ //opcao para ver perfil
							MostrarPerfil();
							break;
						}
						
						case 3 : { //opcao mostrar ranqueamento
							MostrarRanking();
							break;
						}
						
						case 4: {//opcao para sair
							System.out.println("\n\n\n");
							break;
						}
						
						default:
							System.out.println("\nOpção inválida.\n");
							break;
					}		
				}
			}					
		}
	}

}
