package codekitchen;

import java.net.*;
import java.io.*;
import java.util.*;

class BeatBoxServer
{
    ArrayList<ObjectOutputStream> clientOutputStreams = new ArrayList<ObjectOutputStream>();
    BufferedReader reader;

    public static void main(String[] args)
    {
        BeatBoxServer beatBoxServer = new BeatBoxServer();
        beatBoxServer.setupServer();
    }

    public void setupServer()
    {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("SERVER STARTED");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("CONNECTED WITH SERVER");

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                clientOutputStreams.add(objectOutputStream);

                Thread thread = new Thread(new ReadAndShare(socket));
                thread.start();
            }
        }

        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    class ReadAndShare implements Runnable
    {
        ObjectInputStream in;

        public ReadAndShare(Socket socket)
        {
            try {
                in = new ObjectInputStream(socket.getInputStream());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        public void run()
        {
            Object objectOne = null;
            Object objectTwo = null;

            try {
                if((objectOne = in.readObject()) != null)
                {
                    objectTwo = in.readObject();
                    System.out.println("recieved message:"+objectOne);
                    System.out.println("recieved music:"+objectTwo);
                    shareMessage(objectOne, objectTwo);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void shareMessage(Object objectOne, Object objectTwo)
    {
        Iterator it = clientOutputStreams.iterator();

        while(it.hasNext())
        {
            try {
                ObjectOutputStream objectOutputStream = (ObjectOutputStream) it.next();
                objectOutputStream.writeObject(objectOne);
                objectOutputStream.writeObject(objectTwo);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
