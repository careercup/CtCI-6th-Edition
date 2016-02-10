(ns ^{:author "Leeor Engel"}
chapter-2.chapter-2-q5
  (:require [data-structures.linked-list :refer :all]))

(defn- next-sum
  ([n1 n2]
   (next-sum n1 n2 0))
  ([n1 n2 carry-over]
   (let [n1-data (if (nil? n1) 0 n1)
         n2-data (if (nil? n2) 0 n2)]
     (+ n1-data n2-data carry-over))))

(defn- get-high-digit [sum]
  (let [remainder (mod sum 10)]
    (/ (- sum remainder) 10)))

;;
;; Solution 1
;;

(defn- map-all [f c1 c2]
  "like 3-arity map, but continues to consume until all are exhausted. nil's are passed for exhausted lists."
  (lazy-seq
    (let [s1 (seq c1) s2 (seq c2)]
      (when (or s1 s2)
        (cons (f (first s1) (first s2))
              (map-all f (rest s1) (rest s2)))))))

(defn sum-lists [l1 l2]
  (let [steps (reductions (fn [[sum-list carry-over] [digit-1 digit-2]]
                            (let [sum (next-sum digit-1 digit-2 carry-over)
                                  remainder (mod sum 10)]
                              [(conj sum-list remainder) (get-high-digit sum)]))
                          ['() 0]
                          (map-all vector l1 l2))
        sum-list (map first (map first (rest steps)))
        [_ carry-over] (last steps)]
    (if (pos? carry-over)
      (cons carry-over sum-list)
      sum-list)))

;;;;
;; Follow Up - Solution 1: pad and recurse add
;;;;

(defn- zero-pad-left [l length to-len]
  (let [num-to-pad (- to-len length)]
    (concat (repeat num-to-pad 0) l)))

(defn sum-lists-forward [l1 l2]
  (let [l1-len (count l1) l2-len (count l2)
        max-len (max l1-len l2-len)
        normalized-l1 (zero-pad-left l1 l1-len max-len)
        normalized-l2 (zero-pad-left l2 l2-len max-len)
        steps (reductions (fn [[sum-list carry-over] [digit-1 digit-2]]
                            (let [sum (next-sum digit-1 digit-2)
                                  low-digit (mod sum 10)
                                  high-digit (get-high-digit sum)
                                  sum-with-carry (+ carry-over high-digit)
                                  new-sum-list (if (pos? sum-with-carry)
                                                 (conj sum-list sum-with-carry)
                                                 sum-list)]
                              [new-sum-list low-digit]))
                          ['() 0]
                          (map vector normalized-l1 normalized-l2))
        digits-no-carry-over (map first (rest steps))
        sum-list (filter some? (map first digits-no-carry-over))
        [_ carry-over] (last steps)]
    (if (pos? carry-over)
      (concat sum-list (list carry-over))
      sum-list)))

;;;;
;; Follow Up - Solution 2: string concatenation and conversion to/from integers
;;;;

(defn- num-list-as-str [l] (apply str l))

(defn sum-lists-forward-concat [l1 l2]
  (let [num-1 (Integer/parseInt (num-list-as-str l1))
        num-2 (Integer/parseInt (num-list-as-str l2))
        sum (+ num-1 num-2)]
    (apply create-linked-list (vector (map #(Integer/parseInt (str %)) (str sum))))))
