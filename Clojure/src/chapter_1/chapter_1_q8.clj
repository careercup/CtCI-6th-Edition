(ns chapter-1.chapter-1-q8)

(defn- all-zero-coords [m]
  (for [i (range (count m))
        j (range (count (aget m 0)))
        :when (zero? (aget m i j))]
    [i j]))

(defn- zero-row [m zero-coord]
  (let [[x _] zero-coord
        row-size (count (aget m 0))]
    (doseq [i (range row-size)]
      (aset m x i 0))))

(defn- zero-col [m zero-coord]
  (let [[_ y] zero-coord
        col-size (count m)]
    (doseq [i (range col-size)]
      (aset m i y 0))))

(defn- vec-from-array-2d [arr]
  (mapv vec arr))

(defn zero-matrix [m]
  "Given an MxN matrix, zero-out member row and column of zero-coord"
  (let [m-array (to-array-2d m)
        zero-coords (doall (all-zero-coords m-array))]
    (doseq [coord zero-coords]
      (do
        (zero-row m-array coord)
        (zero-col m-array coord)))
    (vec-from-array-2d m-array)))