(ns chapter-1.chapter-1-q7)

(defn partition-vec [n v]
  (loop [idx 0
         partition []
         partitioned []]
    (if (< idx (count v))
      (if (and (zero? (mod (inc idx) n)) (> idx 0))
        (recur (inc idx)
               []
               (conj partitioned (conj partition (nth v idx))))
        (recur (inc idx)
               (conj partition (nth v idx))
               partitioned))
      (if (> (count partition) 0)
        (conj partitioned partition)
        partitioned))))

(defn rotate-matrix [m]
  "Given an NxN matrix m of integers, returns a new matrix rotated 90 degrees."
  (let [n (count m)
        flat-rotated (into [] (for [i (range n)
                                    j (range (dec n) -1 -1)]
                                (get-in m [j i])))]
    (partition-vec n flat-rotated)))

(defn- get-rotatation-coords [co-ords n]
  "Given a co-ordinates [i, j] in an NxN matrix, return new co-ordinates such that [i, j] is in a 90 degrees rotated position."
  (let [[i j] co-ords]
    [j (- (dec n) i)]))

(defn- rotate-border [m offset n offset-size]
  "Given a matrix and an offet coordinate, performs a 90-degree rotation of inner matrix with offset as top-left co-ordinate."
  ;; outer loop is n start positions
  ;; inner loop is n rotations
  (loop [x 0
         start-pos offset]
    (if (= x (dec offset-size))
      m
      (do
        (loop [y 0
               to-rotate (aget m (get start-pos 0) (get start-pos 1))
               dest-pos (get-rotatation-coords start-pos n)]
          (when (< y 4)
            (let [[i j] dest-pos
                  next-to-rotate (aget m i j)]
              (aset m i j to-rotate)
              (recur (inc y)
                     next-to-rotate
                     (get-rotatation-coords dest-pos n)))))
        (recur (inc x)
               [(get start-pos 0) (inc (get start-pos 1))])))))

(defn- vec-from-array-2d [arr]
  (mapv vec arr))

(defn rotate-matrix-in-place [m]
  "Given an NxN matrix m of integers, returns a new matrix rotated 90 degrees in place."
  (if (= 1 (count m))
    m
    (let [m-array (to-array-2d m)]
      (loop [i 0
             offset [0 0]
             size (count m)]
        (if (<= size 0)
          (vec-from-array-2d m-array)
          (do (rotate-border m-array offset (count m) size)
              (recur (inc i)
                     [(inc i) (inc i)]
                     (- size 2))))))))
