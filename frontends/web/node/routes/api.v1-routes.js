const express = require('express');
const router = express.Router();
const usersController = require('../http/controllers/users-controller')
const marketplaceController = require('../http/controllers/marketplace-controller')

const articuloController = require('../http/controllers/articulo-controller')
const carritoController = require('../http/controllers/carrito-controller')

const isAuthorized = require('../middlewares/middleware-is-authorized')
const { roles } = require('../config/config')

router.get('/ping', (req, res, next) => {
    res.send("pong")
})

// Users
router.get('/user', usersController.findAll)
router.get('/user/:id?', carritoController.findById)
router.get('/marketplace', marketplaceController.findAll)
router.get('/marketplace/:id?', carritoController.findById)
router.get('/articulo', articuloController.findAll)
router.get('/articulo/:id?', carritoController.findById)
router.get('/carrito', carritoController.findAll)
router.get('/carrito/:id?', carritoController.findById)


module.exports = router;