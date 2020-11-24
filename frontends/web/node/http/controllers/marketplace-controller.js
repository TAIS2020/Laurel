const marketplaceService = require('../../services/marketplace-service')

const controller = {
    findAll: async (req, res, next) => {
        res.json(await marketplaceService.findAll())
    }
}

module.exports = controller
