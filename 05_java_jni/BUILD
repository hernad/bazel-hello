load("@rules_java//java:defs.bzl", "java_binary")


package(default_visibility = ["//visibility:public"])

java_binary(
    name = "java_hello_libc",
    main_class = "ba.out.HelloLibC",
    srcs = ["src/main/java/ba/out/HelloLibC.java"],
    deps = [ "@maven//:net_java_dev_jna_jna" ]
    #visibility = ["//visibility:public"]
)

