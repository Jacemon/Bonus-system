package by.jcompany.bonus_system.boot.server;

import by.jcompany.bonus_system.boot.server.init.InitCommands;
import by.jcompany.bonus_system.boot.server.init.InitDatabaseRows;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
    public static final int SERVER_PORT = 4040;
    public static boolean exit = false;
    public static String exitServerString = "exit";
    
    public static void start() {
        InitCommands.create();
        InitDatabaseRows.tryInitAdmin();
        InitDatabaseRows.tryInitUndefinedRole();
        InitDatabaseRows.tryInitCommonRole();
        
        ServerSocket serverSocket = null;
        int clientCount = 0;
        
        try {
            System.out.println("server starting...");
            System.out.println("for exit input \"" + exitServerString + "\"");
            serverSocket = new ServerSocket(SERVER_PORT);
            
            Thread exitThread = new Thread(() -> {
                while (!exit) {
                    Scanner in = new Scanner(System.in);
                    if (in.nextLine().equals(exitServerString)) {
                        exit = true;
                        System.out.print("server will closed when next client was processed...");
                    }
                }
            });
            exitThread.start();
            
            // todo переделать как показывал препод
            while (!exit) {
                ClientHandler clientHandler = new ClientHandler(serverSocket.accept(), clientCount++);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                System.out.println("server closed...");
            }
        }
    }
}