const express = require('express');
const router = express.Router();
const controller = require('../domain/login/controller-login')

/* GET home page. */
// router.get('/', controller.loginPage);
router.post('/', controller.login);

module.exports = router;
