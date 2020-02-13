package ba.out;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import ba.out.*;


// JNA reverse callback code
//
public class JavaCAPI {


    private static JavaLib INSTANCE;

    public static native void reg_calc_cb(reg_calc_callback func);
    public static native void reg_getName_cb(reg_getName_callback func);
    public static native void reg_logme_cb(reg_logme_callback func);
    
    public static native int calc(int x);
    public static native int logme(String s);
    public static native String getName();
    public static native void callme(callback func);
    public static native String set_java_classname( String classname);
     
    interface callback extends Callback {
        void invoke(int val);
    }

    interface reg_calc_callback extends Callback {
        int invoke(int val);
    }

    interface reg_getName_callback extends Callback {
        String invoke();
    }
    interface reg_logme_callback extends Callback {
        void invoke(String val);
    }
    
    public static reg_calc_callback reg_calc_func = new reg_calc_callback() {
        public int invoke(int val) {
            System.out.println("invoke-1");
            return INSTANCE.calc( val );
        }
    };

    public static reg_getName_callback reg_getName_func =  new reg_getName_callback() {
        public String invoke() {
            System.out.println("invoke-2");
            return INSTANCE.getName();
        }
    };

    public static reg_logme_callback reg_logme_func = new reg_logme_callback() {
        public void invoke(String val) {
            System.out.println("invoke-3");
            INSTANCE.logme(val);
        }
    };    

    public static JavaLibAPI getAPI() { return INSTANCE; }
    
    public JavaCAPI() {
        System.out.println ("-- JavaCAPI constructor START --");

        INSTANCE = new JavaLib();
        set_java_classname("ba/out/JavaLib");
        reg_calc_cb(reg_calc_func);
        reg_getName_cb(reg_getName_func);
        reg_logme_cb(reg_logme_func);
        JavaCAPI.logme(JavaCAPI.getName());
    }

    public static void main(String[] args) {
        System.out.println(">> JavaCAPI main method <<");

    }

    static {
        System.out.println("JavaCAPI: register javaclib");
        Native.register("javaclib");

    }    

};