(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q2-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]
            [chapter-4.chapter-4-q2 :refer :all]))

(deftest minimal-tree-test
  (testing "single element"
    (let [arr [1]
          expected-bst (create-tree [1])]
      (is (= expected-bst (minimal-tree arr)))))

  (testing "base-case even"
    (let [arr [1 2]
          expected-bst (create-tree [1
                                     []
                                     [2]])]
      (is (= expected-bst (minimal-tree arr)))))

  (testing "base-case odd"
    (let [arr [1 2 3]
          expected-bst (create-tree [2
                                     [1]
                                     [3]])]
      (is (= expected-bst (minimal-tree arr)))))

  (testing "even-numbered array"
    (let [arr [1 2 3 4]
          expected-bst (create-tree [3
                                     [1
                                      [] [2]]
                                     [4]])]
      (is (= expected-bst (minimal-tree arr)))))

  (testing "odd-numbered array"
    (let [arr [1 2 3 4 5]
          expected-bst (create-tree [3
                                     [1
                                      [] [2]]
                                     [4
                                      [] [5]]])]
      (is (= expected-bst (minimal-tree arr))))))