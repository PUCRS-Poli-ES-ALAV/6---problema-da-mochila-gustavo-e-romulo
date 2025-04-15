public class dist {
    static int countItr = 0;
    static int countInstr = 0;

    public static void main(String[] args) {
        String s1 = "Casablanca";
        String s2 = "Portentoso";
        /*String s3 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
   			"simplify the build processes in the Jakarta Turbine project. There were several" + 
   			" projects, each with their own Ant build files, that were all slightly different." +
   			"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
   			"definition of what the project consisted of, an easy way to publish project information" +
   			"and a way to share JARs across several projects. The result is a tool that can now be" +
   			"used for building and managing any Java-based project. We hope that we have created " +
   			"something that will make the day-to-day work of Java developers easier and generally help " +
   			"with the comprehension of any Java-based project.";
        String s4 = "This post is not about deep learning. But it could be might as well. This is the power of " +
   			"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
   			"ask? I am going to try to answer this question in this article." + 
   		        "Go to the profile of Marin Vlastelica Pogančić" + 
   		        "Marin Vlastelica Pogančić Jun";*/
        int resposta = ED(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("RESP: "+resposta+" ; ITR: "+countItr+"; INSTR: "+countInstr);
        System.out.println();
        
    }

    public static int ED(String S, String T, int i, int j){
        countItr++;
        countInstr++;
        if(i==-1 && j==-1){
            countInstr++;
            return 0;
        }
        countInstr++;
        if(i==-1){
            countInstr++;
            return T.length();
        }
        countInstr++;
        if(j==-1){
            countInstr++;
            return S.length();
        }
        countInstr++;
        if(S.charAt(i) == T.charAt(j)){
            countInstr++;
            return ED(S, T, i-1, j-1);
        }
        countInstr += 3;
        int sub = ED(S, T, i-1, j-1) +1;
        int ins = ED(S, T, i, j-1) +1;
        int rem = ED(S, T, i-1, j) +1;
        countInstr += 3;
        if(sub <= ins && sub <= rem){
            countInstr++;
            return sub;            
        } 
        if(ins <= sub && ins <= rem){
            countInstr++;
            return ins;
        }
        if(rem <= sub && rem <= ins){
            countInstr++;
            return rem;
        }        
        countInstr++;
        return 0;
    }
}