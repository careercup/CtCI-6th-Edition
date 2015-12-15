(ns lib.bit-manipulation-test
  (:require [clojure.test :refer :all]
            [lib.bit-manipulation :refer :all]))

(deftest least-signif-zero-bit-idx-test
  (is (= -1 (least-signif-zero-bit-idx 2r1)))
  (is (= 0 (least-signif-zero-bit-idx 2r0)))
  (is (= -1 (least-signif-zero-bit-idx 2r01)))
  (is (= 0 (least-signif-zero-bit-idx 2r10)))
  (is (= 0 (least-signif-zero-bit-idx 2r100)))
  (is (= 0 (least-signif-zero-bit-idx 2r110)))
  (is (= 1 (least-signif-zero-bit-idx 2r101)))
  (is (= 4 (least-signif-zero-bit-idx 2r101111))))

(deftest bit-get-test
  (is (= 0 (bit-get 2r10 0)))
  (is (= 1 (bit-get 2r10 1)))
  (is (= 0 (bit-get 2r01 1)))
  (is (= 0 (bit-get 2r1011 2)))
  (is (= 0 (bit-get 2r101 1)))
  (is (= 1 (bit-get 2r1011 3)))
  (is (= 0 (bit-get 2r11011 2)))
  (is (= 1 (bit-get 2r101110101 5))))

(deftest swap-bits-test
  (is (= 2r01 (swap-bits 2r10 0 1)))
  (is (= 2r110 (swap-bits 2r101 0 1)))
  (is (= 2r1001 (swap-bits 2r1001 1 2)))
  (is (= 2r1101 (swap-bits 2r1011 1 2)))
  (is (= 2r1011 (swap-bits 2r1101 1 2))))

(deftest ones-test
  (is (= 0 (ones 0)))
  (is (= 1 (ones 1)))
  (is (= 2r11 (ones 2)))
  (is (= 2r111 (ones 3)))
  (is (= 2r1111 (ones 4)))
  (is (= 2r11111 (ones 5))))
