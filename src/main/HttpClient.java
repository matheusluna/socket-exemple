package main;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket("192.168.1.109", 19000);
            socket.getOutputStream().write("math".getBytes());
            byte[] b = new byte[4];
            socket.getInputStream().read(b);
            System.out.println("Recebido pelo servidor: " + new String(b));
            socket.close();
        }
    }
}
