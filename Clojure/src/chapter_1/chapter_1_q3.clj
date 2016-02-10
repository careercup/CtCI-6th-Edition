(ns chapter-1.chapter-1-q3)

(defn- space? [arr idx]
  (= \space (aget arr idx)))

(defn- replace-chr-at! [chr-arr replace-chr idx]
  (aset chr-arr idx replace-chr))

(defn url-ify [s true-len]
  "Given a string and it's true length, (without padding accounting for encoding space characters)
  replaces all instances of the space character with '%20'."
  (if (= true-len (.length s))
    s
    (let [chr-arr (char-array s)]
      (loop [cur-idx (- true-len 1)
             replace-idx (- (alength chr-arr) 1)]
        (if (neg? cur-idx)
          (String/valueOf chr-arr)
          (if (space? chr-arr cur-idx)
            (do (replace-chr-at! chr-arr \0 replace-idx)
                (replace-chr-at! chr-arr \2 (- replace-idx 1))
                (replace-chr-at! chr-arr \% (- replace-idx 2))
                (recur (dec cur-idx)
                       (- replace-idx 3)))
            (do (replace-chr-at! chr-arr (aget chr-arr cur-idx) replace-idx)
                (recur (dec cur-idx)
                       (dec replace-idx)))))))))
