const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const path = require('path');

// CORS
const cors = require('cors')

// Firebase
const firebaseAdmin = require('firebase-admin')
const firebaseServiceAccount = require('./serviceAccountKey.json')

firebaseAdmin.initializeApp({
    credential: firebaseAdmin.credential.cert(firebaseServiceAccount)
})

// Routers
const apiV1Router = require('./routes/api.v1-routes');
const authRouter = require('./routes/auth-routes');
const adminRouter = require('./routes/admin-routes');

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
app.use('/admin', [identifyPlatform, verifyJWS], adminRouter);
app.use('/api/v1', [identifyPlatform], apiV1Router);

// Serve angular app
const staticFile = path.join(__dirname, 'public', 'dist')
app.use(express.static(staticFile));

app.get('/*', (req, res) => {
    res.sendFile(staticFile + '/index.html')
});

module.exports = app;
