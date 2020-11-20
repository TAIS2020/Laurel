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
const authRouter = require('./routes/auth');

// Middlewares
const verifyJWS = require('./middlewares/middleware-jwt')
const identifyPlatform = require('./middlewares/middleware-platform')

const app = express();

app.use(cors()) // This is only for development
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());

// Routes
app.use('/login', [], authRouter);
app.use('/api/v1', [identifyPlatform, verifyJWS], apiV1Router);

module.exports = app;
