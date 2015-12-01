(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q4-test
  (:require [clojure.test :refer :all]
            [data-structures.persistent-stack :refer :all]
            [chapter-3.chapter-3-q4 :refer :all]))


(deftest my-queue-test

  (testing "all pushes, then pops"
    (let [q (create-my-queue 1)]
      (is (not (queue-empty? q)))
      (let [q2 (enqueue q 2)
            q3 (enqueue q2 3)]
        (is (= 3 (queue-size q3)))
        (is (= 1 (queue-peek q3)))
        (is (= (->MyQueue (create-stack)
                          (create-stack '(2 3))) (dequeue q3)))
        (is (= (->MyQueue (create-stack)
                          (create-stack '(3))) (dequeue (dequeue q3))))
        (is (queue-empty? (dequeue (dequeue (dequeue q3))))))))

  (testing "irregular pushes/pops"
    (let [q (create-my-queue 1)
          q2 (enqueue q 2)
          q3 (enqueue q2 3)
          q4 (enqueue q3 4)
          q5 (dequeue q4)
          q6 (enqueue q5 5)
          q7 (enqueue q6 6)
          q8 (enqueue q7 7)
          q9 (dequeue q8)
          q10 (enqueue q9 8)
          q11 (enqueue q10 9)
          q12 (enqueue q11 10)
          q13 (dequeue q12)
          q14 (dequeue q13)
          q15 (dequeue q14)]
      (is (= (->MyQueue (create-stack '())
                        (create-stack '(2 3 4))) q5))
      (is (= (->MyQueue (create-stack '(7 6 5))
                        (create-stack '(2 3 4))) q8))
      (is (= (->MyQueue (create-stack '(7 6 5))
                        (create-stack '(3 4))) q9))
      (is (= (->MyQueue (create-stack '(10 9 8 7 6 5))
                        (create-stack '(3 4))) q12))
      (is (= (->MyQueue (create-stack '())
                        (create-stack '(6 7 8 9 10))) q15)))))
