### Jupyter compilation target for shadow-cljs issues

Installing Jupyter Lab:
https://jupyterlab.readthedocs.io/en/stable/getting_started/installation.html

```
npm install
npx shadow-cljs watch notebook-esm
;; or
npx shadow-cljs release notebook-esm

jupyter labextension link . --debug

;; dunno what --watch does here, I dont think its needed?
jupyter lab
```

This will launch the jupyter lab notebook and the extension
