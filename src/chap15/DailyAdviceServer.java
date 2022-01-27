package chap15;

import java.net.*;
import java.io.*;

class DailyAdviceServer {

    String[] adviceArray = {"Take smaller bites","Go for tight jeans. No they don't make you look fat","One word : inappropriate","Just for today be honest!","You might want to rethink that haircut"};

    void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.println("Server started -----");

            while(true)
            {
                Socket sock = serverSocket.accept();

                System.out.println("Client request recieved---");

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = fetchAdvice();
                System.out.println("advice is : "+advice);
                writer.println(advice);
                writer.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    String fetchAdvice()
    {
        int random = (int) (Math.random() * adviceArray.length);
        String advice = adviceArray[random];
        return advice;
    }

    public static void main(String[] args)
    {
        DailyAdviceServer dailyAdviceServer = new DailyAdviceServer();
        dailyAdviceServer.startServer();
    }
}
