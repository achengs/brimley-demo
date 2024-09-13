# Brimley Demo

This is a terminal application demo for
[Brimley](https://github.com/achengs/brimley)

To run the demo, do these steps:
```
git clone https://github.com/achengs/brimley-demo.git
cd brimley-demo
clj -X brimley-demo.core/run -m brimley-demo.edn
```

To peek under the hood while running the demo, hit `!` and `Enter`
to pretty-print the context atom.

See the comments in `brimley-demo.edn`
and `src/brimley_demo/core.clj`
as well as the readme for
[Brimley](https://github.com/achengs/brimley)
for more information.
