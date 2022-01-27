package chap7;

class Data {
    int a = 5;

  /*  public String toString()
    {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }  */
}

public class TestToString {
    public static void main(String[] args) {

        Data dObj = new Data();
        System.out.println("toString value : "+ dObj);

        System.out.println("HashCOde value : "+ dObj.hashCode());

        //String z = Integer.parseInt("6d06d69c",16); // error returns int
        //System.out.println("test : "+z);

        System.out.println("Hexadecimal value from the hashcode : "+Integer.toHexString(dObj.hashCode()));

        System.out.println("Convert Hexdecimal value 7852e922 to int :"+Integer.parseInt("7852e922",16));



        String s = "hello world";
        System.out.println(s.hashCode());
        System.out.println(Integer.toHexString(s.hashCode()));
        String z = Integer.toHexString(s.hashCode()); // returns string
        System.out.println(z);
    }
}

