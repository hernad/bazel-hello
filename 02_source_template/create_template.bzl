"""Generate a file using a template.

It is much more memory-efficient to use a template file than creating the whole
content during the analysis phase.
"""

# Label of the template file to use.
_TEMPLATE_CC = "//:template.cc"

def _hello_impl(ctx):
    ctx.actions.expand_template(
        template = ctx.file._template,
        output = ctx.outputs.source_file,
        substitutions = {
            "{FIRSTNAME}": ctx.attr.firstname,
        },
    )

create_template_rule = rule(
    implementation = _hello_impl,
    attrs = {
        "firstname": attr.string(mandatory = True),
        "_template": attr.label(
            default = Label(_TEMPLATE_CC),
            allow_single_file = True,
        ),
    },
    outputs = {"source_file": "%{name}.cc"},
)
