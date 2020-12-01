const marketplaceService = require('../../services/marketplace-service')

const controller = {
    findAll: async(req, res, next) => {
        res.json(await marketplaceService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await marketplaceService.findById(req.params.id))
    },    
    getXml: async(req, res, next) => {
        res.json(await marketplaceService.getXml())
    },
}

module.exports = controller