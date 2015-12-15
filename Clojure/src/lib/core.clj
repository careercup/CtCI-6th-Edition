(ns lib.core)

(defn map-all [f c1 c2]
  "like 3-arity map, but continues to consume until all are exhausted. nil's are passed for exhausted lists."
  (lazy-seq
    (let [s1 (seq c1) s2 (seq c2)]
      (when (or s1 s2)
        (cons (f (first s1) (first s2))
              (map-all f (rest s1) (rest s2)))))))
