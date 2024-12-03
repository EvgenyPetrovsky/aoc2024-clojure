(ns aoc2024-clojure.day02
  (:require
    [aoc2024-clojure.util :as util]
    [clojure.string :as str]))

(defn
  parse-input
  [input]
  (map util/string-to-ints (str/split-lines input)))

(defn diffs
  [x]
  (map (fn [[x y]] (- x y)) (map vector (rest x) x)))

(defn
  same-sign?
  [x]
  (or
   (every? neg? x)
   (every? pos? x)))

(defn
  within-bound?
  [numbers]
  (let [minval 1 maxval 3]
    (and
     (every? #(<= % maxval) numbers)
     (every? #(>= % minval) numbers))))

(defn
  absolute-values
  [numbers]
  (map #(Math/abs %) numbers))

(defn
  safe?
  "Function defines if sequence is strictly safe"
  [numbers]
  (let [diff-numbers (diffs numbers)]
    (and
     (-> diff-numbers (same-sign?))
     (-> diff-numbers (absolute-values) (within-bound?)))))

(defn
  numbers-subsets
  "Take list of numbers and create list of lists with one element dropped from original list"
  [numbers]
  (map-indexed (fn [idx _] (concat (take idx numbers) (drop (inc idx) numbers))) numbers))

(defn
  tolerable?
  "Function defines id sequence is safe if you drop one element"
  [numbers]
  (->>
   numbers
   (numbers-subsets)
   (some safe?)))

(defn
  solve-part-1
  [input]
  (->>
   input
   (filter safe?)
   (count)))

(defn
  solve-part-2
  "Either original or modified sequence (with 1 element dropped) must be safe"
  [input]
  (->>
   input
   (filter (fn [ns] (or (tolerable? ns) (safe? ns))))
   (count)))

(def parse-solve-part-1 (comp solve-part-1 parse-input))
(def parse-solve-part-2 (comp solve-part-2 parse-input))


(defn -main
  "I don't do a whole lot ... yet."
  [& _args]
  (let [input (util/read-input 2)]
    (println "Solution to part 1: " (parse-solve-part-1 input))
    (println "Solution to part 2: " (parse-solve-part-2 input))))
