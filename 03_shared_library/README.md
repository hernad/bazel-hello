* RUN

build two_plus_two binary:

	bazel run :two_plus_two

output:

<pre>
INFO: Analyzed target //:two_plus_two (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //:two_plus_two up-to-date:
  bazel-bin/two_plus_two
INFO: Elapsed time: 0.051s, Critical Path: 0.00s
INFO: 0 processes.
INFO: Build completed successfully, 1 total action
INFO: Build completed successfully, 1 total action
symbol01

2+2=4
</pre>


* DEBUG


	cat bazel-out/k8-fastbuild/bin/two_plus_two-2.params


<pre>
-o
bazel-out/k8-fastbuild/bin/two_plus_two
-Wl,-S
-fuse-ld=gold
-Wl,-no-as-needed
-Wl,-z,relro,-z,now
-B/bin
-pass-exit-codes
-lstdc++
-lm
-Wl,--start-lib
bazel-out/k8-fastbuild/bin/_objs/library_zero/lib.pic.o
-Wl,--end-lib
</pre>


`-fuse-ld=gold` - https://en.wikipedia.org/wiki/Gold_(linker)

