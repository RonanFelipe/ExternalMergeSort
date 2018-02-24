package merge;

import java.util.Arrays;

public class MainAppMerge {
    public static void main(String[] args){
        int[] vetor = new int[10]; //Criando vetor de tamanho 1000 (Pode ser qualquer tamanho)
        MergeArquivo.preencheVetor(vetor, vetor.length);//Inserindo valores randomicos no vetor
        MergeArquivo.mostraVetor(vetor);//mostrando vetor
        MergeArquivo.criarArquivo(vetor);//criando arquivo com o Vetor criado
        int[] resultVetor = MergeArquivo.lerArquivo();//lendo arquivo e inserindo dados em um novo vetor
        System.out.println("Novo Vetor, criado a partir do arquivo lido");
        MergeArquivo.mostraVetor(resultVetor);//mostrando novo Vetor que foi criado a partir do arquivo lido
        /*
        Próximos passos (Podemos discutir se realmente será adotado a estratégia abaixo)
            - Enviar vetor para arquivo -------------------------> (done)
            - Ler o arquivo criado ------------------------------> (done)
            - Dividir o arquivo criado em vários outros menores
            (definir quantos valores vão ficar em cada arquivo)
            - Ordenar cada um dos "mini" arquivos (talvez possa usar quicksort aqui)
            - intercalar os "mini" arquivos ordenando em um único arquivo (mergeSort)
            - salvar o novo arquivo que está completamente ordenado
         */
    }
}
