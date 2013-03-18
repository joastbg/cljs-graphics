(ns demo
(:require [goog.events :as events]
            [goog.style :as style]
            [goog.math.Coordinate :as Coordinate]
            [goog.ui.HoverCard :as HoverCard]
            [goog.graphics.Font :as Font]
            [goog.graphics.Stroke :as Stroke]
            [goog.graphics.SolidFill :as SolidFill]
            [goog.graphics :as graphics]
            [goog.dom :as dom]))

; Helpers
(defn get-element
  "Return the element with the passed id."
  [id]
  (dom/getElement (name id)))

(def edge-stroke (graphics/Stroke. 1 "#009"))
(def font (graphics/Font. 12 "Arial"))
(def fill (graphics/SolidFill. "#055"))

; Canvas to draw on
(def g
  (doto (graphics/createGraphics "100%" "100%")
    (.render (get-element :network))))

; Global function
(defn ^:export greet [n]
	(.drawTextOnLine g n 5 20 100 20 "left" font nil fill)
	(.drawRect g 10 10 10 10 edge-stroke fill nil)
	(.drawCircle g 50 50 30 edge-stroke fill nil)
 (.drawPath g (-> (. g (createPath)) (.moveTo 5 5) (.lineTo 15 15))
                    edge-stroke nil)
  (str "Hello " n))

; Event listener for mouse click
(events/listen (get-element :network) events/EventType.CLICK
               #(.drawTextOnLine g "johan" 50 12 10 20 "left" font nil fill))
