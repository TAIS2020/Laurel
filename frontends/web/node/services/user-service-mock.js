const _ = require('lodash')

const users = [{
        "id": 1,
        "name": "Jon",
        "lastName": "Doe",
        "email": "jon.doe@gmail.com"
    },
    {
        "id": 2,
        "name": "Jane",
        "lastName": "Honda",
        "email": "jane.honda@gmail.com"
    },
    {
        "id": 3,
        "name": "Elizabeth",
        "lastName": "erazo",
        "email": "eerazo@gmail.com"
    },
]

const mockDao = {
    getAllUsers: async() => {
        return users
    },
    findById: async(id) => {
        return _.filter(users, user => user.id === id)
    },
}

module.exports = mockDao