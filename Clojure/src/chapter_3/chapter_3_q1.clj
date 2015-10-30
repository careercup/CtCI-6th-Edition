(ns chapter-3.chapter-3-q1
  (:import (clojure.lang Atom)))

(defprotocol Stacks
  (stack-pop [this stack-num])
  (stack-peek [this stack-num])
  (stack-push [this stack-num x])
  (stack-empty? [this stack-num]))

(defn- peek-with-fn [stack-num stacks post-peek-fn]
  {:pre [(<= 1 stack-num 3)]}
  (let [tops (:tops stacks)
        arr (:arr stacks)
        tops-vec @tops
        to-pop-idx (get tops-vec (dec stack-num))]
    (if (>= to-pop-idx 0)
      (let [popped (aget arr to-pop-idx)]
        (when (some? post-peek-fn)
          (post-peek-fn tops to-pop-idx))
        popped)
      nil)))

(defrecord ThreeStacks [arr ^Atom tops]
  Stacks
  (stack-pop [this stack-num]
    (peek-with-fn stack-num this (fn [^Atom tops to-pop-idx]
                                   (let [new-top (- to-pop-idx 3)]
                                     (swap! tops assoc (dec stack-num) new-top)))))

  (stack-peek [this stack-num]
    (peek-with-fn stack-num this nil))

  (stack-push [this stack-num x]
    (if (let [max-idx (- (dec (alength arr)) (- 3 stack-num))]
          (= max-idx (get @tops (dec stack-num))))
      (throw (IllegalStateException. "Stack full!"))
      (let [tops-vec @tops
            cur-top-idx (get tops-vec (dec stack-num))
            to-push-idx (+ cur-top-idx 3)]
        (aset arr to-push-idx x)
        (swap! tops assoc (dec stack-num) to-push-idx))))

  (stack-empty? [this stack-num]
    (if (<= 1 stack-num 3)
      (let [tops-vec @tops]
        (neg? (get tops-vec (dec stack-num))))
      (throw (IllegalArgumentException. "Invalid stack number!")))))

(defn create-three-stacks [n]
  (->ThreeStacks (make-array Object (* n 3)) (atom [-3 -2 -1])))