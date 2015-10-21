(ns chapter-1.chapter-1-q9
  )

(defn- substr? [s1 s2] (.contains s1 s2))

(defn rotation? [s1 s2]
  (if (not= (count s1) (count s2))
    false
    (let [s1-doubled (str s1 s1)]
      (substr? s1-doubled s2))))