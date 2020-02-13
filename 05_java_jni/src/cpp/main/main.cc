#include "jvm_bootstrap.h"
#include "native.h"


int main() {

    //create_vm("ba/out/JavaLib");
    //run_vm("ba/out/Java3");

    //run_javacapi();

    // https://imagej.net/Developing_using_native_libraries

    // https://github.com/imagej/example-legacy-plugin/blob/native/src/main/c/JNI_Example.c


    printf("main_native start:\n");
    set_test_int(1);
    printf("testint=%d\n", get_test_int());

    init_native();
    
    printf("calc(10)=%d\n", calc(10));

    printf("testint=%d\n", get_test_int());


    set_test_int(3);

    printf("java long static callback_calc=%llu\n", get_java_long_static_variable("ba/out/JavaLibJNA", "callback_calc"));
    
    //printf("java long static callback_calc=%llu\n", get_java_long_static_variable("ba/out/JavaLibJNA", "callback_calc"));
    

    printf("is_calc_cb_registered=%d\n", is_calc_cb_registered());


    printf("testint=%d\n", get_test_int());

    printf("java counter=%d\n", get_java_int_static_variable("ba/out/JavaLibJNA", "counter"));

    printf("calc(20)=%d\n", calc(20));
    set_java_int_static_variable("ba/out/JavaLibJNA", "counter", 100);

    printf("callback_calc=%llu\n", get_java_long_static_variable("ba/out/JavaLibJNA", "callback_calc"));


    //https://stackoverflow.com/questions/19429955/get-an-instance-variable-in-a-java-class-from-c-jni

    printf("java counter=%d\n", get_java_int_static_variable("ba/out/JavaLibJNA", "counter"));

    return 0;
}
