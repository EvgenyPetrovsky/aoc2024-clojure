(ns aoc2024-clojure.core
  (:gen-class))

(require
 '[aoc2024-clojure.util :as util]
 ;;'[aoc2024-clojure.day01 :as day01]
 ;;'[aoc2024-clojure.day02 :as day02]
 '[aoc2024-clojure.day03 :as day03]
 )

(defn -main
  "Solve the daily problem"
  [& args]
  (let [dayno 3
        testm (get args "test" false)
        input (if testm
                (util/read-test-input dayno)
                (util/read-input dayno))
        ]
    (println "Solution to part 1: " (day03/parse-solve-part-1 input))
    (println "Solution to part 2: " (day03/parse-solve-part-2 input))
    ))
