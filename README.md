### Jupyter compilation target for shadow-cljs issues

Installing Jupyter Lab:
https://jupyterlab.readthedocs.io/en/stable/getting_started/installation.html

tldr:

If you have conda installed:
`conda install -c conda-forge jupyterlab`
or
`pip install jupyterlab
If you are using a macOS version that comes with Python 2, run pip3 instead of pip.`

The `@jupyterlab/ui-components` dependency requires an svg which shadow-cljs doesn't like, I've run webpack on it with svg-inline-loader and output the file to `node_modules/@jupyterlab/ui-components/dist/index.js` and included it in this git repo.


After running the `npm install` && shadow-cljs build `:notebook-npm-module` or `:notebook-esm` files are written to `lib/`

`index.js` refers to the built `lib/notebook.js`, uncomment the first line to test the `lib/notebookesm.js` file.

to let jupyter build and link the lab extension:
`jupyter labextension link . --debug && say "done." && jupyter lab --watch`

This will launch the jupyter lab notebook and the extension


Current errors for these builds:

`:esm` watch build hits:

`[webpack-cli] ModuleNotFoundError: Module not found: Error: Can't resolve './cljs-runtime/shadow.module.notebookesm.prepend.js' in '/Users/username/opt/anaconda3/share/jupyter/lab/staging/node_modules/jupyter.compilation/lib'`

`:esm` release build hits:
`notebookesm.js:2638 Yjs was already imported. This breaks constructor checks and will lead to issues! - https://github.com/yjs/yjs/issues/438
shadow$provide.<computed> @ notebookesm.js:2638
index.out.js:580 TypeError: Cannot set properties of undefined (setting 'rendering')
    at new Ua (notebookesm.js:9988:1)
    at shadow$provide.<computed> (notebookesm.js:10017:71)
    at Ee (notebookesm.js:10163:142)
    at ./node_modules/jupyter.compilation/lib/notebookesm.js (notebookesm.js:10300:42)
    at __webpack_require__ (bootstrap:19:1)
    at ./node_modules/jupyter.compilation/index.js (vendors-node_modules_jupyter_compilation_index_js-node_modules_blueprintjs_core_lib_css_bluep-ec02a6.0eff05b9a2fc137c2b28.js:373:77)
    at __webpack_require__ (bootstrap:19:1)
    at main (index.out.js:575:17)`

TODO: Investigating what is causing that, advanced compilation symbols minimized..

`:npm-module` watch build is hitting:
`Module not provided: shadow.js.shim.module$$babel$runtime$helpers$interopRequireDefault`

`:npm-module` release build is hitting:
`ReferenceError: shadow$provide is not defined`
