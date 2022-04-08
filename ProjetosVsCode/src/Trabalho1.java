import java.io.File;
import java.util.Scanner;

/*
Entrega do Trabalho 1-Algoritmos e Programação II
Nós,

Elton de Freitas Ribeiro
Keity Raione Cristovam Pires

declaramos que
todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

public class Trabalho1 {

  public static void main(String[] args)
    throws Exception {

    Scanner entrada = new Scanner(System.in);
    String arquivo = "arquivo.txt";
    String[] dicionarioOrdenado = new String[1000];

    for (int i = 0; i < dicionarioOrdenado.length; i ++){
        dicionarioOrdenado[i] = "";
    }

    dicionarioOrdenado = processarArquivo(dicionarioOrdenado, arquivo);


    System.out.println("total de palavras diferentes no dicionario = " + contarPalavrasEImprimir(dicionarioOrdenado));
    
  }

  //Pega as palavras do arquivo informado
  public static String[] processarArquivo(String[] dicionarioOrdenado, String arquivo) throws Exception {
    
    Scanner entrada = new Scanner(new File(arquivo));
    String[] palavra;
    while (entrada.hasNextLine()) {
      int i = 0;
      palavra = entrada.next().toLowerCase().split("[\\W]");
      popularDicionario(dicionarioOrdenado, palavra[i]);
    }
    return dicionarioOrdenado;
  }

  //Verifica se a palavra já consta no vetor
  public static boolean buscaBinaria(String[] dicionarioOrdenado, String palavra) {
    int i = 0;
    int f = dicionarioOrdenado.length - 1;
    int m;
    
    while (i <= f) {
      m = (i + f) / 2;

      if (dicionarioOrdenado[m].compareTo(palavra) == 0){ 
      return false; 
      }else if (dicionarioOrdenado[m].compareTo(palavra) < 0){ // esquerda
        i = m + 1; 
      }else if (dicionarioOrdenado[m].compareTo(palavra) > 0){
        f = m - 1; // x > v[m] - direita
      }
    }
    return true;
  }

  //Insere a palavra no vetor de forma ordenada
  public static String[] popularDicionario(String[] dicionarioOrdenado, String palavra) {
    int indice = 0;
  
    if (buscaBinaria(dicionarioOrdenado, palavra) == true) {
      dicionarioOrdenado[indice] = palavra;
      for (int i = 1; i < dicionarioOrdenado.length; i++) {

          String aux = dicionarioOrdenado[i];
          int j = i - 1;
          while ((j >= 0) && dicionarioOrdenado[j].compareTo(aux) > 0) {
            dicionarioOrdenado[j+1] = dicionarioOrdenado[j];
            j--;
          } 
          dicionarioOrdenado[j + 1] = aux;
        }
        
    }
    return dicionarioOrdenado;
  }

  //Conta quantas palavras possui no vetor e imprime na tela
  public static int contarPalavrasEImprimir(String[] dicionarioOrdenado){
    int count = 1;

    for (int i = 0; i < dicionarioOrdenado.length -1; i++){
      if (dicionarioOrdenado[i] != ""){
        System.out.println(dicionarioOrdenado[i]);
        count += 1;
      }
    }
    return count;
  }
}