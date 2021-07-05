package five;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;


class TestImportJar
{
    public static void main(String[] args)
    {
        int[] intArray = { 1, 2, 3, 4, 5 };
        int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
        System.out.println(Arrays.toString(removed));
    }
}