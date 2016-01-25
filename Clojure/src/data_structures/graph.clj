(ns ^{:author "Leeor Engel"}
  data-structures.graph
  (:require [medley.core :as m]))

;;
;; DFS
;;

(defn- dfs-helper [graph start-node find-node seen]
  (let [adjacencies (get graph start-node)]
    (loop [new-seen (conj seen start-node)
           adj (first adjacencies)
           remaining (rest adjacencies)]
      (cond (nil? adj) [nil new-seen]
            (get new-seen adj) (recur new-seen
                                      (first remaining)
                                      (rest remaining))
            (= find-node adj) [adj new-seen]
            :else (let [[res updated-seen] (dfs-helper graph adj find-node (conj new-seen adj))]
                    (if (some? res)
                      [res updated-seen]
                      (recur (conj updated-seen adj)
                             (first remaining)
                             (rest remaining))))))))

(defn depth-first-search
  "Performs a depth-first search of graph for find-node. Returns node associated with find-node if found, otherwise returns nil."
  ([graph find-node]
   (depth-first-search graph (first (keys graph)) find-node))
  ([graph start-node find-node]
   (let [[res _] (dfs-helper graph start-node find-node #{})]
     res)))

;;
;; BFS
;;

(defn- first-adjacency [graph node] (first (get graph node)))
(defn- remaining-adjacencies [graph node] (rest (get graph node)))

(defn breadth-first-search
  "Performs a breadth-first search of graph for find-node. Returns node associated with find-node if found, otherwise returns nil."
  ([graph find-node]
   (breadth-first-search graph (first (keys graph)) find-node))
  ([graph start-node find-node]
   (loop [q (m/queue [start-node])
          seen #{start-node}]
     (when (not-empty q)
       (let [node (peek q)
             polled-q (pop q)
             result (loop [updated-q polled-q
                           updated-seen seen
                           adj (first-adjacency graph node)
                           remaining (remaining-adjacencies graph node)]
                      (cond (nil? adj) [updated-q updated-seen]
                            (get seen adj) (recur updated-q
                                                  updated-seen
                                                  (first remaining)
                                                  (rest remaining))
                            (= find-node adj) adj
                            :else (recur (conj updated-q adj)
                                         (conj updated-seen adj)
                                         (first remaining)
                                         (rest remaining))))]
         (if (vector? result)
           (let [[updated-q updated-seen] result]
             (recur updated-q updated-seen))
           result))))))

;;
;; Topological Sort
;;

(defn- filter-by-degree [nodes degree-cnt-fn]
  (filter #(degree-cnt-fn (count (val %))) nodes))

(defn- nodes-with-no-outgoing-edges [nodes]
  (filter-by-degree nodes zero?))

(defn- nodes-with-outgoing-edges [nodes]
  (filter-by-degree nodes pos?))

(defn- remove-edges [remaining-nodes removed-nodes]
  (let [removed-node-keys (into #{} (keys removed-nodes))
        remaining (into {} remaining-nodes)]
    (reduce-kv (fn [nodes node-key adjacencies]
                 (let [updated-edges (remove removed-node-keys adjacencies)]
                   (assoc nodes node-key updated-edges))) {} remaining)))

(defn topological-sort
  "Returns a topological sort of g, or -1 if the graph contains a cycle."
  [graph]
  (loop [sorted []
         remaining-nodes graph]
    (if (empty? remaining-nodes)
      (keys sorted)
      (let [no-outgoing-edges (nodes-with-no-outgoing-edges remaining-nodes)]
        (if (empty? no-outgoing-edges)
          (throw (Exception. "Graph has cycle!"))
          (let [new-remaining (nodes-with-outgoing-edges remaining-nodes)]
            (recur (apply conj sorted no-outgoing-edges)
                   (remove-edges new-remaining no-outgoing-edges))))))))