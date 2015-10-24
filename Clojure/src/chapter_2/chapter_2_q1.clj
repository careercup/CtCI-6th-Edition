(ns chapter-2.chapter-2-q1
  (:require
    [data-structures.linked-list :refer :all])
  (:import
    (clojure.lang Atom)
    (data_structures.linked_list SinglyLinkedList)))

(defn- remove-node [^Atom prev ^Atom n]
  {:pre [(some? @n)]}
  "Removes the node n from the linked list"
  (let [^Atom next (:next @n)]
    (if (some? next)
      (reset! (:next @prev) @next)
      (reset! prev (create-node (:data @prev))))))

;; O(n) time, O(n) space
(defn remove-dupes-with-buffer [^SinglyLinkedList l]
  (loop [seen-nodes #{}
         ^Atom prev nil
         ^Atom n (:head l)]
    (if (nil? n)
      l
      (if (contains? seen-nodes (:data @n))
        (do (remove-node prev n)
            (recur seen-nodes
                   prev
                   (:next @prev)))
        (recur (conj seen-nodes (:data @n))
               n
               (:next @n))))))

;; O(n^2)
(defn remove-dupes [^SinglyLinkedList l]
  (loop [^Atom n (:head l)]
    (if (nil? n)
      l
      (recur (loop [^Atom prev n
                    ^Atom m (:next @n)]
               (if (nil? m)
                 (:next @n)
                 (if (= (:data @n) (:data @m))
                   (do (remove-node prev m)
                       (recur prev
                              (:next @prev)))
                   (recur m
                          (:next @m)))))))))