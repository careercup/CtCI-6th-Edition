(ns ^{:author "Leeor Engel"}
  chapter-4.chapter-4-q3)

(defn list-of-depths-helper [node depth]
  (if (some? node)
    (merge-with concat
                {depth (list (:data node))}
                (list-of-depths-helper (:left node) (inc depth))
                (list-of-depths-helper (:right node) (inc depth)))
    nil))

(defn list-of-depths [tree]
  (list-of-depths-helper tree 0))