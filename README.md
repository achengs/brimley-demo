# Brimley Demo

This is a terminal application demo for
[Brimley](https://github.com/achengs/brimley)

To run the demo, do these steps:
```
git clone https://github.com/achengs/brimley-demo.git
cd brimley-demo
clj -X brimley-demo.core/run -m brimley-demo.edn
```

Check the following for more information:
1. The readme for [Brimley](https://github.com/achengs/brimley)
1. Comments in `brimley-demo.edn`
1. Comments in `src/brimley_demo/core.clj`
1. While running the demo,
    1. at the top level, hit `s` and `Enter` to show some info
    1. at any path in the menu tree, hit `!` and `Enter` to pretty-print the context atom
