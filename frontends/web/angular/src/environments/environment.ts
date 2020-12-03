// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
  production: false,
  googleMapsApiKey: '',
  backend: 'http://localhost:3000', // Put your backend here
  backend_google: 'http://35.188.114.57:8080',
  firebase: {
    apiKey: "AIzaSyDfe4eQGO_fcz8LxWK-ZJEVx-meWcr0CGc",
    authDomain: "laurel-8bccd.firebaseapp.com",
    databaseURL: "https://laurel-8bccd.firebaseio.com",
    projectId: "laurel-8bccd",
    storageBucket: "laurel-8bccd.appspot.com",
    messagingSenderId: "47910715376",
    appId: "1:47910715376:web:e65639d7275afcb0c76735",
  }
};
