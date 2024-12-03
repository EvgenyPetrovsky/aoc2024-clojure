(ns aoc2024-clojure.util)

(defn
  read-input
  [day]
  (let [file-name (str "./resources/input/day" (format "%02d" day))]
    (slurp file-name)))

(defn
  read-test-input
  [day]
  (let [file-name (str "./resources/test-input/day" (format "%02d" day))]
    (slurp file-name)))

(defn
  string-to-int
  [s]
  (Integer/parseInt s))

(defn
  string-to-ints
  [s]
  (->>
   s
   (re-seq #"\d+")
   (map string-to-int)))
