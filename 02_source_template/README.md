build hello_world c binary:

  bazel build :hello_world

<pre>
Starting local Bazel server and connecting to it...
INFO: Analyzed target //:hello_world (13 packages loaded, 48 targets configured).
INFO: Found 1 target...
Target //:hello_world up-to-date:
  bazel-bin/hello_world
INFO: Elapsed time: 2.643s, Critical Path: 0.23s
INFO: 2 processes: 2 linux-sandbox.
INFO: Build completed successfully, 7 total actions
</pre>


run binary:

  bazel run :hello_world

<pre>
INFO: Analyzed target //:hello_world (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //:hello_world up-to-date:
  bazel-bin/hello_world
INFO: Elapsed time: 0.104s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
INFO: Build completed successfully, 1 total action
Hello Ernad!
</pre>
