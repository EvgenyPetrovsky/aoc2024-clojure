(ns aoc2024-clojure.day03
  (:require
   [clojure.string :as str]
   [aoc2024-clojure.util :as util]))


(defn parse-input-1
  [input]
  (->>
   input
   (re-seq #"mul\(\d+,\d+\)")
   (map util/string-to-ints)))

(defn parse-input-2
  [input]
  (->>
   (str/join "" ["do()" input "don't()"])
   (str/split-lines)
   (str/join "")
   (re-seq #"do\(\)(.+?)don't\(\)")
   (map second)
   (str/join "")
   (parse-input-1)))

(defn solve
  "Problem is list of pairs, solution is sum of products of pairs"
  [problem]
  (->>
   problem
   (map (fn [[x y]] (* x y)))
   (reduce +)))

(def parse-solve-part-1 (comp solve parse-input-1))

;; 43363076 is too low
;; 59097164
(def parse-solve-part-2 (comp solve parse-input-2))
