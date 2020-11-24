const articuloService = require('../../services/articulos-service')

const articulocontroller = {
    findAll: async(req, res, next) => {
        res.json(await articuloService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await articuloService.findById(req.params.id))
    },
}

module.exports = articulocontroller