load("@rules_cc//cc:defs.bzl", "cc_library", "cc_binary")

load("//:windows_dll_library.bzl", "windows_dll_library")


#https://stackoverflow.com/questions/51689092/playing-with-bazel-c-tutorials-build-does-not-create-use-shared-libraries

#https://docs.bazel.build/versions/2.0.0/be/c-cpp.html#cc_import

cc_library(
    name = "zero",
    srcs = ["lib.cc"],
    hdrs = ["lib.h"],
    alwayslink = 1,
    #visibility = ["//visibility:public"],
)

windows_dll_library(
    name = "zero_win",
    srcs = ["lib.cc"],
    hdrs = ["lib.h"],
    # Define COMPILING_DLL to export symbols during compiling the DLL.
    # See lib.h
    copts = ["/DCOMPILING_DLL"],
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


cc_binary(
  name = "main_shared_windows",
  srcs = ["main.cc"],
  copts = ["/DCOMPILING_DLL"],
  deps = [":zero_win"],
  linkstatic = 0,
)


