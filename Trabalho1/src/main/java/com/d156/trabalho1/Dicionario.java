
package com.d156.trabalho1;

/*
Entrega do Trabalho 1-Algoritmos e Programação II

Nós,

Elton de Freitas Ribeiro
Keity Raione Cristovam Pires

declaramos que todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

import java.io.File;
import java.util.Scanner;


public class Dicionario {
    
public static void main(String[] args) throws Exception {
   
   Scanner entrada = new Scanner(System.in); 
   System.out.print("Nome do arquivo: ");
   String arquivo = entrada.nextLine();
   dicionario(arquivo);

}
  

    public static String[] dicionario (String arquivo) throws Exception{
        
       String[] vetorDicionario = new String[1000];
       
       Scanner leitor = new Scanner(new File(arquivo));
           
       String armazenamentoPalavra;
       
           
            while (leitor.hasNextLine()){
                
                armazenamentoPalavra = leitor.next();
                vetorDicionario[0] = "Alou";
                String armazenamentoTemporario;
                
                
                for (int i = 0; i < vetorDicionario.length - 1; i++){
            
                    if (vetorDicionario[i] == null){
                        vetorDicionario[i] = armazenamentoPalavra;
                    }
                    
                    if (vetorDicionario[i].compareTo(armazenamentoPalavra) != 0){
                        
                        if(vetorDicionario[i].compareTo(armazenamentoPalavra) > 0){
                            armazenamentoTemporario = vetorDicionario[i];
                            vetorDicionario[i] = armazenamentoPalavra;
                            vetorDicionario[i + 1] = armazenamentoTemporario;
                            
                        }
                                               
                        vetorDicionario[i + 1] = armazenamentoPalavra;
                        
                    }
               
                    for (i = 0; i < 5; i++){
                        System.out.println(vetorDicionario[i]); 
                    }
                
                }
                   
            }
        
      
        
       return vetorDicionario;
    }

}



