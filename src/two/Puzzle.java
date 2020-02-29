package two;

public class Puzzle {

    public static void main(String []args)
    {
        PuzzleHelper e1 = new PuzzleHelper();
        PuzzleHelper e2 = new PuzzleHelper();

        int x=0;

        while(x<4)
        {
            e1.print();

            e1.count=e1.count +1 ;
            if(x>0) {

                e2.count = e2.count +1 ;
            }

            if(x>1) {

                e2.count = e2.count + e1.count;
            }
            x=x+1;
        }

        System.out.println(e2.count);
    }

}

class PuzzleHelper {

    int count =0;

    public void print()
    {
        System.out.println(" : D ");
    }
}
