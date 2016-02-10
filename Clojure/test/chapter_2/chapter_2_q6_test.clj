(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q6-test
  (:require [clojure.test :refer :all]
            [data-structures.linked-list :refer :all]
            [chapter-2.chapter-2-q6 :refer :all]))

(deftest palindrome-test
  (is (palindrome? (create-linked-list [1])))
  (is (palindrome? (create-linked-list [1 1])))
  (is (palindrome? (create-linked-list [1 2 1])))
  (is (palindrome? (create-linked-list [1 2 2 1])))
  (is (not (palindrome? (create-linked-list [1 2 1 4]))))
  (is (not (palindrome? (create-linked-list [1 2 1 4 1 2 1 1])))))

