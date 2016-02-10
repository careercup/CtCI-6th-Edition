(ns lib.bit-manipulation)

(defn bit-update [x n set-to-1?]
  (let [val (if set-to-1? 1 0)
        mask (bit-not (bit-shift-left 1 n))]
    (bit-or (bit-and x mask) (bit-shift-left val n))))

(defn clear-bits [x j i]
  "Clears the bits starting at index j down to index i (exclusive)"
  (reduce #(bit-clear %1 %2) x (range j i -1)))

(defn bit-get [x i]
  (bit-and 1 (bit-shift-right x i)))

(defn swap-bits [x i j]
  (let [bit-at-i (bit-get x i)
        bit-at-j (bit-get x j)
        x-with-j-at-i (bit-update x i (pos? bit-at-j))]
    (bit-update x-with-j-at-i j (pos? bit-at-i))))

(defn least-signif-bit [x]
  (bit-and x 1))

(defn ones [size]
  "Returns the binary number represented by a sequence of size 1's."
  (-> (Math/pow 2 size) dec int))

(defn least-signif-bit-seq [x]
  (map #(least-signif-bit %) (take-while pos? (iterate #(bit-shift-right % 1) x))))

;; NOTE: there are much faster possible implementations of this
(defn most-signif-bit-seq [x]
  "Returns a lazy sequence of the most significant bit of repeated left bit shifts."
  (reverse (least-signif-bit-seq x)))

(defn least-signif-zero-bit-idx [x]
  "Returns the index of the least significant 0 bit, or -1 if no zero bits are present."
  (if (zero? x)
    0
    (let [zero-bits (take-while pos? (least-signif-bit-seq x))
          count (count zero-bits)
          remaining-bits (bit-shift-right x count)]
      (if (zero? remaining-bits)
        -1
        count))))