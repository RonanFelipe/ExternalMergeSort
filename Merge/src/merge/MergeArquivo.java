package merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MergeArquivo {

    public static void preencheVetor(int vetor[], int tamanho){
        for (int i = 0; i < tamanho; i++){
            Random random = new Random();
            vetor[i] = random.nextInt(100000);//gerando numero de 0 a 1000000
        }
    }

    public static void mostraVetor(int vetor[]){
        for (int i = 0; i < vetor.length-1; i++)
            System.out.println(vetor[i]);//método para visualização do vetor
    }

    public static void criarArquivo(int vetor[]){   //método para salvar o vetor em arquivo txt
        File arquivo = new File("PrimeiroArquivo.txt"); //Criando arquivo txt
        try(FileWriter fw = new FileWriter(arquivo)){   //necessário try catch para pegar eventuais erros
            for (int i = 0; i < vetor.length; i++){
                fw.write(Integer.toString(vetor[i])+" ");   //escrevendo o vetor no arquivo
            }
            fw.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static int[] lerArquivo() {  //Método para ler arquivo
        int[] vetor = new int[10];  //sabe-se que o arquivo tem 10 inteiros (procurar melhor solução para esse tamanho)
        try {
            File f = new File("PrimeiroArquivo.txt");   //criando o arquivo
            Scanner scanner = new Scanner(f);   //scanner para ler cada valor separado por espaço no arquivo
            for (int i = 0; i < vetor.length; i++){
                vetor[i] = scanner.nextInt();   //enviando cada posição do arquivo separado por espaço para o vetor
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return vetor;   //retornando o vetor criado a partir do arquivo lido
    }
}
