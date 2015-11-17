(ns chapter-3.chapter-3-q4-test
  (:require [clojure.test :refer :all]
            [data-structures.stack :refer :all]
            [chapter-3.chapter-3-q4 :refer :all]))


(deftest my-queue-test

  (testing "all pushes, then pops"
    (let [q (create-my-queue 1)]
      (is (not (queue-empty? q)))
      (enqueue q 2)
      (enqueue q 3)
      (is (= 3 (queue-size q)))
      (is (= 1 (dequeue q)))
      (is (= 2 (dequeue q)))
      (is (= 3 (dequeue q)))
      (is (queue-empty? q))))

  (testing "push/pop, push/pop, ..."
    (let [q (create-my-queue 1)]
      (is (= 1 (dequeue q)))
      (enqueue q 2)
      (is (= 2 (dequeue q)))
      (enqueue q 3)
      (is (= 3 (dequeue q)))
      (enqueue q 4)
      (is (= 4 (dequeue q)))
      (is (queue-empty? q))))

  (testing "irregular pushes/pops"
    (let [q (create-my-queue 1)]
      (enqueue q 2)
      (enqueue q 3)
      (enqueue q 4)
      (is (= 1 (dequeue q)))
      (enqueue q 5)
      (enqueue q 6)
      (enqueue q 7)
      (is (= 2 (dequeue q)))
      (enqueue q 8)
      (enqueue q 9)
      (enqueue q 10)
      (is (= 3 (dequeue q)))
      (is (= 4 (dequeue q)))
      (is (= 5 (dequeue q)))
      (enqueue q 11)
      (is (= 6 (dequeue q)))
      (is (= 7 (dequeue q)))
      (is (= 8 (dequeue q)))
      (is (= 9 (dequeue q)))
      (is (= 10 (dequeue q)))
      (enqueue q 12)
      (enqueue q 13)
      (is (= 11 (dequeue q)))
      (is (= 12 (dequeue q)))
      (is (= 13 (dequeue q)))
      (is (queue-empty? q))
      )))
