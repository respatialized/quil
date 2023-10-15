(ns respatialized.quil.20231015
  (:require [thi.ng.geom.core :as g]
            [quil.core :as q]))

(ns sketch
  (:require [quil.core :as q]))

(defn setup []
  (q/frame-rate 1)                    ;; Set framerate to 1 FPS
  (q/background 200))                 ;; Set the background colour to
;; a nice shade of grey.
(defn draw []
  (q/stroke (q/random 255))             ;; Set the stroke colour to a random grey
  (q/stroke-weight (q/random 10))       ;; Set the stroke thickness randomly
  (q/fill (q/random 255))               ;; Set the fill colour to a random grey

  (let [diam (q/random 100)             ;; Set the diameter to a value between 0 and 100
        x    (q/random (q/width))       ;; Set the x coord randomly within the sketch
        y    (q/random (q/height))]     ;; Set the y coord randomly within the sketch
    (q/ellipse x y diam diam)))         ;; Draw a circle at x y with the correct diameter

(defn run [opts]
  (q/defsketch example
    :title "Oh so many grey circles"
    :settings #(do
                 (q/pixel-density (q/display-density))
                 (q/smooth 8))
    :setup setup
    :draw draw
    :size [1280 720]))

(comment
  (run {})
  )
