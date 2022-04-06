import java.io.File;
import java.util.Scanner;

public class Trabalho1 {

  public static void main(String[] args)
    throws Exception {

 
    Scanner teclado = new Scanner(System.in);
    System.out.print("Nome do arquivo: ");
    String arquivo = teclado.next();
    String[] dicionario = new String[1000];
    for (int i = 0; i < dicionario.length; i ++){
        dicionario[i] = "";
    }


    dicionario = processarArquivo(dicionario, arquivo);

    for (int i = 0; i < dicionario.length; i ++){
        System.out.println(dicionario[i]);
    }

  }

  public static String[] processarArquivo(String[] dicionario, String arquivo) throws Exception {
    Scanner leitor = new Scanner(new File(arquivo));
    String[] linha;
    while (leitor.hasNextLine()) {
      linha = leitor.next().toLowerCase().split("[\\W]");
      dicionario = popular(dicionario, linha);
    }
    return dicionario;
  }

  public static boolean buscaBinaria(String[] dicionario, String word) {
    int i = 0;
    int f = dicionario.length - 1;
    int m;

    while (i <= f) {
      m = (i + f) / 2;

      if (dicionario[m].compareTo(word) == 0){ 
      return false; 
      }else if (dicionario[m].compareTo(word) < 0){ // esquerda
        i = m + 1; 
      }else if (dicionario[m].compareTo(word) > 0){
        f = m - 1; // x > v[m] - direita
      }
    }
    return true;
  }

  public static String[] popular(String[] dicionario, String[] linha) {
    int indice = 0;
    if (buscaBinaria(dicionario, linha[indice]) == true) {
      dicionario[indice] = linha[indice];
      for (int i = 1; i < dicionario.length; i++) {
          String aux = dicionario[i];
          int j = i - 1;
          while ((j >= 0) && dicionario[j].compareTo(aux) > 0) {
            dicionario[j+1] = dicionario[j];
            //  if (dicionario[j] == ""){
            //    dicionario[j] = linha;
            //  }
            j--;
          }
          dicionario[j + 1] = aux;
        }
    }

    return dicionario;
  }
}