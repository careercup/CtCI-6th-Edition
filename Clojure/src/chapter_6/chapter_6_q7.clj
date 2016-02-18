(ns chapter-6.chapter-6-q7)

(def CHILD-PROBABILITY 0.5)

(defn- next-child []
  (if (> (rand) CHILD-PROBABILITY) :boy :girl))

(defn- random-children-until-girl []
  (take-while #(not= % :girl) (repeatedly next-child)))

(defn apocalypse-simulation [num-families]
  (let [children-seqs (reduce into (repeatedly num-families random-children-until-girl))
        num-boys (count children-seqs)
        num-girls num-families
        total-children (+ num-boys num-girls)]
    (* 100 (double (/ num-girls total-children)))))

;; RUN

(println (apocalypse-simulation 100000))