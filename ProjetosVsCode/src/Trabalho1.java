import java.io.File;
import java.util.Scanner;

public class Trabalho1 {

  public static void main(String[] args)
    throws Exception {

 
    Scanner teclado = new Scanner(System.in);
    System.out.print("Nome do arquivo: ");
    String arquivo = teclado.next();
    String[] dicionario = new String[1000];
    for (int i = 0; i < dicionario.length - 1; i ++){
        dicionario[i] = "";
    }


    dicionario = processarArquivo(dicionario, arquivo);

    for (int i = 0; i < dicionario.length - 1; i ++){
        System.out.println(dicionario[i]);
    }

    //buscaBinaria(arquivo, armazenaPrimeiraPalavra);
  }

  public static String[] processarArquivo(String[] dicionario, String arquivo) throws Exception {
    Scanner leitor = new Scanner(new File(arquivo));
    String linha;
    while (leitor.hasNextLine()) {
      linha = leitor.nextLine();
      dicionario = popular(dicionario, arquivo);
    }
    return dicionario;
  }

  public static boolean buscaBinaria(String[] dicionario, String word) {
    int i = 0;
    int f = dicionario.length - 1;
    int m;

    while (i <= f) {
      m = (i + f) / 2;

      // if (i > f) {
      //   return false;
      // }

      if (dicionario[m].compareTo(word) == 0){ 
      return true; 
      }else if (word.compareTo(dicionario[m]) < 0){ // esquerda
        i = m + 1; 
      }else if (word.compareTo(dicionario[m]) > 0){
        f = m - 1; // x > v[m] - direita
      }
    }
    return false;
  }

  public static String[] popular(String[] dicionario, String arquivo) {

    for (int i = 1; i < dicionario.length; i++) {
      if (buscaBinaria(dicionario, dicionario[i]) == false) {
        int j = i;
        String x = dicionario[j];
        while ((j > 0) && x.compareTo(dicionario[j - 1]) < 0) {
          dicionario[j] = dicionario[j - 1];
          j--;
        }
        dicionario[j] = x;
      }
    }

    return dicionario;
  }
}
