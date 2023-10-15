(ns respatialized.render
  "Render thi.ng.geom objects (and Clojure collections of such objects) as quil components."
  (:require [thi.ng.geom.core :as geom]
            #_[thi.ng.color :as color]
            [quil.core :as quil]
            [thi.ng.geom.vector :as vec]
            [thi.ng.geom.types :as geom-types]))

(defprotocol Quil
  "A protocol for drawing via Quil."
  (draw [this] "Method to draw"))

(defn- draw-ellipse
  [{:keys [^thi.ng.geom.vector.Vec2 p ^double rx ^double ry]
    :as ^thi.ng.geom.types.Ellipse2 e}]
  (let [[^double px ^double py] p]
    (quil/ellipse px py rx ry)))

(extend-protocol Quil
  thi.ng.geom.types.Ellipse2
  (draw [e] (#'draw-ellipse e)))

(comment

  )
