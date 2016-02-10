(ns chapter-8.chapter-8-q1)

(def triple-step-count
  (memoize (fn [n] (cond (= n 0) 1
                         (< n 0) 0
                         :else (+ (triple-step-count (- n 1))
                                  (triple-step-count (- n 2))
                                  (triple-step-count (- n 3)))))))