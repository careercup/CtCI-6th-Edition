(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q2)

;; O(n+k)
(defn kth-to-last [l k]
  (let [len (count l)
        node-idx (- len k)]
    (reduce (fn [idx node]
              (if (= idx node-idx)
                (reduced node)
                (if (= idx len) nil (inc idx)))) 1 l)))


(defn- kth-to-last? [depth length k]
  (= depth (- length k)))

(defn- get-kth-to-last-recur-helper [l k depth]
  (if (empty? (rest l))
    (if (zero? k)
      [l depth]
      [nil depth])
    (let [[m length] (get-kth-to-last-recur-helper (rest l) k (inc depth))]
      (if (and (nil? m) (kth-to-last? depth length k))
        [l length]
        [m length]))))

;; O(n) time, O(n) space
(defn kth-to-last-recursive [l k]
  (let [[list-starting-at-kth _] (get-kth-to-last-recur-helper l k 1)]
    (first list-starting-at-kth)))