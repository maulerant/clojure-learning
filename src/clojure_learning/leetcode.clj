(ns clojure-learning.leetcode
  (:require [clojure.set :as set]))

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
                (if(some #(= diff %) (keys swap))
                    {:swap swap :result [(get swap diff) k]}
                    {:swap (assoc swap v k) :result result})
                m)))) {:swap {} :result []} numbers)))

(two_sum [2, 7, 11, 15] 9)
;; => [0 1]

(two_sum [3, 2, 4] 6)
;; => [1 2]

(two_sum [3, 3] 6)
;; => [0 1]

  