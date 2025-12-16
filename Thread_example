// Runs infinite times so use with caution
class BMSCollege extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000); // 10 seconds
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CSE extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("CSE");
                Thread.sleep(2000); // 2 seconds
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Threads_example {
    public static void main(String[] args) {
        BMSCollege t1 = new BMSCollege();
        CSE t2 = new CSE();

        t1.start();
        t2.start();
    }
}
