(ns chapter-3.chapter-3-q5-test
  (:require [clojure.test :refer :all]
            [data-structures.stack :refer :all]
            [chapter-3.chapter-3-q5 :refer :all]))


(deftest sort-stack-test

  (testing "Already sorted"
    (let [stack (create-stack 4)]
      (stack-push stack 3)
      (stack-push stack 2)
      (stack-push stack 1)

      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-pop sorted)))
        (is (= 2 (stack-pop sorted)))
        (is (= 3 (stack-pop sorted)))
        (is (= 4 (stack-pop sorted))))))

  (testing "Basic sort"
    (let [stack (create-stack 3)]
      (stack-push stack 1)
      (stack-push stack 4)
      (stack-push stack 2)

      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-pop sorted)))
        (is (= 2 (stack-pop sorted)))
        (is (= 3 (stack-pop sorted)))
        (is (= 4 (stack-pop sorted))))))

  (testing "Reverse order"
    (let [stack (create-stack 1)]
      (stack-push stack 2)
      (stack-push stack 3)
      (stack-push stack 4)
      (stack-push stack 5)
      (stack-push stack 6)
      (stack-push stack 7)
      (stack-push stack 8)

      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-pop sorted)))
        (is (= 2 (stack-pop sorted)))
        (is (= 3 (stack-pop sorted)))
        (is (= 4 (stack-pop sorted)))
        (is (= 5 (stack-pop sorted)))
        (is (= 6 (stack-pop sorted)))
        (is (= 7 (stack-pop sorted)))
        (is (= 8 (stack-pop sorted))))))

  (testing "Basic sort"
    (let [stack (create-stack 6)]
      (stack-push stack 34)
      (stack-push stack 15)
      (stack-push stack 26)
      (stack-push stack 25)
      (stack-push stack 2)
      (stack-push stack 81)

      (let [sorted (sort-stack stack)]
        (is (= 2 (stack-pop sorted)))
        (is (= 6 (stack-pop sorted)))
        (is (= 15 (stack-pop sorted)))
        (is (= 25 (stack-pop sorted)))
        (is (= 26 (stack-pop sorted)))
        (is (= 34 (stack-pop sorted)))
        (is (= 81 (stack-pop sorted)))))))
