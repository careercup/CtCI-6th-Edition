(ns chapter-1.chapter_1_q8_test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q8 :refer :all]))

(deftest zero-matrix-test
  (testing "All zero cases"
    (is (= (zero-matrix [[0]]) [[0]]))
    (is (= (zero-matrix [[0 0]]) [[0 0]])))
  (testing "All one's cases"
    (is (= (zero-matrix [[1]]) [[1]]))
    (is (= (zero-matrix [[1 1]]) [[1 1]])))
  (testing "All 1's except for single co-ordinate."
    (is (= (zero-matrix [[0 1]
                         [1 1]]) [[0 0]
                                  [0 1]]))
    (is (= (zero-matrix [[1 0]
                         [1 1]]) [[0 0]
                                  [1 0]]))
    (is (= (zero-matrix [[1 1]
                         [0 1]]) [[0 1]
                                  [0 0]]))
    (is (= (zero-matrix [[1 1]
                         [1 0]]) [[1 0]
                                  [0 0]])))
  (testing "Catching 0 co-ordinates in rows would be lost without pre-process pass to find 0 co-ordinates."
    (is (= (zero-matrix [[1 1 1]
                         [0 1 0]
                         [1 1 1]]) [[0 1 0]
                                    [0 0 0]
                                    [0 1 0]]))
    (is (= (zero-matrix [[1 1 1]
                         [1 1 1]
                         [0 0 0]]) [[0 0 0]
                                    [0 0 0]
                                    [0 0 0]])))
  (testing "Other larger matrix cases."
    (is (= (zero-matrix [[0 1 0 1]
                         [1 1 1 1]
                         [1 1 0 1]
                         [1 1 1 1]]) [[0 0 0 0]
                                      [0 1 0 1]
                                      [0 0 0 0]
                                      [0 1 0 1]]))
    (is (= (zero-matrix [[0 1 1 1 1]
                         [1 1 1 0 1]
                         [1 1 1 1 1]
                         [1 1 1 0 1]
                         [1 1 1 1 1]]) [[0 0 0 0 0]
                                        [0 0 0 0 0]
                                        [0 1 1 0 1]
                                        [0 0 0 0 0]
                                        [0 1 1 0 1]]))))
