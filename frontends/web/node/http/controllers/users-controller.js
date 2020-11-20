const userService = require('../../services/user-service')

const usersController = {
    getUsers : async (res, req, next) => {
        return await userService.getAllUsers()
    }
}

module.exports = usersController
