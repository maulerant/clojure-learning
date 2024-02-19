(ns clojure-learning.brackets)

(def brackets {\) \( \] \[ \} \{})
(def open-brackets (vec (vals brackets)))

(defn carry! [stack result]
  {
   :stack  stack
   :result result
   })

(defn only-brackets [str]
  (let [all-brackets (reduce into [] brackets)]
    (filterv
      (fn [ch] (some #(= ch %) all-brackets))
      (vec str))))

(defn process-close-bracket [carry char]
  (let [stack (carry :stack)]
    (if (empty? stack)
      (carry! stack false)
      (carry! (pop stack) (= (brackets char) (peek stack))))))


(defn valid-bracket? [carry char]
  (let [{:keys [stack result]} carry]
    (if (some #(= char %) open-brackets)
      (carry! (conj stack char) result)
      (process-close-bracket carry char))))

(defn process [str]
  (reduce
    (fn [carry, char]
      (let [{:keys [stack result]} carry]
        (if result
          (valid-bracket? carry char)
          (carry! stack false)))) (carry! [] true) (only-brackets str)))

(defn pair? [str]
  (let [result (process str)]
    (and (result :result) (empty? (result :stack)))))

(map
  (fn [str]
    (println str (pair? str)))
  [
   "(kja;kdsjf"
   "(kjaklsdkfjd)"
   "({})"
   "({)}"
   ])



