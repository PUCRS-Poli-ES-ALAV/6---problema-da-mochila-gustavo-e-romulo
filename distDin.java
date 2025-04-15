public class distDin {
    static int countItr = 0;
    static int countInstr = 0;

    public static void main(String[] args) {
        String s1 = "Casablanca";
        String s2 = "Portentoso";
        String s3 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
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
                   "Marin Vlastelica Pogančić Jun";
        int resposta = distEdProgDina(s1, s2);
        System.out.println("RESP: "+resposta+"; ITR: "+countItr+"; INSTR: "+countInstr);
        countInstr = 0;
        countItr = 0;
        int resposta2 = distEdProgDina(s3, s4);
        System.out.println("RESP: "+resposta2+"; ITR: "+countItr+"; INSTR: "+countInstr);
    }

    public static int distEdProgDina(String a, String b) {
        countItr++;
        countInstr++;
        int m = a.length();
        int n = b.length();
        int[][] matriz = new int[m+1][n+1];
        matriz[0][0] = 0;
        countInstr += 4;

        for(int i = 1; i<=m; i++){
            countItr++;
            countInstr += 2;
            matriz[i][0] = matriz[i-1][0] +1;
        }
        for(int j = 1; j<=n; j++){
            countItr++;
            countInstr += 2;
            matriz[0][j] = matriz[0][j-1] +1;
        }
        for(int i = 1; i<=m; i++){
            countItr++;
            countInstr++;
            for(int j = 1; j<=n; j++){
                countItr++;
                countInstr++;
                int custoExtra = 0;
                countInstr++;
                if(a.charAt(i-1) == b.charAt(j-1)){
                    custoExtra = 0;
                    countInstr += 2;
                } else {
                    custoExtra = 1;
                    countInstr += 2;
                }
                int min = Math.min(matriz[i-1][j] +1, matriz[i][j-1] +1);
                matriz[i][j] = Math.min(matriz[i-1][j-1] + custoExtra, min);
                countInstr += 4;
            }
        }
        countInstr++;
        return matriz[m][n];
    }
}
