package eight;

/*
 *       TestSuperKeywordB c = new TestSuperKeyword(); ---> RESTRICT ACCESS TO SUBCLASS SPECIFIC METHODS
 *
 *       c.show(); --> ALWAYS CALL METHOD IN SUBCLASS IF OVERIDDEN
 */

class TestSuperKeywordB
{
    public void show()
    {
        System.out.println("okai :P");
    }
}

public class TestSuperKeyword extends TestSuperKeywordB
{
    public static void main(String[] args)
    {
        TestSuperKeywordB c = new TestSuperKeyword();
        c.show();  // ERROR IF SHOW() ISN'T FOUND IN PARENT CLASS

    }

    public void show()
    {
        super.show();
        System.out.println("okai : P");
    }
}
