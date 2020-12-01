const express = require('express');
const router = express.Router();
const isAuthorized = require('../middlewares/middleware-is-authorized')
const { roles } = require('../config/config')

const usersController = require('../http/controllers/users-controller')
const marketplaceController = require('../http/controllers/marketplace-controller')
const articuloController = require('../http/controllers/articulo-controller')
const carritoController = require('../http/controllers/carrito-controller')
const historialdepagoscontroller = require('../http/controllers/historial-de-pagos-controller')
const envioscontroller = require('../http/controllers/envios-controller')




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
router.get('/historialDePagos', historialdepagoscontroller.findAll)
router.get('/historialDePagos/:id?', historialdepagoscontroller.findById)
router.get('/envios', envioscontroller.findAll)
router.get('/envios/:id?', envioscontroller.findById)

router.get('/getXml', marketplaceController.getXml)

module.exports = router;