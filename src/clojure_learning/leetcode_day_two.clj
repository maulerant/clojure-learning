(ns clojure-learning.leetcode-day-two)

(defn sort-array-by-parity [array]
  (reduce
    (fn [acc item]
      (if (odd? item)
        (conj acc item)
        (concat [item] acc))) [] array))

(sort-array-by-parity [3 1 2 4])
;; [4 2 3 1]

(sort-array-by-parity [0])
;; [0]

(defn sort-array-by-parity2 [array]
  (concat (filter even? array) (filter odd? array)))

(sort-array-by-parity2 [3 1 2 4])
;; [4 2 3 1]

(sort-array-by-parity2 [0])
;; [0]

(defn monotonic-array [array]
  (let [sorted (vec (sort array))]
    (or (= sorted array) (= (vec (reverse sorted)) array))))

(monotonic-array [1 2 2 3])
;; true

(monotonic-array [6 5 4 4])
;; true

(monotonic-array [1 3 2])
;; false

(defn reverse-words [string]
  (apply str (reverse string)))

(reverse-words "Let's take LeetCode contest")
;; => "tsetnoc edoCteeL ekat s'teL"


(reverse-words "Mr Ding")
;; => "gniD rM"

(defn calculate-pair [ pairs]
  (reduce
    (fn [acc count]
        (println count)
       (+ acc (/ (* count (- count 1)) 2)))
    0 (vals pairs)))

(defn number-of-good-pair [ numbers]
  (calculate-pair
    (reduce
      (fn [acc number]
        (assoc acc number (+ 1 (acc number 0)))) {} numbers)))

(number-of-good-pair [ 1 1 1 1])
;; 6

(number-of-good-pair [ 1,2,3,1,1,3])
;; 4
(number-of-good-pair [ 1,2,3])
;;0

(def numbers [ \0 \1 \2 \3 \4 \5 \6 \7 \8 \9])

(defn is_number? [ char]
  (some #(= char %) numbers))

(defn decode-string [ string]
  (reduce
    (fn [acc char]
      (if (is_number? char)
        (let [count (Integer/parseInt (str char))]
          (vec ( flatten (repeat count acc))))
        (conj acc char))) [] string))

(defn decode-string-at-index [string position]
  (get (decode-string string) (- position 1)))

(decode-string-at-index "leet2code3" 10)
;; \o

(decode-string-at-index "ha22" 5)
;; \h
