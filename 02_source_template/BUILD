load("@rules_cc//cc:defs.bzl", "cc_binary")
load("//:create_template.bzl", "create_template_rule")

# Generates a C++ source file that says "Hello John!".
create_template_rule(
    name = "template_01",
    firstname = "Ernad",
)

cc_binary(
    name = "hello_world",
    srcs = [":template_01"],
)
