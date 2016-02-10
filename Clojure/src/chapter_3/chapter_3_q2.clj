(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q2
  (:require [data-structures.stack :refer :all]
            [data-structures.mutable-stack :refer :all]))

;; Assumptions:
;;
;; 1. no duplicates
;; 2. min is a peek not a pop
;;

(defprotocol StackWithMin
  (min-stack-pop [this])
  (min-stack-peek [this])
  (min-stack-push [this x])
  (min-stack-empty? [this])
  (get-min [this]))

(defrecord MinStack [stack min-stack]
  StackWithMin
  (min-stack-pop [this]
    (when (= (stack-peek stack) (stack-peek min-stack))
      (stack-pop min-stack))
    (stack-pop stack))

  (min-stack-peek [this]
    (stack-peek stack))

  (min-stack-push [this x]
    (stack-push stack x)
    (when (or (stack-empty? stack) (< x (stack-peek min-stack)))
      (stack-push min-stack x)))

  (min-stack-empty? [this]
    (stack-empty? stack))

  (get-min [this]
    (stack-peek min-stack)))

(defn create-min-stack [x]
  (->MinStack (create-stack x) (create-stack x)))