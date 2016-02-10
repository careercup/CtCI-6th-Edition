(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q5
  (:require [data-structures.stack :refer :all]
            [data-structures.persistent-stack :refer :all]))

(defn- insert-in-sorted-position [x s t]
  (loop [new-s s
         new-t t]
    (if (and (not (stack-empty? new-t)) (> x (stack-peek new-t)))
      (recur (stack-push new-s (stack-peek new-t))
             (stack-pop new-t))
      [new-s (stack-push new-t x)])))

(defn sort-stack [stack]
  (if (>= 1 (stack-size stack))
    stack
    (loop [current (stack-peek stack)
           s (stack-pop stack)
           t (create-stack)]
      (let [[new-s new-t] (insert-in-sorted-position current s t)]
        (if (stack-empty? new-s)
          new-t
          (recur (stack-peek new-s)
                 (stack-pop new-s)
                 new-t))))))