(ns data-structures.tree-test
  (:require [clojure.test :refer :all]
            [data-structures.tree :refer :all]))

(deftest tree-find-test
  (let [tree (create-tree [5
                           [] [4
                               [2
                                [1 [] []] [3 [] []]] []]])]
    (is (nil? (tree-find nil 6)))
    (is (nil? (tree-find tree 6)))
    (is (= tree (tree-find tree 5)))
    (is (= (:right tree) (tree-find tree 4)))
    (is (= (get-in tree [:right :left]) (tree-find tree 2)))
    (is (= (get-in tree [:right :left :left]) (tree-find tree 1)))
    (is (= (get-in tree [:right :left :right]) (tree-find tree 3)))))

(deftest in-order-walk-test
  (let [tree (create-tree [5
                           [] [4
                               [2
                                [1 [] []] [3 [] []]] []]])]
    (is (= [1 2 3] (in-order-walk (tree-find tree 2))))
    (is (= [1 2 3 4] (in-order-walk (tree-find tree 4))))
    (is (= [5 1 2 3 4] (in-order-walk tree)))))

(deftest pre-order-walk-test
  (let [tree (create-tree [5
                           [] [4
                               [2
                                [1 [] []] [3 [] []]] []]])]
    (is (= [2 1 3] (pre-order-walk (tree-find tree 2))))
    (is (= [4 2 1 3] (pre-order-walk (tree-find tree 4))))
    (is (= [5 4 2 1 3] (pre-order-walk tree)))))

(deftest post-order-walk-test
  (let [tree (create-tree [5
                           [] [4
                               [2
                                [1 [] []] [3 [] []]] []]])]
    (is (= [1 3 2] (post-order-walk (tree-find tree 2))))
    (is (= [1 3 2 4] (post-order-walk (tree-find tree 4))))
    (is (= [1 3 2 4 5] (post-order-walk tree)))))


(run-tests)
