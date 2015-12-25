(ns lib.binary-search)

(defn binary-search-helper [v x strt-idx end-idx]
  (let [mid (+ strt-idx (int (/ (- end-idx strt-idx) 2)))]
    (cond (and (= strt-idx end-idx) (not= x (get v mid))) nil
          (= x (get v mid)) mid
          (> x (get v mid)) (binary-search-helper v x (inc mid) end-idx)
          :else (binary-search-helper v x strt-idx mid))))

(defn binary-search [v x]
  "Performs a binary search on a sorted vector v and returns the index of x if found."
  (binary-search-helper v x 0 (-> v count dec)))
