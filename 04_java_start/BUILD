load("@rules_java//java:defs.bzl", "java_binary", "java_library")


package(default_visibility = ["//visibility:public"])

java_library(
    name = "java_lib_04",
    srcs = glob(["src/main/java/ba/out/*.java"]),
    deps = ["@maven//:com_google_guava_guava"],
)

java_binary(
    name = "java_greet",
    main_class = "ba.out.ProjectRunner",
    srcs = ["src/main/java/ba/out/ProjectRunner.java"],
    deps = [":java_lib_04"]
    #visibility = ["//visibility:public"]
)

