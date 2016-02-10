(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q1)

;;
;; Implementations using clojure's built-in list type, which is a singly-linked list.
;;

;; O(n) time, O(n) space
(defn remove-dupes-with-buffer [l]
  (second (reduce (fn [[seen deduped] node]
                    (if (contains? seen node)
                      [seen deduped]
                      [(conj seen node) (conj deduped node)]))
                  [#{} '()]
                  (reverse l))))

;; O(n^2)
(defn remove-dupes [l]
  (reduce (fn [deduped node]
            (conj (remove #(= node %) deduped) node))
          '()
          (reverse l)))