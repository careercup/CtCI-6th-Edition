(ns ^{:author "Leeor Engel"}
  data-structures.stack)

(defprotocol Stack
  (stack-pop [this])
  (stack-peek [this])
  (stack-push [this x])
  (stack-empty? [this])
  (stack-size [this]))