(ns data-structures.stack
  (:import (clojure.lang Atom)))

(defprotocol Stack
  (stack-pop [this])
  (stack-peek [this])
  (stack-push [this x])
  (stack-empty? [this]))

(defrecord Node [data next])

(defrecord SimpleStack [^Atom top]
  Stack
  (stack-pop [this]
    (when (nil? @top)
      (throw (IllegalStateException. "stack empty!")))
    (let [popped-data (:data @top)
          ^Atom new-top-atom (:next @top)
          new-top-node (if (nil? new-top-atom) nil @new-top-atom)]
      (reset! top new-top-node)
      popped-data))

  (stack-peek [this]
    (when (nil? @top)
      (throw (IllegalStateException. "stack empty!")))
    (:data @top))

  (stack-push [this x]
    (let [new-top-node (->Node x (atom @top))]
      (reset! top new-top-node)))

  (stack-empty? [this]
    (nil? @top)))

(defn create-stack [x]
  (->SimpleStack (atom (->Node x nil))))