(ns chapter-1.chapter-1-q2)

(defn permutations? [s1 s2]
  "Given strings s1 and s2, returns true if they are permutations of one another, false otherwise."
  (let [sorted-s1 (sort s1)
        sorted-s2 (sort s2)]
  (= sorted-s1 sorted-s2)))
