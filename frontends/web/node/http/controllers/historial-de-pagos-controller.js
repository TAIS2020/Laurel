const historialDePagosService = require('../../services/historial-de-pagos-service')

const historialdepagoscontroller = {
    findAll: async(req, res, next) => {
        res.json(await historialDePagosService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await historialDePagosService.findById(req.params.id))
    },
}


module.exports = historialdepagoscontroller