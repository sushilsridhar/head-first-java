package chap9;

abstract class Animal {

    public Animal(String name)
    {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

class Hippo extends Animal{

    public Hippo(String ok)
    {
        super(ok);
    }

}

public class TestSuper {

    public static void main(String[] args)
    {
        Hippo h = new Hippo("hello");
        System.out.println(h.getName());
    }

}
