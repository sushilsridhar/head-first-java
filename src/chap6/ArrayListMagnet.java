package chap6;

import java.util.ArrayList;

public class ArrayListMagnet {

    public static void printAL(ArrayList<String> al)
    {
        for(String element : al)
        {
            System.out.print(element+ " ");
        }
        System.out.println(" ");

    }

    public static void main(String[] args)
    {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0,"zero");
        a.add(1, "chap1");
        a.add(2, "chap2");
        a.add(3, "chap3");
        printAL(a);

        a.remove(2);

        if(a.contains("chap2"))
            a.add("2.2");
        if(a.contains("chap3"))
            a.add("chap4");
        printAL(a);

        if(a.indexOf("chap4") != 4)
            a.add(4,"4.2");

        printAL(a);
        printAL(a);
    }
}
