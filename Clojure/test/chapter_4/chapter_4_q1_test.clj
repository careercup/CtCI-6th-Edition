(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q1-test
  (:require [clojure.test :refer :all]
            [chapter-4.chapter-4-q1 :refer :all]))

(deftest route-between-nodes-test
  (let [g {:a [:b :c :e]
           :b [:d]
           :c [:b :d]
           :d [:a :g :h]
           :e [:a :h :i]
           :f [:b :g]
           :g [:i]
           :h [:c :f :g]
           :i []}]
    (is (route-between-nodes g :a :h))
    (is (route-between-nodes g :b :h))
    (is (route-between-nodes g :c :h))
    (is (route-between-nodes g :d :h))
    (is (route-between-nodes g :f :h))
    (is (not (route-between-nodes g :i :h)))
    (is (route-between-nodes g :c :a))
    (is (route-between-nodes g :c :e))
    (is (route-between-nodes g :c :i))
    (is (not (route-between-nodes g :h :z)))))

(deftest route-between-nodes-alt-test
  (let [g {:a [:b :c :e]
           :b [:d]
           :c [:b :d]
           :d [:a :g :h]
           :e [:a :h :i]
           :f [:b :g]
           :g [:i]
           :h [:c :f :g]
           :i []}]
    (is (route-between-nodes-alt g :a :h))
    (is (route-between-nodes-alt g :b :h))
    (is (route-between-nodes-alt g :c :h))
    (is (route-between-nodes-alt g :d :h))
    (is (route-between-nodes-alt g :f :h))
    (is (not (route-between-nodes-alt g :i :h)))
    (is (route-between-nodes-alt g :c :a))
    (is (route-between-nodes-alt g :c :e))
    (is (route-between-nodes-alt g :c :i))
    (is (not (route-between-nodes-alt g :h :z)))))

