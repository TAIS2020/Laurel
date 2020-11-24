const carritoService = require('../../services/carrito-service')

const carritocontroller = {
    findAll: async(req, res, next) => {
        res.json(await carritoService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await carritoService.findById(req.params.id))
    },
}


module.exports = carritocontroller