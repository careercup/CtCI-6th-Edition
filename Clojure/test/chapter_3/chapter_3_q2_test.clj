(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q2-test
  (:require [clojure.test :refer :all]
            [chapter-3.chapter-3-q2 :refer :all]))

(deftest stacks-empty-test

  (testing "ascending order"
    (let [stack (create-min-stack 1)]
      (is (= 1 (get-min stack)))
      (min-stack-push stack 2)
      (is (= 1 (get-min stack)))
      (min-stack-push stack 3)
      (is (= 1 (get-min stack)))
      (min-stack-push stack 4)
      (is (= 1 (get-min stack)))
      (min-stack-push stack 5)
      (is (= 1 (get-min stack)))

      (is (= 5 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 4 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 3 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 2 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 1 (min-stack-pop stack)))
      (is (thrown? IllegalStateException (get-min stack)))))

  (testing "descending order"
    (let [stack (create-min-stack 5)]
      (is (= 5 (get-min stack)))
      (min-stack-push stack 4)
      (is (= 4 (get-min stack)))
      (min-stack-push stack 3)
      (is (= 3 (get-min stack)))
      (min-stack-push stack 2)
      (is (= 2 (get-min stack)))
      (min-stack-push stack 1)
      (is (= 1 (get-min stack)))

      (is (= 1 (min-stack-pop stack)))
      (is (= 2 (get-min stack)))
      (is (= 2 (min-stack-pop stack)))
      (is (= 3 (get-min stack)))
      (is (= 3 (min-stack-pop stack)))
      (is (= 4 (get-min stack)))
      (is (= 4 (min-stack-pop stack)))
      (is (= 5 (get-min stack)))
      (is (= 5 (min-stack-pop stack)))
      (is (thrown? IllegalStateException (get-min stack)))))

  (testing "out of order min"
    (let [stack (create-min-stack 4)]
      (is (= 4 (get-min stack)))
      (min-stack-push stack 1)
      (is (= 1 (get-min stack)))
      (min-stack-push stack 2)
      (is (= 1 (get-min stack)))
      (min-stack-push stack 0)
      (is (= 0 (get-min stack)))
      (min-stack-push stack 3)
      (is (= 0 (get-min stack)))

      (is (= 3 (min-stack-pop stack)))
      (is (= 0 (get-min stack)))
      (is (= 0 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 2 (min-stack-pop stack)))
      (is (= 1 (get-min stack)))
      (is (= 1 (min-stack-pop stack)))
      (is (= 4 (get-min stack)))

      ;; push on more stuff
      (min-stack-push stack 5)
      (is (= 4 (get-min stack)))
      (min-stack-push stack 3)
      (min-stack-push stack 6)
      (is (= 3 (get-min stack)))
      (is (= 6 (min-stack-pop stack)))
      (is (= 3 (get-min stack))))))