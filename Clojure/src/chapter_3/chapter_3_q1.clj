(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q1
  (:import (clojure.lang Atom)))

(defprotocol Stacks
  (stack-pop [this stack-num])
  (stack-peek [this stack-num])
  (stack-push [this stack-num x])
  (stack-empty? [this stack-num]))

(defn- peek-with-fn [n stack-num stacks post-peek-fn]
  {:pre [(<= 1 stack-num 3)]}
  (let [tops (:tops stacks)
        arr (:arr stacks)
        tops-vec @tops
        to-pop-idx (get tops-vec (dec stack-num))]
    (if (>= to-pop-idx (* n (dec stack-num)))
      (let [popped (aget arr to-pop-idx)]
        (when (some? post-peek-fn)
          (post-peek-fn tops to-pop-idx))
        popped)
      nil)))

(defrecord ThreeStacks [n arr ^Atom tops]
  Stacks
  (stack-pop [this stack-num]
    (peek-with-fn n stack-num this (fn [^Atom tops to-pop-idx]
                                   (let [new-top (dec to-pop-idx)]
                                     (swap! tops assoc (dec stack-num) new-top)))))

  (stack-peek [this stack-num]
    (peek-with-fn n stack-num this nil))

  (stack-push [this stack-num x]
    (if (let [max-idx (dec (* n stack-num))]
          (= max-idx (get @tops (dec stack-num))))
      (throw (IllegalStateException. "Stack full!"))
      (let [tops-vec @tops
            cur-top-idx (get tops-vec (dec stack-num))
            to-push-idx (inc cur-top-idx)]
        (aset arr to-push-idx x)
        (swap! tops assoc (dec stack-num) to-push-idx))))

  (stack-empty? [this stack-num]
    (if (<= 1 stack-num 3)
      (let [tops-vec @tops]
        (< (get tops-vec (dec stack-num)) (* n (dec stack-num))))
      (throw (IllegalArgumentException. "Invalid stack number!")))))

(defn create-three-stacks [n]
  (->ThreeStacks n (make-array Object (* n 3)) (atom [(dec (* n 0)) (dec (* n 1)) (dec (* n 2))])))