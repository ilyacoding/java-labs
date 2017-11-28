package by.bsuir.ilyacoding.Server;

import by.bsuir.ilyacoding.Server.controller.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<Socket> clientList = new LinkedList<>();

    public static void main(String ... args) {
        try (ServerSocket serverSocket = new ServerSocket(8000))
        {

            System.out.println("Server is working...");
            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                clientList.add(socket);
                new ServerThread(socket);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Socket> getClientList() {
        return clientList;
    }
}
