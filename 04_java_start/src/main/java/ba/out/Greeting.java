package ba.out;

// import from guava
import com.google.common.primitives.Ints;


public class Greeting {

    public static int compare(int a, int b) {
        return Ints.compare(a, b);
    }

    public static void sayHi() {

            System.out.println( compare(20, 1) );
            System.out.println( compare(10, 10) );
            System.out.println( compare(100, 200) );
            System.out.println("Hi from out.ba!");
    }
}

