package ba.out;

import com.sun.jna.Platform;
import com.sun.jna.Native;
import com.sun.jna.Library;

public class Java3 {

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(
            (Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
        void printf(String format, Object... args);
    }

    public Java3() {
        System.out.println("Java3 constructor");
        
    }

    public static void main(String[] args) {
        System.out.println("Java3 main START");
        CLibrary.INSTANCE.printf("Hello %s d=%d\n", "WORLD", 3);
        System.out.println("Java3 main END");
    }
}