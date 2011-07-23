(ns leiningen.autodoc
  (:use [leiningen.compile :only [eval-in-project]]))

(defn autodoc
  "Build the autodoc for this project. Use lein autodoc help for all the options"
  [project & args]
  (eval-in-project project
    `(autodoc.autodoc/autodoc
      ~(merge
        (select-keys project [:name :description :source-path :root])
        (:autodoc project))
      '~args)
    nil nil
    `(require 'autodoc.autodoc)))
