"""Minimalist example of a rule that does nothing."""

def _empty_impl(ctx):
    # This function is called when the rule is analyzed.
    # You may use print for debugging.
    print("This rule does nothing. RULE 01")

rule_number_one = rule(implementation = _empty_impl)
