load("@rules_java//java:defs.bzl", "java_binary", "java_library")
load("@rules_cc//cc:defs.bzl", "cc_library", "cc_binary")

package(default_visibility = ["//visibility:public"])


# depends on deprecated target '@local_jdk//:jni_md_header-linux': 
# Don't depend on targets in the JDK workspace; 
# use @bazel_tools//tools/jdk:current_java_runtime instead 
# (see https://github.com/bazelbuild/bazel/issues/5594)


cc_library(
    name = "native",
    srcs = [ 
        "src/cpp/native/native.cc",
        "src/cpp/native/jvm_bootstrap.cc",
        "@bazel_tools//tools/jdk:current_java_runtime",
        #"@local_jdk//:jni_header",
        #"@local_jdk//:jni_md_header-linux"

    ],
    hdrs = [
        "src/cpp/native/jvm_bootstrap.h",
        "src/cpp/native/native.h"],
    includes = [ 
       "external/local_jdk/include",
       "external/local_jdk/include/linux" 
    ]
)

cc_binary(
    name = "main_native",
    srcs = [ "src/cpp/main/main.cc" ],
    deps = [":native"],
    includes = [
       #As all bazel compilations have an implicit -I on the directory containing WORKSPACE.
       "src/cpp/native",
    ]
) 


java_binary(
    name = "java_hello_libc",
    main_class = "ba.out.HelloLibC",
    srcs = ["src/main/java/ba/out/HelloLibC.java"],
    deps = [ "@maven//:net_java_dev_jna_jna" ]
    #visibility = ["//visibility:public"]
)

java_binary(
    name = "java3_main",
    main_class = "ba.out.Java3",
    srcs = ["src/main/java/ba/out/Java3.java"],
    deps = [ "@maven//:net_java_dev_jna_jna" ]
    #visibility = ["//visibility:public"]
)

java_library(
   name = "javalib",
   srcs = [
       "src/main/java/ba/out/JavaLib.java",
       #"src/main/java/ba/out/JavaCAPI.java",
       #"src/main/java/ba/out/Java3.java",
       "src/main/java/ba/out/JavaLibAPI.java",
       "src/main/java/ba/out/JavaLibJNA.java"
    ],
    deps = [ "@maven//:net_java_dev_jna_jna" ]
)


java_binary(
   name = "java_hello_jna",
   srcs = [
       "src/main/java/ba/out/run/Run.java",
   ],
   deps = [ 
     ":java_lib",
     "@maven//:net_java_dev_jna_jna",
     ":javaclib" ],
   main_class = "ba.out.run.Run"
)