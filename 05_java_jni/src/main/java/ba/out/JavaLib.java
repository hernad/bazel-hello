package ba.out;


public class JavaLib implements JavaLibAPI {
    private static  JavaLib INSTANCE = new JavaLib();
    public static JavaLibAPI getAPI() { return INSTANCE; }
    
    ////////

    public static void main(String[] args) {
    }

    private JavaLib() { 
        System.out.println("ba.out.JavaLib created ");
    }
    
    @Override
    public int calc(int value) {
        int ret = value * 2;
        System.out.println("In JavaLib: calc(value=" + value + "), return=" + ret);
        return ret;
    }

    @Override
    public String getName() {
        String ret = "testName";
        System.out.println("In JavaLib: getName(), return=" + ret);
        return ret;
    }

    @Override
    public void logme(String s) {
        System.out.println("JavaLib.logme: " + s);
    }
    
}