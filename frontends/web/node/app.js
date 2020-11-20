const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const csrf = require("csurf");
const logger = require('morgan');

// Firebase
const firebaseAdmin = require('firebase-admin')
const firebaseServiceAccount = require('./serviceAccountKey.json')

firebaseAdmin.initializeApp({
    credential: firebaseAdmin.credential.cert(firebaseServiceAccount)
})

// Routers
const apiV1Router = require('./routes/api.v1');
const loginRouter = require('./routes/login');

// Middlewares
const verifyJWS = require('./middlewares/middleware-jwt')
const platform = require('./middlewares/middleware-platform')
const setXSRF = require('./middlewares/middleware-xsrf')
const csrfMiddleware = csrf({
        cookie: true,
        domain: "laurel.com.mx",
    }
);

const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());
app.use(csrfMiddleware);
app.engine("html", require("ejs").renderFile);

const STATIC = path.resolve(__dirname, 'public/dist');
const INDEX = path.resolve(STATIC, 'index.html');
app.use(express.static(STATIC));

app.get('/', function (req, res) {
    res.sendFile(INDEX);
});
app.use('/login', [setXSRF], loginRouter);
app.use('/v1', [setXSRF, platform, verifyJWS], apiV1Router);

app.use((err, req, res, next) => {
    if (err.code !== 'EBADCSRFTOKEN') return next(err)

    // handle CSRF token errors here
    res.status(403)
    res.json({
        message: "You are not authorized"
    })
})


module.exports = app;
