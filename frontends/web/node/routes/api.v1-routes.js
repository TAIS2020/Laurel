const express = require('express');
const router = express.Router();
const usersController = require('../http/controllers/users-controller')
const marketplaceController = require('../http/controllers/marketplace-controller')
const isAuthorized = require('../middlewares/middleware-is-authorized')
const { roles } = require('../config/config')

router.get('/ping', (req, res, next) => {
    res.send("pong")
})

// Users
router.get('/users', usersController.findAll)
router.get('/marketplace', marketplaceController.findAll)

module.exports = router;