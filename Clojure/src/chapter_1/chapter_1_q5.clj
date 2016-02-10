(ns chapter-1.chapter-1-q5)

(defn- one-char-diff-same-len? [s1 s2]
  {:pre [(= (count s1) (count s2))]}
  "Given two strings of equal length, returns true if more than one character differs"
  (loop [diff-cnt 0
         idx 0]
    (if (or (> diff-cnt 1) (= (inc idx) (count s1)))
      (= 1 diff-cnt)
      (if (= (.charAt s1 idx) (.charAt s2 idx))
        (recur diff-cnt
               (inc idx))
        (recur (inc diff-cnt)
               (inc idx))))))

(defn- either-str-exhausted? [s1-idx s1-cnt s2-idx s2-cnt]
  (or (= (inc s1-idx) s1-cnt) (= (inc s2-idx) s2-cnt)))

(defn- last-chr-matches? [s1 s2]
  (= (.charAt s1 (dec (count s1))) (.charAt s2 (dec (count s2)))))

(defn- one-char-diff? [s1 s2]
  "Given two strings of un-equal length, return true if more than one character differs"
  (let [s1-cnt (count s1)
        s2-cnt (count s2)
        s1-larger? (> s1-cnt s2-cnt)]
    (loop [diff-cnt 0
           s1-idx 0
           s2-idx 0]
      (if (either-str-exhausted? s1-idx s1-cnt s2-idx s2-cnt)
        (cond
          (zero? diff-cnt) true
          (= 1 diff-cnt) (last-chr-matches? s1 s2)
          :else false)
        (if (= (.charAt s1 s1-idx) (.charAt s2 s2-idx))
          (recur diff-cnt
                 (inc s1-idx)
                 (inc s2-idx))
          (recur (inc diff-cnt)
                 (if s1-larger? (inc s1-idx) s1-idx)
                 (if s1-larger? s2-idx (inc s2-idx))))))))

(defn one-away? [s1 s2]
  (let [s1-cnt (count s1)
        s2-cnt (count s2)
        cnt-delta (Math/abs (- s1-cnt s2-cnt))]
    (cond
      (> cnt-delta 1) false
      (= cnt-delta 1) (one-char-diff? s1 s2)
      (zero? cnt-delta) (one-char-diff-same-len? s1 s2))))