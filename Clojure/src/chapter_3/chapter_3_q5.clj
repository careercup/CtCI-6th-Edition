(ns chapter-3.chapter-3-q5
  (:require [data-structures.stack :refer :all])
  (:import (data_structures.stack SimpleStack)))

(defn- insert-in-sorted-position [x ^SimpleStack s ^SimpleStack t]
  (while (and (not (stack-empty? t)) (> x (stack-peek t)))
    (stack-push s (stack-pop t)))
  (stack-push t x))

(defn sort-stack [^SimpleStack stack]
  (if (>= 1 (stack-size stack))
    stack
    (let [temp (create-stack)]
      (loop [current (stack-pop stack)]
        (insert-in-sorted-position current stack temp)
        (if (stack-empty? stack)
          temp
          (recur (stack-pop stack)))))))