(ns ^{:author "Leeor Engel"}
chapter-2.chapter-2-q4-test
  (:require [clojure.test :refer :all]
            [chapter-2.chapter-2-q4 :refer :all]))

(deftest partition-test
  (is (= '(2) (partition-list '(2) 2)))
  (is (= '(2) (partition-list '(2) 1)))
  (is (= '(2) (partition-list '(2) 3)))
  (is (= '(2 4) (partition-list '(4 2) 3)))
  (is (= '(2 6 10) (partition-list '(10 6 2) 5)))
  (is (= '(1 2 3 10 5 8 5) (partition-list '(3 5 8 5 10 2 1) 5)))
  (is (= '(1 2 3 10 5 8 5) (partition-list '(3 5 8 5 10 2 1) 4))))