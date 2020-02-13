
load("@rules_android//android:rules.bzl", "android_binary")

android_binary(
    name = "main",
    custom_package = "ba.out.mobile.app1",
    manifest = "AndroidManifest.xml",
    srcs = glob(["java/**"]),
    resource_files = glob(["res/**"]),
    visibility = ["//visibility:public"],
    deps = [
        #"//Lib-Android",
	    #"@maven//:com_jakewharton_timber_timber",
	    #"@maven//:com_android_support_appcompat_v7",
    ],
)




