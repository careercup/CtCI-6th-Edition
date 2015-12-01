(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q4-test
  (:require [clojure.test :refer :all]
            [data-structures.mutable-linked-list :refer :all]
            [chapter-2.chapter-2-q4 :refer :all]))

(deftest partition-no-buffer-test
  (let [actual (partition-list-no-buffer (create-linked-list 2) 2)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 2) 1)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 2) 3)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 4 2) 3)
        expected (create-linked-list 2 4)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 10 6 2) 5)
        expected (create-linked-list 2 10 6)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 3 5 8 5 10 2 1) 5)
        expected (create-linked-list 3 2 1 5 10 8 5)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 3 5 8 5 10 2 1) 3)
        expected (create-linked-list 2 1 3 10 5 5 8)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list-no-buffer (create-linked-list 3 5 8 5 10 2 1) 4)
        expected (create-linked-list 3 2 1 5 10 8 5)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual))))))


(deftest partition-test
  (let [actual (partition-list (create-linked-list 2) 2)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 2) 1)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 2) 3)
        expected (create-linked-list 2)]
    (is (lists-eq? expected actual) (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 4 2) 3)
        expected (create-linked-list 2 4)]
    (is (lists-eq? expected actual)
        (str "Expected: " (to-vec (:head expected)) "\nActual: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 10 6 2) 5)
        expected (create-linked-list 2 10 6)]
    (is (lists-eq? expected actual)
        (str "Actual Was: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 3 5 8 5 10 2 1) 5)
        expected (create-linked-list 3 2 1 5 8 5 10)]
    (is (lists-eq? expected actual)
        (str "Expected: " (to-vec (:head expected)) "\nActual: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 3 5 8 5 10 2 1) 3)
        expected (create-linked-list 2 1 3 5 8 5 10)]
    (is (lists-eq? expected actual)
        (str "Expected: " (to-vec (:head expected)) "\nActual: " (to-vec (:head actual)))))

  (let [actual (partition-list (create-linked-list 3 5 8 5 10 2 1) 4)
        expected (create-linked-list 3 2 1 5 8 5 10)]
    (is (lists-eq? expected actual)
        (str "Expected: " (to-vec (:head expected)) "\nActual: " (to-vec (:head actual))))))