(ns habitat
  (:use [clojure.contrib.def :only (defn-memo)]
	[clojure.java.io :only (resource)]
	[clojure.contrib.except :only (throwf)]))

;; Default envs: :dev, :test, :prod
(def *current-env* (atom (let [sys-env (System/getProperty "habitat.env")]
			   (if sys-env
			     sys-env
			     :dev))))

(defn set-env [env]
  (reset! *current-env* env))

(defn-memo habitat [& [override-env]]
  (let [env (if override-env override-env @*current-env*)
	paths [(str "habitat/" "default.clj") (str "habitat/" (name env) ".clj")]]
    (->> paths
	 (map #(let [res (resource %2)] (if res res (throwf "Config file not found: %s" %1))) paths)
	 (filter identity)
	 (map #(java.io.InputStreamReader. (.openStream %)))
	 (map #(try (load-reader %2) (catch Exception e (throwf "Error loading file %s" %1))) paths)
	 (reduce merge))))