import java.util.Random;
import java.util.Scanner;

public class Lista02 {

	// Busca Sequencial:
	// Far� a busca no vetor come�ando pelo Indice 0
	public static int buscaSeq(int[] v, int seek) {

		int contador = 0;
		long tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < v.length; i++) {
			contador++;
			if (v[i] == seek) {
				return i; // valor encontrado, retorna o �ndice

			}

		}
		System.out.println("Qnt de testes realizados em Busca Sequencial: " + contador);
		long tempoFinal = System.currentTimeMillis();

		System.out.printf("em %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		return -1; // valor n�o encontrado retorna -1

	}

	// Busca bin�ria
	// Primeiro far� a organiza��o de vetor e depois ir� localizar o �ndice
	public static int Binaria(int[] v, int seek) {

		int n = v.length;
		int aux = 0;
		int contador = 0;
		long tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < n - 1; i++) {
			contador++;
			for (int j = i + 1; j < n; j++) {
				if (v[i] > v[j]) {
					aux = v[j];
					v[j] = v[i];
					v[i] = aux;
				}
			}
		}

		int meio;
		int inicio = 0;
		int fim = v.length - 1;
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (seek == v[meio])
				return meio; // Valor encontrado, retorna o indice
			if (seek < v[meio])
				fim = meio - 1;
			else
				inicio = meio + 1;
		}
		System.out.println("Qnt de testes realizados em Busca Bin�ria: " + contador);

		long tempoFinal = System.currentTimeMillis();

		System.out.printf("em %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		return -1; // valor n�o encontrado retorna -1

	}

	public static void main(String[] args) {
		int v[] = new int[100000]; // tamanho do vetor
		Random aleatorio = new Random();
		Scanner seek = new Scanner(System.in);
		System.out.println("Digite o numero a ser encontrado no vetor:");
		int valor = seek.nextInt(); // Variavel que armazena o valor digitado

		for (int i = 0; i < v.length; i++) { // Repeti��o para preencher o vetor com numeros aleat�rios
			v[i] = aleatorio.nextInt(1000);
		}

		// Sa�da de Dados busca Sequencial
		System.out.println("N�mero encontrado na BuscaSequencial no �ndice = " + buscaSeq(v, valor));

		// Sa�da de Dados busca Bin�ria
		System.out.println("N�mero encontrado na BuscaBin�ria no �ndice = " + Binaria(v, valor));

		seek.close();

	}

}
