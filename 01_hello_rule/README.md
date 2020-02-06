Run target `ground_zero`:


	bazel build :ground_zero


output:

<pre>
DEBUG: /home/hernad/bazel-hello/01_hello_rule/hello_rule.bzl:6:5: This rule does nothing. RULE 01
INFO: Analyzed target //:ground_zero (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //:ground_zero up-to-date (nothing to build)
INFO: Elapsed time: 0.049s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
</pre>