const userService = require('../../services/user-service')

const usersController = {
    findAll: async(req, res, next) => {
        res.json(await userService.findAll())
    },
    findById: async(req, res, next) => {
        res.json(await userService.findById(req.params.id))
    },
}

module.exports = usersController