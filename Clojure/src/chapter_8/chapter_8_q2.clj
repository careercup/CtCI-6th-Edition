(ns chapter-8.chapter-8-q2)

(defn- off-limits? [grid [x y]] (= 1 (get-in grid [y x])))

(defn- no-up? [grid [x y]] (or (= y 0) (off-limits? grid [x (dec y)])))
(defn- no-left? [grid [x y]] (or (= x 0) (off-limits? grid [(dec x) y])))

(defn- up [[x y]] [x (dec y)])
(defn- left [[x y]] [(dec x) y])

(defn- top-left-corner? [coords] (= coords [0 0]))
(defn- dead-end? [grid coords] (and (no-up? grid coords) (no-left? grid coords)))

(defn- robot-grid-path-helper [grid coords path visited]
  (cond (top-left-corner? coords) [(assoc visited coords path) path]
        (dead-end? grid coords) [(assoc visited coords path) false]
        (get visited coords) (get visited coords)
        (no-up? grid coords) (robot-grid-path-helper grid (left coords) (conj path coords) visited)
        (no-left? grid coords) (robot-grid-path-helper grid (up coords) (conj path coords) visited)
        :else (or (robot-grid-path-helper grid (left coords) (conj path coords) visited)
                  (robot-grid-path-helper grid (up coords) (conj path coords) visited))))

(defn robot-grid-path [grid]
  (let [row (get grid 0)
        bottom-right-corner [(dec (count row)) (dec (count grid))]
        path []]
    (cond (= [[1]] grid) false
          (= [[0]] grid) []
          :else (let [[_ computed-path] (robot-grid-path-helper grid bottom-right-corner path {})]
                  (if computed-path (reverse computed-path) false)))))

