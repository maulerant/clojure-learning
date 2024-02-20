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




  