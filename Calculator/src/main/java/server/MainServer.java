package server;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import interfaces.InterfaceCalc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Владимир on 07.02.2016.
 */
public class MainServer {
    private ArrayList<OutputStream> outputList;
    private int serverPort = 8000;

    public void init() throws IOException{
        ServerSocket ss = new ServerSocket(serverPort);
        System.out.println("устанавливаем соединение");
        outputList = new ArrayList<>();
        while (true) {
            Socket socket = ss.accept();
            OutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputList.add(outputStream);
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }

    public class ClientHandler implements Runnable {
        private Socket sock;
        private InterfaceCalc call = null;

        public ClientHandler(Socket sock) {
            this.sock = sock;
            try {
                ObjectInputStream ois = new ObjectInputStream(this.sock.getInputStream());
                call = (InterfaceCalc) ois.readObject();
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            if (call!=null){
                Double d = call.schet();
                for (OutputStream os : outputList){
                    try(ObjectOutputStream outputStream = new ObjectOutputStream(os)){
                        outputStream.writeObject(d);
                        outputStream.flush();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.err.println("переданный объект - null");
        }
    }


    public static void main(String[] args){
        try {
            new MainServer().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
