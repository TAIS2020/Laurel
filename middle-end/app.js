const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const sassMiddleware = require('node-sass-middleware');
const firebaseAdmin = require('firebase-admin')
const firebaseServiceAccount = require('./serviceAccountKey.json')

// Routers
const apiV1Router = require('./routes/api.v1');
const loginRouter = require('./routes/login');

// Middlewares
const verifyJWS = require('./middlewares/middleware-jwt')
const platform = require('./middlewares/middleware-platform')

const app = express();

// Firebase
firebaseAdmin.initializeApp({
    credential: firebaseAdmin.credential.cert(firebaseServiceAccount)
})

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(sassMiddleware({
    src: path.join(__dirname, 'public'),
    dest: path.join(__dirname, 'public'),
    indentedSyntax: true, // true = .sass and false = .scss
    sourceMap: true
}));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/login', loginRouter);
app.use('/v1', [platform, verifyJWS], apiV1Router);

module.exports = app;
