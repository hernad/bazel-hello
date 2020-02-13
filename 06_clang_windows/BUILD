load("@rules_cc//cc:defs.bzl", "cc_binary")

platform(
      name = "x64_windows-clang-cl",
      constraint_values = [
          "@platforms//cpu:x86_64",
          "@platforms//os:windows",
          "@bazel_tools//tools/cpp:clang-cl",
      ],
)

cc_binary(
    name = "hello_clang",
    srcs = ["main.cc"],
)
