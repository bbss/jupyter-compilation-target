(ns notebook
  (:require
   ["@jupyterlab/notebook" :refer [INotebookTracker NotebookTracker] :as notebook]
   ["@jupyterlab/apputils" :refer [SessionContext ISessionContext sessionContextDialogs
                                   ICommandPalette ReactWidget]]
   ["@jupyterlab/launcher" :refer [ILauncher]]
   ["@jupyterlab/services" :refer [ServiceManager]]
   ["@lumino/widgets" :refer [Widget]]
   ["./viv.es.js" :as viv]
   ))

(println "jupyter-compilation-target.notebook")

(js/console.log viv)

(defn ^:export activate [^js app ^js notebook-tracer]
  (js/console.log "activate" app notebook-tracer))

(def ^:export extension
  #js {:id        "jupyter-compilation-target.notebook"
       :autoStart true
       :optional  #js [ILauncher]
       :requires  #js [INotebookTracker ICommandPalette]
       :activate  activate})
