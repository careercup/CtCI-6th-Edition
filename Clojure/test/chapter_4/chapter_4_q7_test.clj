(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q7-test
  (:require [clojure.test :refer :all]
            [chapter-4.chapter-4-q7 :refer :all]))

(deftest build-order-test
  (let [projects [:a :b :c :d :e :f]
        dependencies [[:d :a]
                      [:b :f]
                      [:d :b]
                      [:a :f]
                      [:c :d]]]
    (is (= [:e :f :a :b :d :c] (build-order projects dependencies))))

  (let [projects [:a :b :c :d :e :f]
        dependencies [[:d :a]
                      [:b :f]
                      [:d :b]
                      [:a :d]
                      [:a :f]
                      [:c :d]]]
    (is (thrown? Exception (build-order projects dependencies)))))

