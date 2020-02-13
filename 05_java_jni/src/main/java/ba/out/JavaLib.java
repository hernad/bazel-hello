package ba.out;


import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import ba.out.*;


public class JavaLib implements JavaLibAPI {

    private static JavaLib INSTANCE = new JavaLib();
    public static JavaLibAPI getAPI() { 
        return INSTANCE; 
    }
    
    public static void main(String[] args) {
       System.out.println("==== running ba.out.JavaLib main() method ====");

    }

    public JavaLib() { 
        System.out.println("ba.out.JavaLib constructor START");

    }
    
    @Override
    public int calc(int value) {
        int ret = value * 2;
        System.out.println("In JavaLib: calc(value=" + value + "), return=" + ret);
        return ret;
    }

    /*
    @Override
    public String getName() {
        String ret = "JavaLibTESTName";
        System.out.println("In JavaLib: getName(), return=" + ret);
        return ret;
    }

    @Override
    public void logme(String s) {
        System.out.println("JavaLib.logme: " + s);
    }
    */
    
}