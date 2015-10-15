(ns chapter-1.chapter-1-q6-test
  (:require [clojure.test :refer :all]
            [chapter-1.chapter-1-q6 :refer :all]))

(deftest str-compress-case-insensitive-test
  (is (= (str-compress-case-insensitive "A") "A"))
  (is (= (str-compress-case-insensitive "aA") "aA"))
  (is (= (str-compress-case-insensitive "aAa") "a3"))
  (is (= (str-compress-case-insensitive "aABb") "aABb"))
  (is (= (str-compress-case-insensitive "aaBbbcc") "a2b3c2"))
  (is (= (str-compress-case-insensitive "aabbBcc") "a2B3c2"))
  (is (= (str-compress-case-insensitive "abcddd") "abcddd"))
  (is (= (str-compress-case-insensitive "abcddddd") "abcddddd"))
  (is (= (str-compress-case-insensitive "abcdddddd") "a1b1c1d6")))

(deftest str-compress-case-sensitive-test
  (is (= (str-compress-case-sensitive "a") "a"))
  (is (= (str-compress-case-sensitive "aa") "aa"))
  (is (= (str-compress-case-sensitive "aaa") "a3"))
  (is (= (str-compress-case-sensitive "aabb") "aabb"))
  (is (= (str-compress-case-sensitive "aabbbcc") "a2b3c2"))
  (is (= (str-compress-case-sensitive "abcddd") "abcddd"))
  (is (= (str-compress-case-sensitive "abcddddd") "abcddddd"))
  (is (= (str-compress-case-sensitive "abcdddddd") "a1b1c1d6")))