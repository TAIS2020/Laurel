const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');

// CORS
const cors = require('cors')

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

const app = express();

// This is only for development
app.use(cors())

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());
app.engine("html", require("ejs").renderFile);

// const STATIC = path.resolve(__dirname, 'public/dist');
// const INDEX = path.resolve(STATIC, 'index.html');
// app.use(express.static(STATIC));

// app.get('/', function (req, res) {
//     res.sendFile(INDEX);
// });
app.use('/login', [], loginRouter);
app.use('/v1', [platform, verifyJWS], apiV1Router);

app.use((err, req, res, next) => {
    if (err.code !== 'EBADCSRFTOKEN') return next(err)

    // handle CSRF token errors here
    res.status(403)
    res.json({
        message: "You are not authorized"
    })
})

module.exports = app;
