class exerc{

    static int countIter=0;
    public static void main(String[] args) {
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println(d);
        // System.out.println("----------");
        // System.out.println(e);
        // System.out.println(f);
        // System.out.println(g);
        // System.out.println(h);
        // System.out.println("----------");
        
        //int y = fibo(n);
        //System.out.println(y);
        System.out.println("----------");
        System.out.println("FiboRec");
        int a = fiboRec(4);
        System.out.println("N4 RES:"+a+" ITER:"+countIter);
        resetCountIter();
        
        int b = fiboRec(8);
        System.out.println("N8 RES:"+b+" ITER:"+countIter);
        resetCountIter();
        int c = fiboRec(16);
        System.out.println("N16 RES:"+c+" ITER:"+countIter);
        resetCountIter();

        int d = fiboRec(32);
        System.out.println("N32 RES:"+d+" ITER:"+countIter);
        resetCountIter();

        System.out.println("----------");
        System.out.println("Fibo");
        double e = fibo(4);
        System.out.println("N4 RES:"+e+" ITER:"+countIter);
        resetCountIter();

        double f = fibo(8);
        System.out.println("N8 RES:"+f+" ITER:"+countIter);
        resetCountIter();

        double g = fibo(16);
        System.out.println("N16 RES:"+g+" ITER:"+countIter);
        resetCountIter();

        double h = fibo(32);
        System.out.println("N32 RES:"+h+" ITER:"+countIter);
        resetCountIter();
        System.out.println("----------");
        System.out.println("MemoizedFibo");
        double[] vet = new double[5];
        int n = 4;
        double x = memoizedFibo(vet, n);
        System.out.println("N4 RES:"+x+" ITER:"+countIter);
        resetCountIter();
        double[] vet2 = new double[9];
        int n2 = 8;
        double y = memoizedFibo(vet2, n2);
        System.out.println("N8 RES:"+y+" ITER:"+countIter);
        resetCountIter();
        double[] vet3 = new double[17];
        int n3 = 16;
        double z = memoizedFibo(vet3, n3);
        System.out.println("N16 RES:"+z+" ITER:"+countIter);
        resetCountIter();
        double[] vet4 = new double[33];
        int n4 = 32;
        double w = memoizedFibo(vet4, n4);
        System.out.println("N32 RES:"+w+" ITER:"+countIter);
        resetCountIter();

        System.out.println("----------");
        System.out.println("Values 128 1000 10000");
        int v1 = 128;
        int v2 = 1000;
        int v3 = 10000;

        System.out.println("Fibo");
        double x1 =fibo(v1);
        System.out.println("N128 RES:"+x1+" ITER:"+countIter);
        resetCountIter();
        double x2 =fibo(v2);
        System.out.println("N1000 RES:"+x2+" ITER:"+countIter);
        resetCountIter();
        double x3 =fibo(v3);
        System.out.println("N10000 RES:"+x3+" ITER:"+countIter);
        resetCountIter();
        System.out.println("----------");
        
        System.out.println("MemoizedFibo");
        double[] vet5 = new double[v1+1];
        double x4 = memoizedFibo(vet5, v1);
        System.out.println("N128 RES:"+x4+" ITER:"+countIter);
        resetCountIter();
        double[] vet6 = new double[v2+1];
        double x5 = memoizedFibo(vet6, v2);
        System.out.println("N1000 RES:"+x5+" ITER:"+countIter);
        resetCountIter();/*
        double[] vet7 = new double[v3+1];
        double x6 = memoizedFibo(vet7, v3);
        System.out.println("N10000 RES:"+x6+" ITER:"+countIter);
        resetCountIter();
        System.out.println("----------");
        */
    }

    public static int fiboRec(int n){
        if(n <= 1){
            countIter++;
            return n;
        }
        else{
            int a = fiboRec(n-1);
            int b = fiboRec(n-2);
            countIter++;
            return a + b;
        }
    }

    public static double fibo(int n){
        double[] f = new double[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
            countIter++;
        }
        countIter++;
        return f[n];
    }

    public static double memoizedFibo(double[] f, int n){
        for(int i = 0; i<=n; i++){
            countIter++;
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    public static double lookupFibo(double[] f, int n){
        if(f[n] >= 0){
            return f[n];
        }
        if(n<=1){
            f[n] = n;
        }
        else{
            f[n] = lookupFibo(f, n -1) + lookupFibo(f, n - 2);
        }
        countIter++;
        return f[n];
    }
    public static void resetCountIter(){
        countIter = 0;
    }
}