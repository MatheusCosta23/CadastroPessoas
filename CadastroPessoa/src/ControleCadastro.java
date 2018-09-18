//Trabalho - Matheus Costa
import java.util.ArrayList;



public class ControleCadastro 
{

	private ViewCadastro viewCadastro;
	ArrayList<Pessoa> grupo;

	
	public ControleCadastro()
	{
		viewCadastro  = new ViewCadastro();
		grupo = new ArrayList<>();
		trataMenu();
	}
	
	private void trataMenu()
	{
		Boolean continuar = true;
		do {
			
			String opc = viewCadastro.mostraMenu();

			
		switch (opc) 
		{
		    case "1":
		    	viewCadastro.Inserir(grupo);
			    break;
			case "2":
				viewCadastro.Listar(grupo);
				break;
			case "3":
				viewCadastro.Alterar(grupo);
				break;
			case "4":
				viewCadastro.Pesquisar(grupo);
				break;
			case "5":
				viewCadastro.Remover(grupo);
				break;
			case "6":
				System.out.println("Encerrando aplicação.....");
				System.out.println("Aplicação Encerrada!");
				continuar = false;
				break;
		default:
			System.out.println("Opção Invalida");
			break;
		}
		
		} while (continuar);
	}
}
