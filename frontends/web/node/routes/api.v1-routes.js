const express = require('express');
const router = express.Router();
const usersController = require('../http/controllers/users-controller')
const isAuthorized = require('../middlewares/middleware-is-authorized')
const {roles} = require('../config/config')

router.get('/ping', (req, res, next) => {
    res.send("pong")
})

// Users
router.get('/users', isAuthorized({hasRoles: [roles.ADMIN]}), usersController.getUsers)

module.exports = router;
