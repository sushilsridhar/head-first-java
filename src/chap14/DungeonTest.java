package chap14;

import java.io.*;

public class DungeonTest {

    public static void main(String[] args)
    {
        try {
            DungeonGame d1 = new DungeonGame();
            System.out.println(d1.getX()+d1.getY()+d1.getZ());

            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d1);
            oos.close();

            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            DungeonGame d = (DungeonGame) ois.readObject();

            ois.close();

            System.out.println(d.getX()+d.getY()+d.getZ());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class DungeonGame implements Serializable {

    public int x = 3;
    transient long y = 4;
    private short z = 5;

    int getX() {
        return x;
    }
    long getY() {
        return y;
    }
    short getZ() {
        return z;
    }
}



