(ns ^{:author "Leeor Engel"}
  data-structures.mutable-stack
  (:require [data-structures.stack :refer :all])
  (:import (clojure.lang Atom)))

(defrecord Node [data next])

(defrecord SimpleStack [^Atom top size]
  Stack
  (stack-pop [this]
    (when (nil? @top)
      (throw (IllegalStateException. "stack empty!")))
    (let [popped-data (:data @top)
          ^Atom new-top-atom (:next @top)
          new-top-node (if (nil? new-top-atom) nil @new-top-atom)
          new-size (dec @size)]
      (reset! top new-top-node)
      (reset! size new-size)
      popped-data))

  (stack-peek [this]
    (when (nil? @top)
      (throw (IllegalStateException. "stack empty!")))
    (:data @top))

  (stack-push [this x]
    (let [new-top-node (->Node x (atom @top))
          new-size (inc @size)]
      (reset! top new-top-node)
      (reset! size new-size)))

  (stack-empty? [this]
    (nil? @top))

  (stack-size [this]
    @size))

(defn create-stack
  ([] (->SimpleStack (atom nil) (atom 0)))
  ([x]
   (->SimpleStack (atom (->Node x nil)) (atom 1))))