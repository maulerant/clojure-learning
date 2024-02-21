(ns clojure-learning.leetcode-day-one
  (:require [clojure.set :as set])
  (:require [clojure.string :as cs]))

(defn task268 [arr]
  (set/difference
   (set
    (range 0 (+ 1 (count arr))))
   (sort arr)))

(task268 #{0 1})
;; #{2}

(task268 #{3 0 1})
;; #{2}

(task268 #{9,6,4,2,3,5,7,0,1})
;; => #{8}


(defn two_sum [numbers target]
  (:result (reduce-kv
            (fn [m k v]
              (let [diff (- target v)]
                (let [{:keys [result swap]} m]
                  (if (> 2 (count result))
                    (if (some #(= diff %) (keys swap))
                      {:swap swap :result [(get swap diff) k]}
                      {:swap (assoc swap v k) :result result})
                    m)))) {:swap {} :result []} numbers)))

(two_sum [2, 7, 11, 15] 9)
;; => [0 1]

(two_sum [3, 2, 4] 6)
;; => [1 2]

(two_sum [3, 3] 6)
;; => [0 1]

(defn palindrom_number [number]
  (= (str number) (cs/join "" (reverse (vec (str number))))))

(palindrom_number 1121)
;; => false

(palindrom_number 121)
;; => true

(def roman_to_int_map
  {\I 1,
   "IV" 4,
   \V 5,
   "IX" 9,
   \X 10,
   "XL" 40
   \L 50,
   "XC" 90
   \C 100,
   "CD" 400
   \D 500,
   "CM" 900
   \M 1000})

(defn split_roman [roman]
  (let [splited (vec roman) count (count splited)]
    (loop [x 0 acc []]
      (if (>= x count)
        acc
        (let [current (nth splited x) with_next (cs/join "" [current (nth splited (+ x 1) \\)])]
          (if (some #(= with_next %) (keys roman_to_int_map))
            (recur (+ x 2) (conj acc with_next))
            (recur (+ x 1) (conj acc current))))))))

(defn roman_to_int [roman]
  (reduce
   (fn [acc r] (+ acc (get roman_to_int_map r)))
   0 (split_roman roman)))

(roman_to_int "III")
;; 3
(roman_to_int "LVIII")
;; 58
(roman_to_int "MCMXCIV")
;;1994

(defn has_prefix? [prefix strings]
  (reduce
   (fn [result string]
     (and result (cs/starts-with? string prefix))) true strings))

(defn longest_common_prefix [[first & strings]]
  (let [splited (vec first) count (count splited)]
    (loop [acc [] x 0]
      (let  [next (conj acc (get splited x))]
        (if (>= x count)
          (cs/join "" acc)
          (if (has_prefix? (cs/join "" next) strings)
            (recur next (+ x 1))
            (recur acc (+ x count))))))))

(longest_common_prefix ["flower" "flow" "floight"])
;; 'flo'

(longest_common_prefix ["dog" "racecar" "car"])
;; '' 
