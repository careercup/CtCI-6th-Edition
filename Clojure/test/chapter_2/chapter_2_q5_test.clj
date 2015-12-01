(ns chapter-2.chapter-2-q5-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]
            [chapter-2.chapter-2-q5 :refer :all]))

(deftest sum-lists-test
  (is (lists-eq?
        (create-linked-list 3)
        (sum-lists (create-linked-list 1) (create-linked-list 2))))
  (is (lists-eq?
        (create-linked-list 2 1)
        (sum-lists (create-linked-list 9) (create-linked-list 3))))
  (is (lists-eq?
        (create-linked-list 9 4 6)
        (sum-lists (create-linked-list 2 3) (create-linked-list 7 1 6))))
  (is (lists-eq?
        (create-linked-list 2 1 9)
        (sum-lists (create-linked-list 7 1 6) (create-linked-list 5 9 2))))
  (is (lists-eq?
        (create-linked-list 9 1 6)
        (sum-lists (create-linked-list 7 1 6) (create-linked-list 2))))
  (is (lists-eq?
        (create-linked-list 8 9 9 1)
        (sum-lists (create-linked-list 9 9 9) (create-linked-list 9 9 9))))
  (is (lists-eq?
        (create-linked-list 6 1 7 5)
        (sum-lists (create-linked-list 7 1 6 5) (create-linked-list 9 9)))))

(deftest sum-lists-forward-concat-test
  (is (lists-eq?
        (create-linked-list 3)
        (sum-lists-forward-concat (create-linked-list 1) (create-linked-list 2))))
  (is (lists-eq?
        (create-linked-list 1 2)
        (sum-lists-forward-concat (create-linked-list 9) (create-linked-list 3))))
  (is (lists-eq?
        (create-linked-list 6 4 9)
        (sum-lists-forward-concat (create-linked-list 3 2) (create-linked-list 6 1 7))))
  (is (lists-eq?
        (create-linked-list 9 1 2)
        (sum-lists-forward-concat (create-linked-list 6 1 7) (create-linked-list 2 9 5))))
  (is (lists-eq?
        (create-linked-list 6 1 9)
        (sum-lists-forward-concat (create-linked-list 6 1 7) (create-linked-list 2))))
  (is (lists-eq?
        (create-linked-list 5 7 1 6)
        (sum-lists-forward-concat (create-linked-list 5 6 1 7) (create-linked-list 9 9)))))

(deftest sum-lists-forward-test
  (let [expected (create-linked-list 3)
        actual (sum-lists-forward (create-linked-list 1) (create-linked-list 2))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 1 2)
        actual (sum-lists-forward (create-linked-list 9) (create-linked-list 3))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 6 4 9)
        actual (sum-lists-forward (create-linked-list 3 2) (create-linked-list 6 1 7))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 9 1 2)
        actual (sum-lists-forward (create-linked-list 2 9 5) (create-linked-list 6 1 7))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 6 1 9)
        actual (sum-lists-forward (create-linked-list 2) (create-linked-list 6 1 7))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 5 7 1 6)
        actual (sum-lists-forward (create-linked-list 5 6 1 7) (create-linked-list 9 9))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual))))

  (let [expected (create-linked-list 1 9 9 8)
        actual (sum-lists-forward (create-linked-list 9 9 9) (create-linked-list 9 9 9))]
    (is (lists-eq? expected actual)
        (str "Expected: " (list-to-vec expected) "\nActual: " (list-to-vec actual)))))