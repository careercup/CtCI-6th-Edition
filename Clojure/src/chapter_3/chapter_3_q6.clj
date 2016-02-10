(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q6
  (import java.util.LinkedList
          (java.util Date)))

(defrecord Animal [type name age])

(defprotocol AnimalShelter
  (enqueue [this type name])
  (dequeue-any [this])
  (dequeue-dog [this])
  (dequeue-cat [this]))

(defrecord AnimalShelterQueues [dog-q cat-q]
  AnimalShelter

  (enqueue [this type name]
    (let [animal (->Animal type name (.getTime (new Date)))]
      (if (= type :cat)
        (.offer cat-q animal)
        (.offer dog-q animal)
        )))

  (dequeue-any [this]
    (if (or (.isEmpty dog-q) (.isEmpty cat-q))
      (if (.isEmpty dog-q)
        (.poll cat-q)
        (.poll dog-q))
      (let [oldest-dog (.peek dog-q)
            oldest-cat (.peek cat-q)]
        (if (<= (:age oldest-dog) (:age oldest-cat))
          (.poll dog-q)
          (.poll cat-q)))))

  (dequeue-dog [this]
    (.poll dog-q))

  (dequeue-cat [this]
    (.poll cat-q)))

(defn create-animal-shelter []
  (->AnimalShelterQueues (new LinkedList) (new LinkedList)))