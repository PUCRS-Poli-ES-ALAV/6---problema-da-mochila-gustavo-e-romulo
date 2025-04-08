import java.util.ArrayList;

/**
 * knapsackLimitado
 */
public class knapsackLimitado {

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
        int capacidade = 15;
        int resultado = backpack(itens, capacidade, 0);
        System.out.println(resultado);

        
    }
    public static int backpack(ArrayList<item> ar, int cap, int valor){
        //ArrayList<item> restante = new ArrayList<>();
        if(ar.isEmpty()){
            return valor;
        }        
        for (item i : ar) {
            ArrayList<item> aux = new ArrayList<>();
            for (item item : ar) {
                aux.add(item);
            }
            aux.remove(i);
            if(i.peso>cap){
                return valor;
            }
                int z = backpack(aux, cap-i.peso, valor+i.valor);
                if(z > valor){
                    System.out.println("adicionou item com peso "+i.peso+" e valor "+i.valor);
                    return z;                    
                }
                else{
                    return valor;
                }
        }
            return valor;
    }
    public static int backpackLim(ArrayList<item> itens,int C){
        
        return 0;
    }
}