(ns ^{:author "Leeor Engel"}
  data-structures.persistent-stack
  (:require [data-structures.stack :refer :all]))

(defrecord PersistentStack [top]
  Stack
  (stack-pop [this]
    (when (empty? top) (throw (IllegalStateException. "stack empty!")))
    (->PersistentStack (pop top)))

  (stack-peek [this]
    (when (empty? top) (throw (IllegalStateException. "stack empty!")))
    (peek top))

  (stack-push [this x]
    (->PersistentStack (conj top x)))

  (stack-empty? [this]
    (empty? top))

  (stack-size [this]
    (count top)))

(defn create-stack
  ([] (->PersistentStack '()))
  ([x] (if (list? x)
         (->PersistentStack x)
         (->PersistentStack (list x)))))