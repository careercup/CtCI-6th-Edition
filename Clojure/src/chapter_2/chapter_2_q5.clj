(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q5
  (:require
    [data-structures.mutable-linked-list :refer :all])
  (:import
    (clojure.lang Atom)
    (data_structures.mutable_linked_list SinglyLinkedList)))

(defn- next-sum
  ([^Atom n1 ^Atom n2]
   (next-sum n1 n2 0))
  ([^Atom n1 ^Atom n2 carry-over]
   (let [n1-data (if (nil? n1) 0 (:data @n1))
         n2-data (if (nil? n2) 0 (:data @n2))]
     (+ n1-data n2-data carry-over))))

(defn- get-high-digit [sum]
  (let [remainder (mod sum 10)]
    (/ (- sum remainder) 10)))

;;
;; Solution 1
;;

(defn sum-lists [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (loop [^Atom n1 (:head l1)
         ^Atom n2 (:head l2)
         ^Atom sum-list-head nil
         ^Atom next-new-node nil
         carry-over 0]
    (if (and (nil? n1) (nil? n2))
      (do (when (> carry-over 0)
            (reset! next-new-node (create-node (:data @next-new-node) (create-node-ref carry-over))))
          (->SinglyLinkedList sum-list-head))
      (let [sum (next-sum n1 n2 carry-over)
            remainder (mod sum 10)
            new-node (create-node-ref remainder)]
        (recur
          (if (nil? n1) nil (:next @n1))
          (if (nil? n2) nil (:next @n2))
          (if (nil? sum-list-head) new-node sum-list-head)
          (if (nil? next-new-node)
            new-node
            (do (reset! next-new-node (create-node (:data @next-new-node) new-node))
                new-node))
          (get-high-digit sum))))))

;;;;
;; Follow Up - Solution 1: pad and recurse add
;;;;

(defn- zero-pad [^SinglyLinkedList l length to-len]
  (let [num-to-pad (- to-len length)]
    (loop [^SinglyLinkedList padded l
           pad-remaining num-to-pad]
      (if (> pad-remaining 0)
        (recur (add-node padded 0)
               (dec pad-remaining))
        padded))))

(defn sum-lists-forward [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (let [l1-len (length l1)
        l2-len (length l2)
        max-len (max l1-len l2-len)
        normalized-l1 (zero-pad l1 l1-len max-len)
        normalized-l2 (zero-pad l2 l2-len max-len)]
    (loop [^Atom n1 (:head normalized-l1)
           ^Atom n2 (:head normalized-l2)
           ^SinglyLinkedList sum-list nil
           carry-over 0]
      (if (and (nil? n1) (nil? n2))
        (if (nil? sum-list)
          (create-linked-list carry-over)
          (append-to-tail sum-list carry-over))
        (let [sum (next-sum n1 n2)
              low-digit (mod sum 10)
              high-digit (get-high-digit sum)
              sum-with-carry (+ carry-over high-digit)]
          (recur (if (nil? n1) nil (:next @n1))
                 (if (nil? n2) nil (:next @n2))
                 (if (zero? sum-with-carry)
                   sum-list
                   (if (nil? sum-list)
                     (create-linked-list sum-with-carry)
                     (append-to-tail sum-list sum-with-carry)))
                 low-digit))))))

;;;;
;; Follow Up - Solution 2: string concatenation and conversion to/from integers
;;;;

(defn- num-list-as-str [^SinglyLinkedList l]
  (loop [^Atom n (:head l)
         num-str ""]
    (if (nil? n)
      num-str
      (recur (:next @n)
             (str num-str (:data @n))))))

(defn sum-lists-forward-concat [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (let [num-1 (Integer/parseInt (num-list-as-str l1))
        num-2 (Integer/parseInt (num-list-as-str l2))
        sum (+ num-1 num-2)]
    (apply create-linked-list (map #(Integer/parseInt (str %)) (str sum)))))
