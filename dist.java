public class dist {
    static int countItr = 0;

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ba";
        int resposta = ED(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("RESP: "+resposta+" ; ITR: "+countItr);
        System.out.println();
        
    }

    public static int ED(String S, String T, int i, int j){
        //System.out.println("i: "+i+", j: "+j);
        countItr++;
        if(i==-1 && j==-1){
            //System.out.println("end");
            return 0;
        }
        if(i==-1){
            return T.length();
        }
        if(j==-1){
            return S.length();
        }
        if(S.charAt(i) == T.charAt(j)){
            //System.out.println("match; i: "+i+", j: "+j);
            return ED(S, T, i-1, j-1);
        }
        //System.out.println("rodou recursao SIR");
        int sub = ED(S, T, i-1, j-1) +1;
        int ins = ED(S, T, i, j-1) +1;
        int rem = ED(S, T, i-1, j) +1;
        if(sub <= ins && sub <= rem){
            //System.out.println("sub");
            return sub;            
        } 
        if(ins <= sub && ins <= rem){
            //System.out.println("ins");
            return ins;
        }
        if(rem <= sub && rem <= ins){
            //System.out.println("rem");
            return rem;
        }        
        return 0;
    }
}