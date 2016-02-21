package server;

import core.Calc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владимир on 07.02.2016.
 */
public class MainServer {
    private Map<Socket, OutputStream> outputList;
    private int serverPort = 8000;

    public void init() throws IOException {
        ServerSocket ss = new ServerSocket(serverPort);
        System.out.println("устанавливаем соединение");
        outputList = new HashMap<>();
        while (true) {
            Socket socket = ss.accept();
            Thread t = new Thread(new ClientHandler(socket));
            OutputStream outputStream = socket.getOutputStream();
            outputList.put(socket, outputStream);
            t.start();
        }
    }

    public class ClientHandler implements Runnable {
        private Socket sock;
        private Calc call = null;

        public ClientHandler(Socket sock) {
            this.sock = sock;
        }

        public void run() {
            try {
                ObjectInput ois = new ObjectInputStream(new BufferedInputStream(this.sock.getInputStream()));
                call = (Calc) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (call != null) {
                System.out.println("переданный объект - не null");
                Double d = call.schet();
                BufferedOutputStream os = new BufferedOutputStream(outputList.get(sock));
                try {
                    ObjectOutputStream objectOutput = new ObjectOutputStream(os);
                    String string = String.valueOf(d);
                    objectOutput.writeObject(string);
                    objectOutput.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("переданный объект - null");
            }
        }
    }


    public static void main(String[] args) {
        try {
            new MainServer().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
