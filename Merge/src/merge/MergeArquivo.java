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
        try(FileWriter fw = new FileWriter(arquivo)){   //necessário try catch para pegar eventuais erros ao escrever no arquivo
            for (int i = 0; i < vetor.length; i++){
                fw.write(Integer.toString(vetor[i])+" ");   //escrevendo o vetor no arquivo
            }
            fw.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static int[] lerArquivo(int qtValores) {  //Método para ler arquivo
        int[] vetor = new int[qtValores];  //sabe-se que o arquivo tem 100 inteiros (procurar melhor solução para esse tamanho)
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
/*

    public static void dividirArquivo(int[] vetor){ //método para dividir vetor em 10 arquivos
        try {
            int z = 1;  //cade vez que há um break, o indice j volta a zero, para evitar isso essa variável é incrementada de 10 em 10 sendo igualada ao indice j
            for (int i = 0; i < 10; i++, z+=10){
                File arquivo = new File("arquivo"+i+".txt");    //cada novo arquivo será chamado de arquivo0.txt, sendo o número a variável i concatenada com o nome do arquivo
                FileWriter fw = new FileWriter(arquivo);
                for (int j = z; j < vetor.length; j++){ //j sendo igualado a z para não ser zerado quando acontecer um break
                    fw.write(Integer.toString(vetor[j-1])+" "); //j-1 pois j está com idice 1, pois z começa com 1
                    if (j!=0 && j%10==0){   //se j for diferente de zero e divisivel por 10 break e comece um novo arquivo
                        break;
                    }
                }
                fw.flush();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
*/

    public static int callMiniFiles(int[] vetor){
        int tamanhoVetor = vetor.length;
        int divisao = tamanhoVetor/10;
        for (int cont = 0; cont < divisao; cont++){
            miniFiles(vetor, 10, cont);
        }
        return divisao;
    }

    public static void miniFiles(int[] vetor, int fixedValor, int cont){
        try {
            File arquivo = new File("arquivo"+cont+".txt");
            FileWriter fw = new FileWriter(arquivo);
            for (int i = 0; i < 10; i++){
                fw.write(Integer.toString(vetor[cont*fixedValor+i])+" ");
            }
            fw.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void lerMiniArquivos(int qtArquivos){   //método para ler cada mini arquivo e ordena-los com quicksort
        int[] vetor = new int[10];  //tamanho de cada mini arquivo(cada mini arquivo tem 10 numeros)
        try {
            for (int i = 0; i < qtArquivos; i++){
                File f = new File("arquivo"+i+".txt");  //abrindo mini arquivo, sequencia de 0 a 9
                Scanner scanner = new Scanner(f);
                for (int j = 0; j < vetor.length; j++){
                    vetor[j] = scanner.nextInt();   //cada mini arquivo é enviado ao vetor
                    //if (i == 9 && j == 8)   //if usado para pular o erro do arquivo9 que contém somente 9 números
                        //break;
                }
                Quicksort.quicksort(vetor, 0, vetor.length-1);  //quicksort para ordenar o vetor
                try(FileWriter fw = new FileWriter(f)) {
                    for (int k = 0; k < vetor.length; k++){
                        fw.write(Integer.toString(vetor[k])+" ");   //salvando o vetor ordenado no mini arquivo novamente
                    }   //nesse momento temos todos os mini arquivos ordenados, faltando somente da o merge para ordenar novamente
                    fw.flush();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    /*
    public static void unirArquivos() throws FileNotFoundException, IOException{
        int qtdArquivos = 10;
        int tamMini = 10;
        for (int i = 1; i < qtdArquivos; i++){
            File arquivo = new File("arquivo0.txt");
            File mini = new File("arquivo"+i+".txt");
            Scanner scanner = new Scanner(mini);
            Scanner scannerArquivo = new Scanner(arquivo);
            int tamArquivo0 = (i*10)+10;
            int[] vetArquivo = new int[tamArquivo0];
            int[] vet = new int[tamMini];
            for (int j = 0; j < tamMini; j++){
                vet[j] = scanner.nextInt();
            }
            for (int k = 0; k < tamArquivo0-10; k++){
                vetArquivo[k] = scannerArquivo.nextInt();
            }
            for (int l = 0; l < tamMini; l++){
                int posInsert = (vetArquivo.length-1)-l;
                vetArquivo[posInsert] = vet[l];
            }
            scanner.close();
            scannerArquivo.close();

            Quicksort.quicksort(vetArquivo, 0, vetArquivo.length-1);
            try(FileWriter fw = new FileWriter("arquivo0.txt")) {
                for (int m = 0; m < vetArquivo.length; m++){
                    fw.write(Integer.toString(vetArquivo[m])+" ");
                }
                fw.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
            System.out.println();
        }
    }
    */

    public static void callMergeFiles(int quantidadeArquivos){
        int qtArquivos = quantidadeArquivos;
        int tamArquivo = 10;
        do {
            tamArquivo *= 2;
            if (tamArquivo > quantidadeArquivos*10)
                tamArquivo = qtArquivos*10;
            mergeFiles(qtArquivos, tamArquivo);
            qtArquivos /= 2;
        } while (qtArquivos != 1);
    }

    public static void mergeFiles(int qtArquivos, int tamArquivo){//HARDEST ONE
        int nomeador = 0;
        try {
            for (int i = 0; i < qtArquivos; i+=2){
                int[] vetAux0 = new int[tamArquivo];
                int[] vetAux1 = new int[tamArquivo/2];
                int[] vetAux2 = new int[tamArquivo/2];
                File arquivoImpar = new File("arquivo"+i+".txt");
                if (i + 1 != qtArquivos){
                    File arquivoPar = new File("arquivo"+(i+1)+".txt");
                    Scanner scannerPar = new Scanner(arquivoPar);
                    for (int k = 0; k < vetAux2.length; k++){
                        vetAux2[k] = scannerPar.nextInt();
                    }
                    scannerPar.close();
                }
                Scanner scannerImpar = new Scanner(arquivoImpar);
                for (int j= 0; j < vetAux1.length; j++){
                    vetAux1[j] = scannerImpar.nextInt();
                }
                for (int l = 0; l < vetAux0.length/2; l++){
                    vetAux0[l] = vetAux1[l];
                    int posInsert = (vetAux0.length-1)-l;
                    vetAux0[posInsert] = vetAux2[l];
                }
                scannerImpar.close();
                Quicksort.quicksort(vetAux0, 0, vetAux0.length-1);
                try (FileWriter fw = new FileWriter("arquivo"+nomeador+".txt")){
                    for (int m = 0; m < vetAux0.length; m++){
                        fw.write(Integer.toString(vetAux0[m])+" ");
                    }
                    fw.flush();
                    nomeador++;
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }


}
