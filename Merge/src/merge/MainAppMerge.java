package merge;

public class MainAppMerge {
    public static void main(String[] args){
        int[] vetor = new int[1000]; //Criando vetor de tamanho 1000 (Pode ser qualquer tamanho)
        MergeArquivo.preencheVetor(vetor, vetor.length);//Inserindo valores randomicos no vetor
        MergeArquivo.mostraVetor(vetor);//mostrando vetor
        /*
        Próximos passos
            - Enviar vetor para arquivo
            - Ler o arquivo criado
            - Dividir o arquivo criado em vários outros menores
            (definir quantos valores vão ficar em cada arquivo)
            - Ordenar cada um dos "mini" arquivos (talvez possa usar quicksort aqui)
            - intercalar os "mini" arquivos ordenando em um único arquivo (mergeSort)
            - salvar o novo arquivo que está completamente ordenado
         */
    }
}
