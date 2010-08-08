
(defn bad-random-seed [] (System/currentTimeMillis))

;; Last statement must return a map

{:endpoint-base-url "http://default-endpoint.localhost.com:1234"
 :random-seed (bad-random-seed)
 :override-val :from-default}