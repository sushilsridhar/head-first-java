package chap15;


import java.net.*;
import java.io.*;

class DailyAdviceClient {

    void startClient() {
        try {
            Socket socket = new Socket("127.0.0.1",4242);

            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());

            BufferedReader reader = new BufferedReader(inputStream);

            String line = null;

            while((line = (String) reader.readLine()) != null)
            {
                System.out.println("Today you should: "+line);
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DailyAdviceClient dailyAdviceClient = new DailyAdviceClient();
        dailyAdviceClient.startClient();
    }
}
