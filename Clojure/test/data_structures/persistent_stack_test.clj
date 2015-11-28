(ns data-structures.stack-test
  (:require [clojure.test :refer :all]
            [data-structures.persistent-stack :refer :all]))

(deftest stacks-test
  (testing "1-2 nodes"
    (is (not (stack-empty? (create-stack 5))))

    (let [stack (create-stack 5)
          stack-2 (stack-push stack 6)
          stack-3 (stack-pop stack)
          stack-4 (stack-push stack-3 7)]
      (is (not (stack-empty? stack)))
      (is (= 1 (stack-size stack)))
      (is (= 2 (stack-size stack-2)))
      (is (= 6 (stack-peek stack-2)))
      (is (= 5 (stack-peek (stack-pop stack-2))))
      (is (= (create-stack 5) (stack-pop stack-2)))
      (is (stack-empty? stack-3))
      (is (thrown? IllegalStateException (stack-pop stack-3)))
      (is (stack-empty? (stack-pop stack-4)))))

  (testing "many nodes"
    (is (not (stack-empty? (create-stack 1))))

    (let [stack (create-stack 1)
          stack-2 (stack-push stack 2)
          stack-3 (stack-push stack-2 3)
          stack-4 (stack-push stack-3 4)
          stack-5 (stack-push stack-4 5)]
      (is (= 5 (stack-size stack-5)))
      (is (= 5 (stack-peek stack-5)))
      (is (= 4 (stack-peek (stack-pop stack-5))))
      (is (= 3 (stack-peek (stack-pop (stack-pop stack-5)))))
      (is (= 2 (stack-peek (stack-pop (stack-pop (stack-pop stack-5))))))
      (is (= 1 (stack-peek (stack-pop (stack-pop (stack-pop (stack-pop stack-5)))))))
      (let [emptied (stack-pop
                      (stack-pop
                        (stack-pop
                          (stack-pop
                            (stack-pop stack-5)))))]
        (is (stack-empty? emptied))
        (is (thrown? IllegalStateException (stack-pop emptied)))
        (is (= (create-stack (list 7)) (stack-push emptied 7)))
        (is (= 7 (stack-peek (stack-push emptied 7))))))))

(run-tests)