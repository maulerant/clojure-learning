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
  (concat (filter even? array )(filter odd? array) ))

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

(monotonic-array [ 1 3 2])
;; false

(defn reverse-words [ string ]
  (apply str (reverse string)))

(reverse-words "Let's take LeetCode contest")
;; => "tsetnoc edoCteeL ekat s'teL"


(reverse-words "Mr Ding")
;; => "gniD rM"
