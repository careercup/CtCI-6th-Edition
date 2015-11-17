(ns chapter-3.chapter-3-q3
  (:require [data-structures.stack :refer :all]))

(defprotocol SetOfStacks
  (stack-set-pop [this])
  (stack-set-peek [this])
  (stack-set-push [this x])
  (stack-set-empty? [this])
  (stack-total-size [this])
  (stack-set-size [this]))

(defrecord StackOfStacks [top-pile threshold]
  SetOfStacks
  (stack-set-pop [this]
    (let [pile (stack-peek top-pile)
          popped (stack-pop pile)]
      (when (stack-empty? pile)
        (stack-pop top-pile))
      popped))

  (stack-set-peek [this]
    (stack-peek (stack-peek top-pile)))

  (stack-set-push [this x]
    (if (stack-empty? top-pile)
      (stack-push top-pile (create-stack x))
      (let [pile (stack-peek top-pile)]
        (if (= threshold (stack-size pile))
          (stack-push top-pile (create-stack x))
          (stack-push pile x)))))

  (stack-set-empty? [this]
    (stack-empty? top-pile))

  (stack-total-size [this]
    (if (stack-empty? top-pile)
      0
      (let [top-pile-size (stack-size (stack-peek top-pile))
            all-except-top-pile (- (stack-set-size this) top-pile-size)]
        (+ top-pile-size (* all-except-top-pile threshold)))))

  (stack-set-size [this]
    (stack-size top-pile)))

(defn create-stack-set [x threshold]
  (->StackOfStacks (create-stack (create-stack x)) threshold))