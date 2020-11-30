const enviosService = require('../../services/envios-service')

const envioscontroller = {
    findAll: async(req, res, next) => {
        res.json(await enviosService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await enviosService.findById(req.params.id))
    }
}


module.exports = envioscontroller