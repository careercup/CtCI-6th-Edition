(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q4
  (:require [data-structures.stack :refer :all]
            [data-structures.persistent-stack :refer :all]))


(defprotocol Queue
  (enqueue [this x])
  (dequeue [this])
  (queue-peek [this])
  (queue-empty? [this])
  (queue-size [this]))


(defn- pop-all [from-stack to-stack]
  "Pops all elements on from-stack onto to-stack. Popped elements will be in reverse order on to-stack
  after the operation has completed."
  (loop [from from-stack
         to to-stack]
    (if (stack-empty? from)
      [from to]
      (let [x (stack-peek from)]
        (recur (stack-pop from)
               (stack-push to x))))))

(defrecord MyQueue [stack-ordered queue-ordered]
  Queue
  (enqueue [this x]
    (->MyQueue (stack-push stack-ordered x) queue-ordered))

  (dequeue [this]
    ;; check if there are any elements on queue-ordered
    (if (stack-empty? queue-ordered)
      (let [[stack-ordered queue-ordered] (pop-all stack-ordered queue-ordered)
            dequeued (->MyQueue stack-ordered queue-ordered)]
        (->MyQueue (:stack-ordered dequeued) (stack-pop (:queue-ordered dequeued))))
      (->MyQueue (:stack-ordered this) (stack-pop (:queue-ordered this)))))

  (queue-peek [this]
    (if (stack-empty? queue-ordered)
      (let [[stack-ordered queue-ordered] (pop-all stack-ordered queue-ordered)
            dequeued (->MyQueue stack-ordered queue-ordered)]
        (stack-peek (:queue-ordered dequeued)))
      (stack-peek (:queue-ordered this))))

  (queue-empty? [this]
    (and (stack-empty? stack-ordered) (stack-empty? queue-ordered)))

  (queue-size [this]
    (+ (stack-size stack-ordered) (stack-size queue-ordered))))

(defn create-my-queue [x]
  (->MyQueue (create-stack x) (create-stack)))

