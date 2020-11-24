const userService = require('../../services/user-service')

const usersController = {
    findAll: async(req, res, next) => {
        res.json(await userService.getAllUsers())
    }
}

module.exports = usersController