const express = require('express');
const router = express.Router();
const usersController = require('../http/controllers/users-controller')

router.get('/ping', (req, res, next) => {
  res.send("pong")
})

// Users
router.get('/users', usersController.getUsers)

module.exports = router;
