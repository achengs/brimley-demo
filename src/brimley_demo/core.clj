(ns brimley-demo.core
  (:require [clojure.string :as str]
            [brimley.core :as brimley]
            [brimley.tasks :as tasks]))

(defn read-user-input
  [prompt]
  (printf "%s: " prompt)
  (flush)
  (read-line))

(defn specify-name [atm]
  (->> "specify the person's name" read-user-input str/trim
       (swap! atm assoc :name))
  :val-returned-by-specify-name) ;; the return value could be anything or nothing - just using these for clarity

(defn specify-age [atm]
  (if-let [age (->> "specify the person's name" read-user-input str/trim parse-long)]
    (do (swap! atm assoc :age age)
        :val-returned-by-specify-age)
    (do (println "Invalid age ... please try again.")
        (specify-age atm))))

(defn set-env [s atm]
  (reset! atm s)
  :val-returned-by-set-env)

(defn show-env [value]
  (printf "Current env: %s\n" value)
  :val-returned-by-show-env)

(defn show-summary [a b c]
  (printf "show-summary argument 1: %s\n" a)
  (printf "show-summary argument 2: %s\n" b)
  (printf "show-summary argument 3:\n")
  (clojure.pprint/pprint c)
  (flush)
  :val-returned-by-show-summary)

(defn show-context-atom [ctx-atm]
  (clojure.pprint/pprint ctx-atm)
  (flush)
  :val-returned-by-show-context-atom)

(def state (atom {}))
(def env (atom "local"))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; the code above this comment corresponds to your existing codebase that
;; should not need to be changed if you decide to use Brimley, except for
;; the requires in the ns form
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def menu-ctx-atm (atom {:state state
                         :env   env}))

(defn run [opts]
  (when-let [menu-edn (str(get opts '-m))]
    (brimley/load-menu! menu-ctx-atm menu-edn)
    (brimley/loop-menu! menu-ctx-atm))
  (flush)
  (System/exit 0))
