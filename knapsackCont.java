import java.util.ArrayList;

public class knapsackCont {

    static int countIter = 0;
    static int countInstr = 0;

    public static void main(String[] args) {
        ArrayList<item> itens = new ArrayList<>();
        item N = new item(0, 0);
        item A = new item(12, 4);
        item B = new item(2, 2);
        item C = new item(1, 1);
        item D = new item(4, 10);
        item E = new item(1, 2);
        itens.add(N);
        itens.add(A);
        itens.add(B);
        itens.add(C);
        itens.add(D);
        itens.add(E);

        int r = backpackPD(5, 15, itens);
        System.out.println("Resultado: " + r);
        System.out.println("Iterações: " + countIter);
        System.out.println("Instruções: " + countInstr);
    }

    public static int backpackPD(int N, int C, ArrayList<item> itens) {
        int[][] maxTab = new int[N + 1][C + 1];
        countInstr++;

        for (int i = 0; i <= C; i++) {
            countIter++;
            maxTab[0][i] = 0;
            countInstr++;
        }

        for (int i = 0; i <= N; i++) {
            countIter++;
            maxTab[i][0] = 0;
            countInstr++;
        }

        for (int i = 1; i <= N; i++) {
            countIter++;
            for (int j = 1; j <= C; j++) {
                countIter++;
                countInstr++;

                if (itens.get(i).peso <= j) {
                    countInstr += 5;
                    int valor1 = maxTab[i - 1][j];
                    int valor2 = itens.get(i).valor + maxTab[i - 1][j - itens.get(i).peso];
                    maxTab[i][j] = Math.max(valor1, valor2);
                    countInstr++;
                    if (valor2 > valor1) {
                        countInstr++;
                    }
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                    countInstr++;
                }
            }
        }

        countInstr++;
        return maxTab[N][C];
    }
}

