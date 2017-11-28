package by.bsuir.ilyacoding.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("localhost", 8000);

            PrintWriter toServer = new PrintWriter(socket.getOutputStream());
            ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

            String command;
            System.out.print("[Me] > ");
            while (!(command = scanner.nextLine()).equals("exit")) {
                toServer.write(command + '\n');
                toServer.flush();

                String sentence = (String)fromServer.readObject();
                System.out.println("[Remote] > " + sentence);

                System.out.print("[Me] > ");
            }
            socket.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
