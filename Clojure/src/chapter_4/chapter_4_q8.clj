(ns ^{:author "Leeor Engel"}
chapter-4.chapter-4-q8
  (:require [clojure.zip :as zip]
            [data-structures.tree :refer :all]))

(defn- parent [n depth]
  (let [parent (zip/up n)]
    (if (some? parent) [parent (dec depth)] [n depth])))

(defn- first-common-ancestor-helper [n1 n1-depth n2 n2-depth]
  (let [[n1-parent n1-new-depth] (parent n1 n1-depth)
        n1-parent-node (zip/node n1-parent)
        [n2-parent n2-new-depth] (parent n2 n2-depth)]
    (cond (> n1-depth n2-depth) (first-common-ancestor-helper n1-parent n1-new-depth n2 n2-depth)
          (< n1-depth n2-depth) (first-common-ancestor-helper n1 n1-depth n2-parent n2-new-depth)
          :else (if (= n1-parent n2-parent)
                  n1-parent-node
                  (first-common-ancestor-helper n1-parent n1-new-depth n2-parent n2-new-depth)))))

(defn first-common-ancestor [zipper-n1 zipper-n2]
  (let [n1-depth (count (zip/path zipper-n1))
        n2-depth (count (zip/path zipper-n2))]
    (first-common-ancestor-helper zipper-n1 n1-depth zipper-n2 n2-depth)))