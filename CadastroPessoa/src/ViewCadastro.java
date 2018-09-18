import java.util.Scanner;
import java.util.ArrayList;

public class ViewCadastro {
	
	private Scanner teclado;

	public ViewCadastro()
	{
		teclado = new Scanner(System.in);
	}

	public String mostraMenu() {
		
		System.out.println("=== Autor: Matheus Costa =============");
		System.out.println("======================================");
		System.out.println("====== MENU CADASTRO DE PESSOAS ======");
		System.out.println("============ 1 - Inserir =============");
		System.out.println("============ 2 - Listar ==============");
		System.out.println("============ 3 - Alterar =============");
		System.out.println("============ 4 - Pesquisar ===========");
		System.out.println("============ 5 - Excluir =============");
		System.out.println("============ 6 - Sair ================");
		System.out.println("======================================");
		System.out.println("Opção: ");
		return teclado.nextLine();
		
		
	}


	//Metodo inserir - @Matheus Costa
	public void Inserir(ArrayList<Pessoa> grupo) 
	{
		

		System.out.println("Inserir -");

		
		System.out.println("Nome: ");
		String nome = teclado.nextLine();

		
		System.out.println("Email: ");
		String email = teclado.nextLine(); 

		
		System.out.println("CPF: ");
		String cpf = teclado.nextLine(); 
		
		grupo.add(new Pessoa(nome,email,cpf));
		

	}

	
	//Metodo Listar, caso a lista estiver vazia, o mesmo dá opção de adicionar um cadastro ou sair do sistema - @Matheus Costa
	public void Listar(ArrayList<Pessoa> grupo) 
	{
		int pos = 0;
		int choose = 0;

		System.out.println("\nLISTA DE CADASTRADOS!");
		
		for (pos = 0; pos < grupo.size(); pos++)
		{

			System.out.println("ID: " + pos + " - " + grupo.get(pos).getNome() + "\n DADOS: " + grupo.get(pos).toString());
			System.out.println("\n");
		}
		if(grupo.isEmpty())
		{
			System.out.println("Lista vazia");
			
			System.out.println("\nDeseja adicionar um cadastro? Digite 1 para SIM ou 2 para NÃO: ");
			 choose = Integer.parseInt(teclado.nextLine());
			
			if (choose == 1) 
			{
				Inserir(grupo);
			}
			if (choose == 2) 
			{
				System.out.println("Encerrando Aplicação...");
				System.out.println("Aplicação encerrada!");
				System.exit(0);
			}
		}


	}

	
	//Metodo Alterar, entra em um opção de escolha especifica para alteração - (Nome, email, cpf) - @Matheus Costa
	public void Alterar(ArrayList<Pessoa> grupo) 
	{
		Listar(grupo);
		
		boolean continuar = true;
		int pos = 0;
		int choose = 0;
      do {
			System.out.println("Digite o registro para alteração: ");
		try {
			
			 pos = Integer.parseInt(teclado.nextLine());
			
			if(pos >= 0 && pos < grupo.size())
			{
				continuar = false;
			}
			else 
			{
				System.out.println("Digite um valor válido: ");
			}
			
		} catch (Exception e) {
			
			System.out.println("Valor digitado Invalido!!");
		}
		} while(continuar);
      
      

      System.out.println("\n Para alterar Nome - Digite 1 \n Para alterar email - Digite 2 \n Para alterar CPF - Digite 3 "); 
      System.out.println("\nEscolha qual campo voce deseja alterar: ");
		 choose = Integer.parseInt(teclado.nextLine());
		 
      do {
 
	  if (choose == 1)
	  {
	      System.out.println("Nome (" + grupo.get(pos).getNome() + "): ");
	      grupo.get(pos).setNome(teclado.nextLine());
	  }
	  else if (choose == 2) 
	  {
	      System.out.println("Email (" + grupo.get(pos).getEmail() + "): ");
	      grupo.get(pos).setEmail(teclado.nextLine());
	  }
	  else if (choose == 3) 
	  {
	      System.out.println("CPF (" + grupo.get(pos).getCpf() + "): ");
	      grupo.get(pos).setCpf(teclado.nextLine());
	  }

  	} while (continuar);

		Listar(grupo);
	}

	
	//Metodo Remover, remove pelo ID do Array - @Matheus Costa
	public void Remover(ArrayList<Pessoa> grupo) {
		boolean continuar = true;
		String confirmaExclu="" ;
		Listar(grupo);
	do {
		System.out.println("\nDigite o ID do cadastro a ser excluído: ");
		try {
		confirmaExclu= teclado.nextLine();
		
			grupo.remove(Integer.parseInt(confirmaExclu));
			System.out.println("Pessoa exluída da lista com sucesso!");	
			continuar = false;
		}catch(Exception e)
		{
			System.out.println("Id não existe!");
		}
	}while(continuar);
		
	}

	
	//Metodo Pesquisar, pesquisando pelo campo "Nome" - @Matheus Costa
	public void Pesquisar(ArrayList<Pessoa> grupo) 
	
	{
		boolean continuar = true;

		System.out.println("Utilize o campo nome para pesquisar uma pessoa no Cadastro!");

		do {
			System.out.println("\nDigite um nome :");
			
		try {
			
			String pesquisa = teclado.nextLine();
		
		for (int pos = 0; pos < grupo.size(); pos++) 
		{
			if (pesquisa.startsWith(grupo.get(pos).getNome())) 
			{
				System.out.println("ID: " + pos + " - " + grupo.get(pos).getNome() + "\n DADOS: " + grupo.get(pos).toString());
				continuar = false;
			}
			else if(pesquisa!= grupo.get(pos).getNome())
			{
				System.out.println("Digite um valor válido!");
			}
			
		}
		}catch (Exception e)
		{
			System.out.println("Usuário não cadastro!!");
		}
		}while(continuar);
	}

}