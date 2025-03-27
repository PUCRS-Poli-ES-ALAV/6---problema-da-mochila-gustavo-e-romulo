class exerc{

    public static void main(String[] args) {
        int a = fiboRec(4);
        int b = fiboRec(8);
        int c = fiboRec(16);
        int d = fiboRec(32);
        int e = fibo(4);
        int f = fibo(8);
        int g = fibo(16);
        int h = fibo(32);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("----------");
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println("----------");
        //int[] vet = new int[10001];
        int n = 10000;
        //int x = memoizedFibo(vet, n);
        int y = fibo(n);
        System.out.println(y);

    }

    public static int fiboRec(int n){
        if(n <= 1){
            return n;
        }
        else{
            int a = fiboRec(n-1);
            int b = fiboRec(n-2);
            return a + b;
        }
    }

    public static int fibo(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static int memoizedFibo(int[] f, int n){
        for(int i = 0; i<=n; i++){
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    public static int lookupFibo(int[] f, int n){
        if(f[n] >= 0){
            return f[n];
        }
        if(n<=1){
            f[n] = n;
        }
        else{
            f[n] = lookupFibo(f, n -1) + lookupFibo(f, n - 2);
        }
        return f[n];
    }
}