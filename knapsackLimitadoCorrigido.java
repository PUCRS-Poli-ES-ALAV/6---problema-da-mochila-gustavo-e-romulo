import java.util.ArrayList;

public class knapsackLimitadoCorrigido {

    static int countIter = 0;
    static int countInstr = 0;

    public static void main(String[] args) {
        ArrayList<item> itens = new ArrayList<>();
        itens.add(new item(0, 0));
        itens.add(new item(12, 4));
        itens.add(new item(2, 2));
        itens.add(new item(1, 1));
        itens.add(new item(4, 10));
        itens.add(new item(1, 2));

        int capacidade = 15;
        int resultado = backpack(itens, capacidade, 0);
        System.out.println("Melhor valor possível: " + resultado);
        System.out.println("Iterações: " + countIter);
        System.out.println("Instruções: " + countInstr);
    }

    public static int backpack(ArrayList<item> ar, int cap, int valor) {
        countInstr++;
        if (ar.isEmpty()) {
            countInstr++;
            return valor;
        }

        int melhorValor = valor;
        countInstr++;

        for (int i = 0; i < ar.size(); i++) {
            countIter++;
            countInstr += 2;
            item atual = ar.get(i);
            countInstr++;

            if (atual.peso <= cap) {
                countInstr++;
                ArrayList<item> restante = new ArrayList<>(ar);
                countInstr++;
                restante.remove(i);
                countInstr++;
                int valorComItem = backpack(restante, cap - atual.peso, valor + atual.valor);
                countInstr += 3;
                melhorValor = Math.max(melhorValor, valorComItem);
                countInstr++;
            } else {
                countInstr++;
                ArrayList<item> restante = new ArrayList<>(ar);
                countInstr++;
                restante.remove(i);
                countInstr++;
                int valorSemItem = backpack(restante, cap, valor);
                countInstr++;
                melhorValor = Math.max(melhorValor, valorSemItem);
                countInstr++;
            }
        }

        countInstr++;
        return melhorValor;
    }
}
