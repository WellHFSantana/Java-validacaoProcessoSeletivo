package candidatura;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class processoSeletivo {
	public static void main(String[] args) {
		//analisarCandidato(1900.00);
		//analisarCandidato(2200.00);
		//analisarCandidato(2000.00);
		//selecaoCandidatos();
		//imprimirSelecionados();
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
		for (String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato realizado com sucesso.");
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu)
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
		else
			System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas " + tentativasRealizadas + " realizada.");
	}
	
	static boolean atender() {
		return new  Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
		System.out.println("Imprimindo a lista de candidatos  informando o indice do elemento");
		
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de número " + (indice+1) + " é " + candidatos[indice]);
		
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
		}
	}
	
	
	static void selecaoCandidatos() {
		//array com lista de candidatos
		String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.00;
		
		while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String  candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
			
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato" + candidato + " foi selecionado para a vaga.");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		
		double salarioBase = 2000.00;
		
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		}
		else if(salarioBase == salarioPretendido)
			System.out.println("Ligar para o candidato com contra proposta");
		
		else{ 
			System.out.println("Aguardando os demais candidatos");
		}
	}
}
