(ns ^{:author "Leeor Engel"}
chapter-2.chapter-2-q5-test
  (:require [clojure.test :refer :all]
            [data-structures.linked-list :refer :all]
            [chapter-2.chapter-2-q5 :refer :all]))

(deftest sum-lists-test
  (is (= '(3) (sum-lists '(1) '(2))))
  (is (= '(1 2) (sum-lists '(9) '(3))))
  (is (= '(9 4 6) (sum-lists '(2 3) '(7 1 6))))
  (is (= '(2 1 9) (sum-lists '(7 1 6) '(5 9 2))))
  (is (= '(9 1 6) (sum-lists '(7 1 6) '(2))))
  (is (= '(6 1 7 5) (sum-lists '(7 1 6 5) '(9 9)))))

(deftest sum-lists-forward-concat-test
  (is (= '(3) (sum-lists-forward-concat '(1) '(2))))
  (is (= '(1 2) (sum-lists-forward-concat '(9) '(3))))
  (is (= '(6 4 9) (sum-lists-forward-concat '(3 2) '(6 1 7))))
  (is (= '(9 1 2) (sum-lists-forward-concat '(6 1 7) '(2 9 5))))
  (is (= '(6 1 9) (sum-lists-forward-concat '(6 1 7) '(2))))
  (is (= '(5 7 1 6) (sum-lists-forward-concat '(5 6 1 7) '(9 9)))))

(deftest sum-lists-forward-test
  (is (= '(3) (sum-lists-forward '(1) '(2))))
  (is (= '(1 2) (sum-lists-forward '(9) '(3))))
  (is (= '(6 4 9) (sum-lists-forward '(3 2) '(6 1 7))))
  (is (= '(9 1 2) (sum-lists-forward '(6 1 7) '(2 9 5))))
  (is (= '(6 1 9) (sum-lists-forward '(6 1 7) '(2))))
  (is (= '(5 7 1 6) (sum-lists-forward '(5 6 1 7) '(9 9))))
  (is (= '(1 9 9 8) (sum-lists-forward '(9 9 9) '(9 9 9)))))
