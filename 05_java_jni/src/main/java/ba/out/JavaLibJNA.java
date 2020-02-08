package ba.out;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import ba.out.*;


public class JavaLibJNA implements JavaLibAPI {

    // JNA reverse callback code
    //
    public static class JavaCAPI {

        interface reg_calc_callback extends Callback {
            int invoke(int val);
        }

        interface reg_getName_callback extends Callback {
            String invoke();
        }
        interface reg_logme_callback extends Callback {
            void invoke(String val);
        }
        
        public static native void reg_calc_cb(reg_calc_callback func);
        public static native void reg_getName_cb(reg_getName_callback func);
        public static native void reg_logme_cb(reg_logme_callback func);

        static {
            Native.register("javaclib");
        }

    };    
    
    public static JavaCAPI.reg_calc_callback reg_calc_func = 
    new JavaCAPI.reg_calc_callback() {
        public int invoke(int val) {
            return INSTANCE.calc( val );
        }
    };

    public static JavaCAPI.reg_getName_callback reg_getName_func = 
            new JavaCAPI.reg_getName_callback() {
        public String invoke() {
            return INSTANCE.getName();
        }
    };

    public static JavaCAPI.reg_logme_callback reg_logme_func = 
            new JavaCAPI.reg_logme_callback() {
        public void invoke(String val) {
            INSTANCE.logme(val);
        }
    };    

 
    private static JavaLibJNA INSTANCE = new JavaLibJNA();
    public static JavaLibAPI getAPI() { return INSTANCE; }
    

    public static void main(String[] args) {
        System.out.println("ba.out.JavaLibJNA main()");
    }

    private JavaLibJNA() { 
        // Register callbacks with JNA C library
        JavaCAPI.reg_calc_cb(reg_calc_func);
        JavaCAPI.reg_getName_cb(reg_getName_func);
        JavaCAPI.reg_logme_cb(reg_logme_func);
        System.out.println("ba.out.JavaLibJNA: callbacks registered " + this);
    }

    /////////////////////////////////////////////////////////////////////////

    private JavaLibAPI mJavaLibAPI = 
        JavaLib.getAPI();

    @Override
    public int calc(int value) {
        return mJavaLibAPI.calc(value);
    }

    @Override
    public String getName() {
        return mJavaLibAPI.getName();
    }

    @Override
    public void logme(String s) {
        mJavaLibAPI.logme(s);
    }
}