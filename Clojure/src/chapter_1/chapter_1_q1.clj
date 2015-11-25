(ns chapter-1.chapter-1-q1)

(defn unique-coll-sort
  "Find if collection is unique, search for repetitions in sorted string."
  [coll]
  (let [sorted-string (clojure.string/join (sort coll))]
    (empty? (re-find #"(\w)\1+" sorted-string))))

(defn unique-coll-set
  "Find if collection is unique, compare collection count with set"
  [coll]
  (let [set-coll (into #{} coll)]
    (= (count set-coll) (count coll))))
