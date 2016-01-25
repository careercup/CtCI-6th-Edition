(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q1
  (:require [data-structures.graph :refer :all]))

(defn route-between-nodes [g n1 n2]
  (some? (depth-first-search g n1 n2)))

(defn route-between-nodes-alt [g n1 n2]
  (some? (breadth-first-search g n1 n2)))

