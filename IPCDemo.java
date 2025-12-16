import java.io.*;

class Writer extends Thread {
    PipedOutputStream pos;

    Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            pos.write("Hello from Writer Thread".getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Reader extends Thread {
    PipedInputStream pis;

    Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int ch;
            while ((ch = pis.read()) != -1) {
                System.out.print((char) ch);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

public class IPCDemo {
    public static void main(String[] args) throws IOException {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Writer w = new Writer(pos);
        Reader r = new Reader(pis);

        w.start();
        r.start();
    }
}