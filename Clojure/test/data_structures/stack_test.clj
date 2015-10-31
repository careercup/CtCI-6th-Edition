(ns data-structures.stack-test
  (:require [clojure.test :refer :all]
            [data-structures.stack :refer :all]))

(deftest stacks-empty-test
  (testing "1-2 nodes"
    (is (not (stack-empty? (create-stack 5))))

    (let [stack (create-stack 5)]
      (is (not (stack-empty? stack)))
      (stack-push stack 6)

      (is (= 6 (stack-peek stack)))
      (is (= 6 (stack-pop stack)))
      (is (= 5 (stack-pop stack)))
      (is (stack-empty? stack))
      (is (thrown? IllegalStateException (stack-pop stack)))
      (stack-push stack 7)
      (is (= 7 (stack-pop stack)))
      (is (stack-empty? stack)))

    (testing "many nodes"
      (let [stack (create-stack 1)]
        (stack-push stack 2)
        (stack-push stack 3)
        (stack-push stack 4)
        (stack-push stack 5)

        (is (= 5 (stack-peek stack)))
        (is (= 5 (stack-pop stack)))
        (is (= 4 (stack-peek stack)))
        (is (= 4 (stack-pop stack)))
        (is (= 3 (stack-peek stack)))
        (is (= 3 (stack-pop stack)))
        (is (= 2 (stack-peek stack)))
        (is (= 2 (stack-pop stack)))
        (is (= 1 (stack-peek stack)))
        (is (= 1 (stack-pop stack)))
        (is (stack-empty? stack))
        (is (thrown? IllegalStateException (stack-pop stack)))
        (stack-push stack 7)
        (is (= 7 (stack-pop stack)))
        (is (stack-empty? stack))))))