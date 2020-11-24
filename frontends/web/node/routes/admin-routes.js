const express = require('express');
const router = express.Router();
const isAuthorized = require('../middlewares/middleware-is-authorized')
const controller = require('../http/controllers/admin-controller')
const {roles} = require('../config/config')

router.post('/grant', isAuthorized({hasRoles: [roles.ADMIN]}), controller.grant);

module.exports = router;
