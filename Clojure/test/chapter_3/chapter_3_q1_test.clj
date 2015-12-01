(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q1-test
  (:require [clojure.test :refer :all]
            [chapter-3.chapter-3-q1 :refer :all]))

(deftest stacks-empty-test
  (is (thrown? IllegalArgumentException (stack-empty? (create-three-stacks 5) 0)))
  (is (stack-empty? (create-three-stacks 5) 1))
  (is (stack-empty? (create-three-stacks 5) 2))
  (is (stack-empty? (create-three-stacks 5) 3))
  (is (thrown? IllegalArgumentException (stack-empty? (create-three-stacks 5) 4)))

  (let [three-stacks (create-three-stacks 5)]
    (stack-push three-stacks 1 10)
    (is (not (stack-empty? three-stacks 1)))
    (is (stack-empty? three-stacks 2))
    (is (stack-empty? three-stacks 3)))

  (let [three-stacks (create-three-stacks 5)]
    (is (stack-empty? three-stacks 1))
    (stack-push three-stacks 1 10)
    (is (not (stack-empty? three-stacks 1)))
    (stack-peek three-stacks 1)
    (is (not (stack-empty? three-stacks 1)))
    (stack-pop three-stacks 1)
    (is (stack-empty? three-stacks 1))))

(deftest stacks-push-pop-tests
  (testing "single stack"
    (let [three-stacks (create-three-stacks 5)]
      (stack-push three-stacks 1 10)
      (stack-push three-stacks 1 20)
      (stack-push three-stacks 1 30)

      (is (= 30 (stack-pop three-stacks 1)))
      (is (= 20 (stack-pop three-stacks 1)))
      (is (= 10 (stack-pop three-stacks 1)))
      (is (nil? (stack-pop three-stacks 1)))
      (is (stack-empty? three-stacks 1))))

  (testing "mixed stacks"
    (let [three-stacks (create-three-stacks 5)]
      (stack-push three-stacks 1 10)
      (stack-push three-stacks 2 20)
      (stack-push three-stacks 1 11)
      (stack-push three-stacks 3 30)

      (is (= 20 (stack-peek three-stacks 2)))
      (is (= 20 (stack-pop three-stacks 2)))
      (is (nil? (stack-pop three-stacks 2)))
      (is (= 11 (stack-pop three-stacks 1)))
      (is (= 30 (stack-pop three-stacks 3)))

      (is (stack-empty? three-stacks 3))
      (is (stack-empty? three-stacks 2))
      (is (not (stack-empty? three-stacks 1))))))

(deftest stacks-full-tests
  (let [three-stacks (create-three-stacks 1)]
    (stack-push three-stacks 1 10)
    (is (thrown? IllegalStateException (stack-push three-stacks 1 11)))
    (stack-peek three-stacks 1)
    (is (thrown? IllegalStateException (stack-push three-stacks 1 11)))
    (is (= 10 (stack-pop three-stacks 1)))
    (stack-push three-stacks 1 11)

    (stack-push three-stacks 2 20)
    (is (thrown? IllegalStateException (stack-push three-stacks 2 21)))
    (stack-push three-stacks 3 30)))