load("@rules_cc//cc:defs.bzl", "cc_library", "cc_binary")

cc_library(
   name = "library_zero",
   srcs = ["lib.cc"],
   hdrs = ["lib.h"],
)

cc_binary(
   name = "two_plus_two",
   srcs = ["main.cc"],
   deps = [":library_zero"]
)
