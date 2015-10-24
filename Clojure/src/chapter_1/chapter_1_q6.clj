(ns chapter-1.chapter-1-q6
  (:require [clojure.string :as s]))

(defn- str-compress [str chr-eq-fn]
  (if (< (count str) 3)
    str
    (loop [idx 1
           repeat-cnt 1
           compressed []]
      (if (< idx (count str))
        (if (chr-eq-fn (.charAt str (dec idx)) (.charAt str idx))
          (recur (inc idx)
                 (inc repeat-cnt)
                 compressed)
          (recur (inc idx)
                 1
                 (conj compressed (.charAt str (dec idx)) repeat-cnt))
          )
        (let [compressed-final (conj compressed (.charAt str (dec idx)) repeat-cnt)]
          (if (>= (count compressed-final) (count str)) str (s/join compressed-final)))))))

(defn str-compress-case-insensitive [str]
  (str-compress str #(= (Character/toLowerCase %1) (Character/toLowerCase %2))))

(defn str-compress-case-sensitive [str]
  (str-compress str #(= %1 %2)))