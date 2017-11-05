public class Main {

    public static void main(String[] args) {

        Thread t1 =new Thread(new Work01());
        t1.start();
        Thread t2 = new Thread(new Work02());
        t2.start();
    }
}
