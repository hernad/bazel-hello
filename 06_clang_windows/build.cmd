set BAZEL_LLVM=c:\LLVM
..\..\bazel build //:hello_clang --incompatible_enable_cc_toolchain_resolution --subcommands
