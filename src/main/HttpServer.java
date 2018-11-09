package main;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        //create server
        System.out.println("criando o server");
        ServerSocket ss = new ServerSocket();
        System.out.println("Vinculando a  porta 19000 e localhost ao servidor");
        ss.bind(new InetSocketAddress("localhost", 19000));
        while (true){
            System.out.println("aguardando a conexão");
            Socket socket = ss.accept();
            System.out.println("fazendo a leitura do stream");
            byte[] b = new byte[4];
            socket.getInputStream().read(b);
            String msg = new String(b);
            System.out.println("Recebido: "+ new String(b));
            System.out.println("Escrevendo uma resposta");
            socket.getOutputStream().write("ACKH".getBytes());
            System.out.println("Finalizando a conexão");
            socket.close();
            //
            if(msg.equals("exit")){
                System.out.println("Parando...");
                break;
            }
        }
        System.out.println("Encerrando servidor");
        ss.close();


    }
}
