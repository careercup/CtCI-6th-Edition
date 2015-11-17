(ns chapter-3.chapter-3-q4
  (:require [data-structures.stack :refer :all]))


(defprotocol Queue
  (enqueue [this x])
  (dequeue [this])
  (queue-empty? [this])
  (queue-size [this]))

(defn- pop-all [from-stack to-stack]
  "Pops all elements on from-stack onto to-stack. Popped elements will be in reverse order on to-stack
  after the operation has completed."
  (dotimes [n (stack-size from-stack)]
    (stack-push to-stack (stack-pop from-stack))))

(defrecord MyQueue [stack-ordered queue-ordered]
  Queue
  (enqueue [this x]
    (stack-push stack-ordered x))

  (dequeue [this]
    ;; check if there are any elements on queue-ordered
    (if (stack-empty? queue-ordered)
      (do (pop-all stack-ordered queue-ordered)
          (stack-pop queue-ordered))
      (stack-pop queue-ordered))
    )

  (queue-empty? [this]
    (and (stack-empty? stack-ordered) (stack-empty? queue-ordered)))

  (queue-size [this]
    (+ (stack-size stack-ordered) (stack-size queue-ordered))))

(defn create-my-queue [x]
  (->MyQueue (create-stack x) (create-stack)))

