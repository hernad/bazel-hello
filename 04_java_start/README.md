query:


    bazel query //...

output:

<pre> 
//src/main/java/ba/out/cmdline:Runner
//:ProjectRunner
Loading: 0 packages loaded
</pre>


run java:

    bazel run :ProjectRunner


output:

<pre>
INFO: Analyzed target //:ProjectRunner (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //:ProjectRunner up-to-date:
  bazel-bin/ProjectRunner.jar
  bazel-bin/ProjectRunner
INFO: Elapsed time: 0.056s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
INFO: Build completed successfully, 1 total action
Hi from out.ba!
</pre>


run java:

    bazel run //src/main/java/ba/out/cmdline:Runner

output:

<pre>
INFO: Analyzed target //src/main/java/ba/out/cmdline:Runner (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //src/main/java/ba/out/cmdline:Runner up-to-date:
  bazel-bin/src/main/java/ba/out/cmdline/Runner.jar
  bazel-bin/src/main/java/ba/out/cmdline/Runner
INFO: Elapsed time: 0.068s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
INFO: Build completed successfully, 1 total action
=========Runner start========
Hi from out.ba!
</pre>