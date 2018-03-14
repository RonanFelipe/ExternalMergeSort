package merge;


import java.io.IOException;


public class MainAppMerge {
    public static void main(String[] args) throws IOException {
        int qtValores = 100;
        int[] vetor = new int[qtValores]; //Criando vetor de tamanho 1000 (Pode ser qualquer tamanho multiplo de 100)
        MergeArquivo.preencheVetor(vetor, vetor.length);//Inserindo valores randomicos no vetor
        MergeArquivo.criarArquivo(vetor);//criando arquivo com o Vetor criado
        int[] resultVetor = MergeArquivo.lerArquivo(qtValores);//lendo arquivo e inserindo dados em um novo vetor
        int qtArquivos = MergeArquivo.callMiniFiles(resultVetor);
        MergeArquivo.lerMiniArquivos(qtArquivos);//ordenando os mini arquivos com quicksort
        MergeArquivo.callMergeFiles(qtArquivos);
        System.out.println("Executado com sucesso, o Arquivo0.txt está ordenado contendo os dados de todos os mini arquivos");
        /*
        Próximos passos (Podemos discutir se realmente será adotado a estratégia abaixo)
            - Criar vetor, preenchendo com números aleatórios -------------------------> (done)
            - Enviar vetor para arquivo -----------------------------------------------> (done)
            - Ler o arquivo criado ----------------------------------------------------> (done)
            - Criar um vetor a partir do arquivo lido ---------------------------------> (done)
            - Dividir o arquivo criado em vários outros menores
            (definir quantos valores vão ficar em cada arquivo)------------------------> (done)
            - Ordenar cada um dos "mini" arquivos (talvez possa usar quicksort aqui)---> (done)
            - intercalar os "mini" arquivos ordenando em um único arquivo (mergeSort)--> (done)
            - salvar o novo arquivo que está completamente ordenado--------------------> (done)
         */
        /*
            - Atualmente o algoritmo só aceita o tamanho de vetor 100 (FIXED)
            - Necessário realizar alterações para aceitar qualquer valor N como tamanho do vetor (FIXED)
        */
    }
}
