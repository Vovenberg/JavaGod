package server;

import interfaces.InterfaceCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Владимир on 07.02.2016.
 */
public class MainServer {
    ArrayList outputList;

    public void init() throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        System.out.println("устанавливаем соединение");
        while (true) {
            Socket socket = ss.accept();
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            outputList = new ArrayList();
            outputList.add(pw);

            Thread t = new Thread(new ClientHandler(socket));
            t.start();

        }

    }


    public class ClientHandler implements Runnable {
        BufferedReader reader;
        InterfaceCalc call = null;

        public ClientHandler(Socket sock) {
            Socket clientSock = sock;
            try {
                ObjectInputStream ois = new ObjectInputStream(clientSock.getInputStream());
                call = (InterfaceCalc) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            Double d = call.schet();
            for (int i = 0; i < outputList.size(); i++) {
                PrintWriter writer = (PrintWriter) outputList.get(i);
                writer.println(d);
                writer.flush();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new MainServer().init();
    }
}
