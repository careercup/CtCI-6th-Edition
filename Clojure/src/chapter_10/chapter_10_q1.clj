(ns chapter-10.chapter-10-q1)

(defn- count-no-buffer
  "Returns the size of a with all trailing nils removed."
  [a]
  (count (remove nil? a)))

(defn sorted-merge [a b]
  (let [ra (rseq (subvec a 0 (count-no-buffer a)))
        rb (rseq b)]
    (loop [a-update-idx (dec (+ (count ra) (count b)))
           a-i (first ra)
           a-rest (rest ra)
           b-i (first rb)
           b-rest (rest rb)
           merged a]
      (cond (nil? b-i) (assoc merged a-update-idx a-i)
            (nil? a-i) (assoc merged a-update-idx b-i)
            :else (if (>= a-i b-i)
                    (recur (dec a-update-idx)
                           (first a-rest)
                           (rest a-rest)
                           b-i
                           b-rest
                           (assoc merged a-update-idx a-i))
                    (recur (dec a-update-idx)
                           a-i
                           a-rest
                           (first b-rest)
                           (rest b-rest)
                           (assoc merged a-update-idx b-i)))))))