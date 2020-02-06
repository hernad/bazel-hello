load("@rules_cc//cc:defs.bzl", "cc_library", "cc_binary")

#https://stackoverflow.com/questions/51689092/playing-with-bazel-c-tutorials-build-does-not-create-use-shared-libraries

#https://docs.bazel.build/versions/2.0.0/be/c-cpp.html#cc_import

cc_library(
    name = "zero",
    srcs = ["lib.cc"],
    hdrs = ["lib.h"],
    alwayslink = 1,
    #visibility = ["//visibility:public"],
)


# first will link to libzero.a
cc_binary(
  name = "main_static",
  srcs = ["main.cc"],
  deps = [":zero"],
  linkstatic = 1, # default value
)

# second will link to libzero.so
cc_binary(
  name = "main_shared",
  srcs = ["main.cc"],
  deps = [":zero"],
  linkstatic = 0,
)



