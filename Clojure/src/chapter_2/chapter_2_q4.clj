(ns chapter-2.chapter-2-q4
  (:require
    [data-structures.linked-list :refer :all])
  (:import (clojure.lang Atom)
           (data_structures.linked_list SinglyLinkedList)))

(defn merge-lists [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (cond (nil? l1) l2
        (nil? l2) l1
        :else (loop [^SinglyLinkedList merged l1
                     ^Atom l2n (:head l2)]
                (if (nil? l2n)
                  merged
                  (recur (append-to-tail merged (:data @l2n))
                         (:next @l2n))))))

(defn partition-list [^SinglyLinkedList l x]
  (loop [^SinglyLinkedList less-than-list nil
         ^SinglyLinkedList greater-than-list nil
         ^Atom n (:head l)]
    (if (nil? n)
      (merge-lists less-than-list greater-than-list)
      (recur (if (< (:data @n) x)
               (if (nil? less-than-list)
                 (create-linked-list (:data @n))
                 (append-to-tail less-than-list (:data @n)))
               less-than-list)
             (if (>= (:data @n) x)
               (if (nil? greater-than-list)
                 (create-linked-list (:data @n))
                 (append-to-tail greater-than-list (:data @n)))
               greater-than-list)
             (:next @n)))))

(defn swap-with-next [^Atom n1]
  {:pre [(some? n1)]}
  "Swaps node n with its next node. If there is no next node, does nothing."
  (let [^Atom next (:next @n1)
        n1-data (:data @n1)]
    (when (some? next)
      (dosync
        (reset! n1 (create-node (:data @next) next))
        (reset! next (create-node n1-data (:next @next)))))))

(defn- partition-shift-node [^Atom start ^Atom end x]
  "Given a start node, shift the start to its correct position with respect to x in the list and return the next start to evaluate."
  (loop [^Atom n start
         ^Atom new-start (:next @start)]
    (if (or (nil? (:next @n)) (= (:next @n) end))
      [new-start n]
      (if (>= (:data @n) x)
        (do (swap-with-next n)
            (recur (:next @n)
                   (if (and (some? (:next @n)) (= (:next @n) new-start))
                     n
                     new-start)))
        [(:next @n) end]))))

(defn partition-list-no-buffer [^SinglyLinkedList l x]
  (loop [^Atom start (:head l)
         ^Atom end nil]
    (if (or (nil? start) (= start end))
      l
      (let [last-part (partition-shift-node start end x)
            [start end] last-part]
        (recur start
               end)))))