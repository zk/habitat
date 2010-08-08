(ns habitat.core-test
  (:use [habitat] :reload-all)
  (:use [clojure.test]))

(deftest test-config
  (is (= :from-dev (:override-val (habitat))))
  (is (= :from-test (:override-val (habitat :test))))
  (is (= :from-prod (:override-val (habitat :prod))))
  (is (= :from-default (:override-val (habitat :default))))
  (is (try (habitat :no-exist) false (catch Exception e true))))

