package ba.out.run;

import com.sun.jna.Callback;
import com.sun.jna.Library; 
import com.sun.jna.Native; 
import com.sun.jna.Platform;

public class Run {

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
            Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                               CLibrary.class);

        void printf(String format, Object... args);
    }

    public static class JavaCAPI {
        
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
        
        public static native void reg_calc_cb(reg_calc_callback func);
        public static native void reg_getName_cb(reg_getName_callback func);
        public static native void reg_logme_cb(reg_logme_callback func);

        public static native int calc(int x);
        public static native int logme(String s);
        public static native String getName();
        public static native void callme(callback func);
        
        static {
            Native.register("javaclib");
        }
    }
    
    static int value = 0;
    
    static JavaCAPI.callback func = new JavaCAPI.callback() {
        public void invoke(int val) {
            Run.value = val;
            System.out.println("JavaCAPI.callback was returned");
            System.out.println(value);
        }
    };    

        
    public static JavaCAPI.reg_calc_callback reg_calc_func = 
    new JavaCAPI.reg_calc_callback() {
        public int invoke(int val) {
            System.out.println("java callback reg_calc_func [val x 5]");
            return val * 5;
        }
    };

    public static JavaCAPI.reg_getName_callback reg_getName_func = 
    new JavaCAPI.reg_getName_callback() {
        public String invoke() {
            System.out.println("java callback reg_getName_func");
            return "HERNAD";
        }
    };

    public static JavaCAPI.reg_logme_callback reg_logme_func = 
            new JavaCAPI.reg_logme_callback() {
        public void invoke(String val) {
            System.out.println("java callback reg_logme_func");
            System.out.println("JAVA LOGME: " + val);
        }
    };

    static Run INSTANCE = new Run();


    public Run() {
        System.out.println("*** Run constructor ****");
        //JavaCAPI.reg_calc_cb(reg_calc_func);
        //JavaCAPI.reg_getName_cb(reg_getName_func);
        //JavaCAPI.reg_logme_cb(reg_logme_func);
        
        //System.out.println("JavaCAPI callbacks registered");
    
    }
    
    public static void main(String[] args) {
    
        CLibrary.INSTANCE.printf("Starting ba.out.run.Run:\n");

        JavaCAPI.logme("Hello " + JavaCAPI.getName() + " [getname]" );
        
        JavaCAPI.reg_logme_cb(reg_logme_func);
        JavaCAPI.logme("The result of calc(2) = " + JavaCAPI.calc(2) );
        
        JavaCAPI.callme(func);

        JavaCAPI.logme("The value from the callback was " + value);
    }   
}