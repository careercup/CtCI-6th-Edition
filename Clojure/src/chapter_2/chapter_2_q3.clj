(ns chapter-2.chapter-2-q3
  (:require
    [data-structures.linked-list :refer :all])
  (:import (clojure.lang Atom)))

(defn remove-middle-node [^Atom node]
  (let [next (:next @node)]
    (reset! node @next)))