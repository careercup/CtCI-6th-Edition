(ns chapter-8.chapter-8-q3)

(defn- mid [min max]
  (int (/ (+ max min) 2)))

(defn- idxs [min-idx max-idx]
  [min-idx (mid min-idx max-idx) max-idx])

(defn- distinct-magic-idx-helper? [a [min-idx idx max-idx]]
  (let [a-at-i (get a idx)]
    (cond (> min-idx max-idx) false
          (= a-at-i idx) true
          (> a-at-i idx) (distinct-magic-idx-helper? a (idxs min-idx (dec idx)))
          :else (distinct-magic-idx-helper? a (idxs (inc idx) max-idx)))))

(defn distict-magic-idx? [a]
  (let [size (count a)]
    (distinct-magic-idx-helper? a (idxs 0 (dec size)))))

;;
;; FOLLOW UP - values are not distict
;;

(defn- magic-idx-helper? [a min-idx max-idx]
  (let [idx (mid min-idx max-idx)
        a-at-i (get a idx)]
    (cond (> min-idx max-idx) false
          (= a-at-i idx) true
          :else
          (let [left-idx (min (dec idx) a-at-i)
                right-idx (max (inc idx) a-at-i)]
            (or (magic-idx-helper? a min-idx left-idx)
                (magic-idx-helper? a right-idx max-idx))))))

(defn magic-idx? [a]
  (let [size (count a)]
    (magic-idx-helper? a 0 (dec size))))