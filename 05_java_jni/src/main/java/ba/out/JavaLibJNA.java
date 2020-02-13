package ba.out;

import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import java.nio.*; 
import java.util.*;

import ba.out.*;


public class JavaLibJNA implements JavaLibAPI {

    // JNA reverse callback code
    //
    public static int counter = 0;
    public static long callback_calc = 1010;
    public static ByteBuffer bb; 

    public static class JavaCAPI {

        interface reg_calc_callback extends Callback {
            int invoke(int val);
        }

        //interface reg_getName_callback extends Callback {
        //    String invoke();
        //}
        //interface reg_logme_callback extends Callback {
        //    void invoke(String val);
        //}
        
        public static native void reg_calc_cb(reg_calc_callback func);
        //public static native void reg_getName_cb(reg_getName_callback func);
        //public static native void reg_logme_cb(reg_logme_callback func);

        static {
            Native.register("native");
        }

    };    
    
    public static JavaCAPI.reg_calc_callback reg_calc_func = 
    new JavaCAPI.reg_calc_callback() {
        public int invoke(int val) {
            return INSTANCE.calc( val );
        }
    };

    /*
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
    */


    private static JavaLibJNA INSTANCE = new JavaLibJNA();
    public static JavaLibAPI getAPI() { return 
        INSTANCE; 
    }
    

    public static void main(String[] args) {
        System.out.println("ba.out.JavaLibJNA main");
    }

    private JavaLibJNA() { 
        System.out.println("ba.out.JavaLibJNA constructor START");
        // Register callbacks with JNA C library
        
        
        //JavaCAPI.reg_calc_cb(reg_calc_func);
        JavaCAPI.reg_calc_cb( null );


        //JavaLibJNA.callback_calc = (long) reg_calc_func;

        JavaLibJNA.counter++;
        //JavaCAPI.reg_getName_cb(reg_getName_func);
        //JavaCAPI.reg_logme_cb(reg_logme_func);
        
        //System.out.println("ba.out.JavaLibJNA: callbacks registered " + this);


        /*
        ByteBuffer bb = ByteBuffer.allocate(5); 
  
            // putting the int to byte value in ByteBuffer 
            bb.put((byte)20); 
            bb.put((byte)30); 
            bb.put((byte)40); 
            bb.rewind(); 
        */

        /*
        bb = ByteBuffer.allocateDirect(5); 
  
        // creating byte array of size capacity 
        byte[] value = { 20, 30, 40, 50, 0 }; 
            // wrap the byte array into ByteBuffer 
        bb = ByteBuffer.wrap(value);
  
            // print the ByteBuffer 
            //System.out.println("Original ByteBuffer:  " + Arrays.toString(bb.array())); 
        System.out.println("Direct ByteBuffer:  " + Arrays.toString(bb.array()));
        */

        System.out.println("ba.out.JavaLibJNA constructor END");

    }

    private JavaLibAPI mJavaLibAPI = JavaLib.getAPI();

    @Override
    public int calc(int value) {
        return mJavaLibAPI.calc(value);
    }

    /*
    @Override
    public String getName() {
        return mJavaLibAPI.getName();
    }

    @Override
    public void logme(String s) {
        mJavaLibAPI.logme(s);
    }
    */
}