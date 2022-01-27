package chap15;

import java.util.*;
import java.io.*;
import java.net.*;

class ChatServer {

    ArrayList<PrintWriter> clientOutputStreams;

    class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSock)
        {
            try{
                InputStreamReader streamReader = new InputStreamReader(clientSock.getInputStream());
                reader = new BufferedReader(streamReader);
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }

        public void run()
        {
            String message;
            try{
                while((message = reader.readLine()) != null)
                {
                    System.out.println("message is "+ message);
                    BroadCastMessage(message);
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public void BroadCastMessage(String message)
    {
        Iterator it = clientOutputStreams.iterator();

        while(it.hasNext())
        {
            PrintWriter writer = (PrintWriter) it.next();
            writer.println(message);
            writer.flush();
        }
    }

    void startServer()
    {
        clientOutputStreams = new ArrayList<PrintWriter>();
        try
        {
            ServerSocket serverSock = new ServerSocket(5000);
            System.out.println("SERVER STARTED");

            while(true) {
                Socket clientSock = serverSock.accept();

                System.out.println("CONNECTED WITH SERVER");

                // USED FOR BROAD CASTING THE MESSAGE TO ALL USERS
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                clientOutputStreams.add(writer);

                //CREATE A THREAD FOR EACH AND EVERY CLIENT -- AND GIVE JOB( READ AND BROADCAST )
                Thread t = new Thread(new ClientHandler(clientSock));
                t.start();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ChatServer server = new ChatServer();
        server.startServer();
    }
}
