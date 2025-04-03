// Inteiro backPackPD(Inteiro N, Inteiro C, Tupla<Inteiro, Inteiro> itens)
//    N = número de produtos;
//    C = capacidade real da mochila
//    itens[N +1];   // (O índice 0 guarda null), Tupla com peso e valor
//    maxTab[N+1][C+1];

//    Inicialize com 0 toda a linha 0 e também a coluna 0;
//    para i = 1 até N
//       para j = 1 até C
//          se item itens[i].peso <= j // se o item cabe na mochila atual
//             maxTab[i][j] = Max(maxTab[i-1][j], 
//                                itens[i].valor + 
//                                  maxTab[i-1][j – itens[i].peso]);
//          senão
//             maxTab[i][j] = maxTab[i-1][j];

//    retorne maxTab[N][C] // valor máximo para uma mochila de capacidade C e 		         
//                         //que pode conter itens que vão do item 1 até o item N.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class knapsack {

    public static void main(String[] args) {
        ArrayList<item> itens = new ArrayList<>();
        item N = new item(0,0);
        item A = new item(12,4);
        item B = new item(2,2);
        item C = new item(1,1);
        item D = new item(4,10);
        item E = new item(1,2);
        itens.add(N);
        itens.add(A);
        itens.add(B);
        itens.add(C);
        itens.add(D);
        itens.add(E);

        int r = backpackPD(5, 15, itens);
        System.out.println(r);

        //Map<item> dicio = new HashMap<>();
    }

    public static int backpackPD(int N, int C, ArrayList<item> itens) {
        int[][] maxTab = new int[N + 1][C + 1];

        for (int i = 0; i <= C; i++) {
            maxTab[0][i] = 0;
        }
        for (int i = 0; i <= N; i++) {
            maxTab[i][0] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (itens.get(i).peso <= j) {
                    maxTab[i][j] = Math.max(maxTab[i-1][j],
                                            itens.get(i).valor + maxTab[i-1][j-itens.get(i).peso]);
                    if(itens.get(i).valor + maxTab[i-1][j-itens.get(i).peso] > maxTab[i-1][j]){

                    }
                }
                else{
                    maxTab[i][j] = maxTab[i-1][j];
                }
            }
        }

        return maxTab[N][C];
    }
}