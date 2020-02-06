
def windows_dll_library(
        name,
        srcs = [],
        hdrs = [],
        visibility = None,
        **kwargs):
    """A simple windows_dll_library rule for builing a DLL Windows."""
    dll_name = name + ".dll"
    import_lib_name = name + "_import_lib"
    import_target_name = name + "_dll_import"

    # Build the shared library
    native.cc_binary(
        name = dll_name,
        srcs = srcs + hdrs,
        linkshared = 1,
        **kwargs
    )

    # Get the import library for the dll
    native.filegroup(
        name = import_lib_name,
        srcs = [":" + dll_name],
        output_group = "interface_library",
    )

    # Because we cannot directly depend on cc_binary from other cc rules in deps attribute,
    # we use cc_import as a bridge to depend on the dll.
    native.cc_import(
        name = import_target_name,
        interface_library = ":" + import_lib_name,
        shared_library = ":" + dll_name,
    )

    # Create a new cc_library to also include the headers needed for the shared library
    native.cc_library(
        name = name,
        hdrs = hdrs,
        visibility = visibility,
        deps = [
            ":" + import_target_name,
        ],
    )