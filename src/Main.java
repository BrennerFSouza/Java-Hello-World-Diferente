public class Main {
    public static void main(String[] args) throws InterruptedException {
        String palavra = "Hello World!";
        int tamanhoPalavra = palavra.length();
        StringBuilder sb = new StringBuilder();
        char letraVerificada;
        Object lock = new Object();

        for (int i = 0; i < tamanhoPalavra; i++) {
            letraVerificada = palavra.charAt(i);
            sb.append(" ");
            for (int j = 32; j <= 127; j++) {
                synchronized (lock) {
                    lock.wait(1);
                }
                char c = (char) j;
                sb.setCharAt(i,c);
                System.out.print(sb.toString());
                System.out.flush();
                System.out.println();


                if (c == letraVerificada) {
                    break;
                }
            }
            synchronized (lock) {
                lock.wait(10);
            }

        }

        System.out.println();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        System.out.print(sb.toString());
        System.out.println();


    }
}
