(defproject cljs-graphics "1.0.0"
  :description "A Google Closure graphics demo"
  :plugins [[lein-cljsbuild "0.3.0"]]
  :dependencies [[org.clojure/clojure "1.4.0"]]  
  :cljsbuild {
    :builds [{
        ; The path to the top-level ClojureScript source directory:
        :source-paths ["src-cljs"]
        ; The standard ClojureScript compiler options:
        ; (See the ClojureScript compiler documentation for details.)
        :compiler {
          :output-to "target/main.js"
          :optimizations :whitespace
          :pretty-print true}}]})

