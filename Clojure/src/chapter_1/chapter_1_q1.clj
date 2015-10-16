(ns chapter-1.chapter-1-q1)

(defn- adjacencies? [str-seq]
  "Given a string s, returns true if it contains any adjacencies, and false otherwise."
  (loop [last-char nil
         current-char (first str-seq)
         remaining-chars str-seq]
    (if (empty? remaining-chars)
      false
      (if (= current-char last-char)
        true
        (recur current-char
               (first (rest remaining-chars))
               (rest remaining-chars))))))

(defn unique-chars-sorting [s]
  "Given a string s, returns true if s has all unique characters, and false otherwise."
  (if (or (nil? s) (empty? s))
    true
    (not (adjacencies? (sort s)))))

(defn unique-chars-map-lookup [s]
  "Given a string s, returns true if s has all unique characters, and false otherwise."
  (loop [seen-chrs {}
         chr (first s)
         remaining-chrs s]
    (if (empty? remaining-chrs)
      true
      (if (not (nil? (get seen-chrs chr)))
        false
        (recur (assoc seen-chrs chr chr)
               (first (rest remaining-chrs))
               (rest remaining-chrs))))))
