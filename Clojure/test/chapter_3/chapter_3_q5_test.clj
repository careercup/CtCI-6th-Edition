(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q5-test
  (:require [clojure.test :refer :all]
            [data-structures.stack :refer :all]
            [data-structures.persistent-stack :refer :all]
            [chapter-3.chapter-3-q5 :refer :all]))

(deftest sort-stack-test

  (testing "Already sorted"
    (let [stack (create-stack '(1 2 3 4))]
      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-peek sorted)))
        (is (= (create-stack (list 2 3 4)) (stack-pop sorted))))))

  (testing "Basic sort"
    (let [stack (create-stack '(3 1 4 2))]
      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-peek sorted)))
        (is (= (create-stack (list 2 3 4)) (stack-pop sorted))))))

  (testing "Reverse order"
    (let [stack (create-stack '(8 7 6 5 4 3 2 1))]
      (let [sorted (sort-stack stack)]
        (is (= 1 (stack-peek sorted)))
        (is (= (create-stack (list 2 3 4 5 6 7 8)) (stack-pop sorted))))))

  (testing "Basic sort"
    (let [stack (create-stack '(81 2 25 26 15 34 6))]
      (let [sorted (sort-stack stack)]
        (is (= 2 (stack-peek sorted)))
        (is (= (create-stack (list 6 15 25 26 34 81)) (stack-pop sorted)))))))
