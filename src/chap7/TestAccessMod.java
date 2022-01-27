package chap7;

/*
 *  Will work if method overriden in child has friendlier access modifiers
 *  private to public -- OKAI
 *  public to private -- ERROR
 */

class AccessModParent
{
    private void show()
    {
        System.out.println("Parent show");
    }
}

public class TestAccessMod extends AccessModParent
{
    public void show()
    {
        System.out.println("child show");
    }

    public static void main(String[] args)
    {
        TestAccessMod tam = new TestAccessMod();
        tam.show();
    }
}

