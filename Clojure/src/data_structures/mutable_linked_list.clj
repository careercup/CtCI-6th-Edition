(ns data-structures.mutable-linked-list
  (:import (clojure.lang Atom)))

(defprotocol LinkedList
  (add-node [this data]
    "Prepends a new node containing data to the beginning of this list.")
  (append-to-tail [this data]
    "Appends a new node containing data at the end of this list.")
  (search [this data]
    "Returns first occurence of node with data.")
  (length [this])
  (delete-node [this data]
    "Deletes the node with data from the list, return false if not was not found."))

(defrecord Node [data next])

(defn create-node
  ([data] (create-node data nil))
  ([data next] (map->Node {:data data :next next})))

(defn create-node-ref
  ([data] (create-node-ref data nil))
  ([data next] (atom (create-node data next))))

(defrecord SinglyLinkedList [^Atom head]
  LinkedList
  (add-node [this data]
    (let [head (:head this)
          new-head (create-node-ref data head)]
      (->SinglyLinkedList new-head)))

  (append-to-tail [this data]
    (let [^Atom head (:head this)
          ^Atom new-tail (create-node-ref data)]
      (if (nil? head)
        (->SinglyLinkedList new-tail)
        (loop [^Atom n head]
          (if (nil? (:next @n))
            (let [new-node (create-node (:data @n) new-tail)]
              (do (reset! n new-node)
                  this))
            (recur (:next @n)))))))

  (search [this data]
    (loop [^Atom n (:head this)]
      (if (nil? n)
        nil
        (if (= data (:data @n))
          n
          (recur (:next @n))))))

  (length [this]
    (loop [^Atom n (:head this)
           len 0]
      (if (nil? n)
        len
        (recur (:next @n)
               (inc len)))))

  (delete-node [this data]
    (let [^Atom head (:head this)]
      (if (= data (:data @head))
        (if (nil? (:next @head))
          nil
          (->SinglyLinkedList (:next @head)))
        (loop [^Atom prev nil
               ^Atom n head]
          (if (= data (:data @n))
            (do
              (dosync
                ;(reset! (:next @prev) (:next @n))
                (reset! prev (create-node (:data @prev) (:next @n)))
                (when (some? (:next @n))
                  (reset! n (create-node (:data @n)))))
              this)
            (if (nil? (:next @n))
              false
              (recur n
                     (:next @n)))))))))

(defn create-linked-list [data & more]
  "Creates a linked list with the provided data and returns."
  (let [^Atom head (create-node-ref data)
        ^SinglyLinkedList l (->SinglyLinkedList head)]
    (dorun (map #(append-to-tail l %) more))
    l))

(defn to-vec [^Atom head]
  (loop [n head
         v []]
    (if (nil? n)
      v
      (recur (:next @n)
             (conj v (:data @n))))))

(defn list-to-vec [^SinglyLinkedList l]
  (to-vec (:head l)))

(defn lists-eq? [^SinglyLinkedList l1 ^SinglyLinkedList l2]
  (and (= (length l1) (length l2))
       (= (to-vec (:head l1)) (to-vec (:head l2)))))

(defn find-node [^SinglyLinkedList l x]
  "Returns the node with the first occurence of x in list l. Returns nil if x is not found."
  (loop [^Atom n (:head l)]
    (if (nil? n)
      nil
      (if (= (:data @n) x)
        n
        (recur (:next @n))))))