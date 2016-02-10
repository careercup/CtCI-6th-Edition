(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q3
  (:require [data-structures.stack :refer :all]
            [data-structures.persistent-stack :refer :all])
  (:import (data_structures.persistent_stack PersistentStack)))

(defprotocol SetOfStacks
  (stack-set-pop [this])
  (stack-set-peek [this])
  (stack-set-push [this x])
  (stack-set-empty? [this])
  (stack-set-total-size [this])
  (stack-set-size [this]))

(declare create-stack-set)

(defrecord StackOfStacks [piles threshold]
  SetOfStacks
  (stack-set-pop [this]
    (let [top-pile (stack-peek piles)
          popped-pile (stack-pop top-pile)
          piles-with-top-popped (stack-pop piles)]
      (if (stack-empty? popped-pile)
        (create-stack-set piles-with-top-popped threshold)
        (->StackOfStacks (stack-push piles-with-top-popped popped-pile) threshold))))

  (stack-set-peek [this]
    (stack-peek (stack-peek piles)))

  (stack-set-push [this x]
    (let [new-pile-with-x (create-stack x)]
      (if (stack-empty? piles)
        (->StackOfStacks (stack-push piles new-pile-with-x) threshold)
        (let [top-pile (stack-peek piles)]
          (if (= threshold (stack-size top-pile))
            (->StackOfStacks (stack-push piles new-pile-with-x) threshold)
            (let [pile-with-x (stack-push top-pile x)
                  piles-without-top-pile (stack-pop piles)]
              (->StackOfStacks (stack-push piles-without-top-pile pile-with-x) threshold)))))))

  (stack-set-empty? [this]
    (stack-empty? piles))

  (stack-set-total-size [this]
    (if (stack-empty? piles)
      0
      (let [top-pile-size (stack-size (stack-peek piles))
            all-except-top-pile (- (stack-set-size this) top-pile-size)]
        (+ top-pile-size (* all-except-top-pile threshold)))))

  (stack-set-size [this]
    (stack-size piles)))

(defn create-stack-set [x threshold]
  (if (instance? PersistentStack x)
    (->StackOfStacks x threshold)
    (->StackOfStacks (create-stack (create-stack x)) threshold)))