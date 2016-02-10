(ns lib.binary-search-test
  (:require [clojure.test :refer :all]
            [lib.binary-search :refer :all]))

(deftest binary-search-test
  (is (nil? (binary-search [1 2 3] 4)))
  (is (= 0 (binary-search [1 2 3] 1)))
  (is (= 1 (binary-search [1 2 3] 2)))
  (is (= 2 (binary-search [1 2 3] 3)))
  (is (= 3 (binary-search [1 2 3 4] 4)))
  (is (= 2 (binary-search [1 2 3 5 9 10 56 78] 3)))
  (is (= 7 (binary-search [1 2 3 5 9 10 78 96] 96))))
