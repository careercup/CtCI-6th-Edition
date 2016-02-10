(ns ^{:author "Leeor Engel"}
  chapter-2.chapter-2-q1-test
  (:require [clojure.test :refer :all]
            [data-structures.linked-list :refer :all]
            [chapter-2.chapter-2-q1 :refer :all]))

;; set lookup

(deftest remove-dupes-map-lookup-test
  (is (=
        (create-linked-list [1 2 3])
        (remove-dupes-with-buffer (create-linked-list [1 2 3]))))
  (is (=
        (create-linked-list [1 2])
        (remove-dupes-with-buffer (create-linked-list [1 1 2]))))
  (is (=
        (create-linked-list [2])
        (remove-dupes-with-buffer (create-linked-list [2 2]))))
  (is (=
        (create-linked-list [1 2 3])
        (remove-dupes-with-buffer (create-linked-list [1 2 2 3]))))
  (is (=
        (create-linked-list [1 2])
        (remove-dupes-with-buffer (create-linked-list [1 2 2]))))
  (is (=
        (create-linked-list [1 2 3 4])
        (remove-dupes-with-buffer (create-linked-list [1 2 2 3 4 4])))))

;; inner search

(deftest remove-dupes-test
  (is (=
        (create-linked-list [1 2 3])
        (remove-dupes (create-linked-list [1 2 3]))))
  (is (=
        (create-linked-list [1 2])
        (remove-dupes (create-linked-list [1 1 2]))))
  (is (=
        (create-linked-list [2])
        (remove-dupes (create-linked-list [2 2]))))
  (is (=
        (create-linked-list [1 2 3])
        (remove-dupes (create-linked-list [1 2 2 3]))))
  (is (=
        (create-linked-list [1 2])
        (remove-dupes (create-linked-list [1 2 2]))))
  (is (=
        (create-linked-list [1 2 3 4])
        (remove-dupes (create-linked-list [1 2 2 3 4 4]))))
  (is (=
        (create-linked-list [1 2 4 3])
        (remove-dupes (create-linked-list [1 2 4 3 4 4])))))