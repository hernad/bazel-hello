query:


    bazel query //...

output:

<pre> 
//src/main/java/ba/out/cmdline:Runner
//:java_greet
//:java_lib_04
Loading: 0 packages loaded
</pre>


run java:

    bazel run :java_greet


output:

<pre>
INFO: Analyzed target //:java_greet (0 packages loaded, 1 target configured).
INFO: Found 1 target...
Target //:java_greet up-to-date:
  bazel-bin/java_greet.jar
  bazel-bin/java_greet
INFO: Elapsed time: 0.122s, Critical Path: 0.05s
INFO: 1 process: 1 worker.
INFO: Build completed successfully, 5 total actions
INFO: Build completed successfully, 5 total actions
1
0
-1
Hi from out.ba!
is windows:false
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
INFO: Elapsed time: 0.043s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
INFO: Build completed successfully, 1 total action
=========Runner start========
1
0
-1
Hi from out.ba!
is windows:false
</pre>