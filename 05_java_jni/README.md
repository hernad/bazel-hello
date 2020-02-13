
build libjavalib.so:

    bazel build :javaclib

build java_hello_jna, then run:

    bazel build :java_hello_jna ; cd bazel-bin ; ./java_hello_jna ; cd ..


output:

<pre>
*** Run() constructor ****
JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
------ create_vm class: ba/out/JavaLib ----------
Creating the JVM with classpath=-Djava.class.path=/usr/lib/jvm/java-1.8.0-openjdk:./libjava_lib.jar:.
bufLen=1, nVMS=1
java vm created :)
Looking for ba/out/JavaLib
ba.out.JavaLib created 
Getting main
Getting constructor
--------------------------------------
C set reg_calc_cb - attach java callback
C set reg_getName_cb - attach java callback
JavaCAPI callbacks registered
Starting ba.out.run.Run:
C getName() ; java classname=ba/out/JavaLib
java callback reg_getName_func
C logme; msg=Hello HERNAD [getname]; java classname=ba/out/JavaLib
C LOGME [no java callback]: Hello HERNAD [getname]

C set reg_logme_cb - attach java callback
C calc(value=2), java classname=ba/out/JavaLib
java callback reg_calc_func [val x 5]
C logme; msg=The result of calc(2) = 10; java classname=ba/out/JavaLib
logme_cb_func jstring The result of calc(2) = 10
java callback reg_logme_func
JAVA LOGME: The result of calc(2) = 10
=========C start callback =========
JavaCAPI.callback was returned
11
C logme; msg=The value from the callback was 11; java classname=ba/out/JavaLib
logme_cb_func jstring The value from the callback was 11
java callback reg_logme_func
JAVA LOGME: The value from the callback was 11
</pre>


run main_java_capi:

    bazel build :main_java_capi ; cd bazel-bin ; ./main_java_capi ; cd ..

