(ns data-structures.linked-list)

(defn create-linked-list [spec-vec]
  (into '() (reverse spec-vec)))