const express = require('express');
const router = express.Router();
const controller = require('../domain/login/controller-login')

/* GET home page. */
router.post('/', controller);

module.exports = router;
