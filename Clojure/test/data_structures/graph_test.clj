(ns data-structures.graph-test
  (:require [clojure.test :refer :all]
            [data-structures.graph :refer :all]))

;;
;; DFS tests
;;

(deftest depth-first-search-test
  (let [g {:a [:b :c :e]
           :b [:d]
           :c [:b :d]
           :d [:a :g :h]
           :e [:a :h :i]
           :f [:b :g]
           :g [:i]
           :h [:c :f :g]
           :i []}]
    (is (= :h (depth-first-search g :a :h)))
    (is (= :h (depth-first-search g :b :h)))
    (is (= :h (depth-first-search g :c :h)))
    (is (= :h (depth-first-search g :d :h)))
    (is (= :h (depth-first-search g :f :h)))
    (is (nil? (depth-first-search g :i :h)))
    (is (= :a (depth-first-search g :c :a)))
    (is (= :e (depth-first-search g :c :e)))
    (is (= :i (depth-first-search g :c :i)))
    (is (nil? (depth-first-search g :z)))))

;;
;; BFS tests
;;

(deftest breadth-first-search-test
  (let [g {:a [:b :c :e]
           :b [:d]
           :c [:b :d]
           :d [:a :g :h]
           :e [:a :h :i]
           :f [:b :g]
           :g [:i]
           :h [:c :f :g]
           :i []}]
    (is (= :h (breadth-first-search g :a :h)))
    (is (= :h (breadth-first-search g :b :h)))
    (is (= :h (breadth-first-search g :c :h)))
    (is (= :h (breadth-first-search g :d :h)))
    (is (= :h (breadth-first-search g :f :h)))
    (is (nil? (breadth-first-search g :i :h)))
    (is (= :a (breadth-first-search g :c :a)))
    (is (= :e (breadth-first-search g :c :e)))
    (is (= :i (breadth-first-search g :c :i)))
    (is (nil? (breadth-first-search g :z)))
    ))

;;
;; Topological Sort tests
;;

(deftest topological-sort-test
  (let [g {:a [:f]
           :b [:f]
           :c [:d]
           :d [:a :b]
           :e []
           :f []}]
    (is (= [:e :f :a :b :d :c] (topological-sort g))))

  (let [g-with-cycle {:a [:f]
                      :b [:f]
                      :c [:d]
                      :d [:a :b]
                      :e []
                      :f [:b]}]
    (is (thrown? Exception (topological-sort g-with-cycle)))))
