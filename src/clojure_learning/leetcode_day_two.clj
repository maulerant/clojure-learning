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