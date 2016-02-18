(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q7
  (:require [data-structures.graph :refer :all]))

(defn build-order [projects dependencies]
  (let [with-deps (reduce-kv (fn [m k v]
                               (assoc m k (into [] (map second v)))) {} (group-by first dependencies))
        no-deps (reduce (fn [m p]
                          (assoc m p [])) {} projects)
        build-graph (merge no-deps with-deps)]
    (topological-sort build-graph)))