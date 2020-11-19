const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const logger = require('morgan');

// Routers
const apiV1Router = require('./routes/api.v1');
const loginRouter = require('./routes/login');

// Middlewares
const verifyJWS = require('./middlewares/jwt-verify')

const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/login', loginRouter);
app.use('/v1', verifyJWS, apiV1Router);

module.exports = app;
