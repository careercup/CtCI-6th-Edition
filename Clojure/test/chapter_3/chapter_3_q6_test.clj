(ns ^{:author "Leeor Engel"}
  chapter-3.chapter-3-q6-test
  (:require [clojure.test :refer :all]
            [chapter-3.chapter-3-q6 :refer :all]))


(deftest animal-shelter-test
  (testing "basic tests"
    (let [shelter (create-animal-shelter)]
      (enqueue shelter :cat "whiskers")

      (let [animal (dequeue-any shelter)]
        (is (= :cat (:type animal)))
        (is (= "whiskers" (:name animal))))

      (enqueue shelter :cat "kitty")

      (let [animal (dequeue-cat shelter)]
        (is (= :cat (:type animal)))
        (is (= "kitty" (:name animal))))

      (enqueue shelter :dog "fido")

      (let [animal (dequeue-any shelter)]
        (is (= :dog (:type animal)))
        (is (= "fido" (:name animal))))

      (enqueue shelter :dog "spot")

      (let [animal (dequeue-dog shelter)]
        (is (= :dog (:type animal)))
        (is (= "spot" (:name animal))))

      (enqueue shelter :dog "rex")
      (enqueue shelter :cat "oliver")

      (let [a1 (dequeue-any shelter)
            a2 (dequeue-any shelter)]
        (is (= :dog (:type a1))
            (= "rex" (:name a1)))
        (is (= :cat (:type a2))
            (= "oliver" (:name a2))))

      (enqueue shelter :dog "cujo")
      (enqueue shelter :cat "mittens")

      (let [dog (dequeue-dog shelter)
            cat (dequeue-cat shelter)]
        (is (= :dog (:type dog))
            (= "cujo" (:name dog)))
        (is (= :cat (:type cat))
            (= "mittens" (:name cat))))

      (enqueue shelter :dog "spot 2")
      (enqueue shelter :dog "buddy")
      (enqueue shelter :cat "garfield")
      (enqueue shelter :cat "kiki")
      (enqueue shelter :cat "tiger")

      (let [a1 (dequeue-dog shelter)
            a2 (dequeue-any shelter)
            a3 (dequeue-cat shelter)
            a4 (dequeue-any shelter)
            a5 (dequeue-any shelter)]
        (is (= :dog (:type a1))
            (= "spot 2" (:name a1)))
        (is (= :dog (:type a2))
            (= "buddy" (:name a2)))
        (is (= :cat (:type a3))
            (= "garfield" (:name a3)))
        (is (= :cat (:type a4))
            (= "kiki" (:name a4)))
        (is (= :cat (:type a5))
            (= "tiger" (:name a5))))))

  (testing "Oldest cat, rest dogs"
    (let [shelter (create-animal-shelter)]
      (enqueue shelter :cat "kiki")
      (enqueue shelter :dog "rex")
      (enqueue shelter :dog "spot")
      (enqueue shelter :dog "fido")

      (let [a1 (dequeue-cat shelter)
            a2 (dequeue-dog shelter)
            a3 (dequeue-any shelter)
            a4 (dequeue-cat shelter)
            a5 (dequeue-any shelter)
            a6 (dequeue-any shelter)
            a7 (dequeue-dog shelter)]
        (is (= :cat (:type a1))
            (= "kiki" (:name a1)))
        (is (= :dog (:type a2))
            (= "rex" (:name a2)))
        (is (= :dog (:type a3))
            (= "spot" (:name a3)))
        (is (= nil a4))
        (is (= :dog (:type a5))
            (= "fido" (:name a5)))
        (is (= nil a6)
            (= nil a7))))))