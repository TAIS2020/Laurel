const _ = require('lodash')

const users = [
    {
        "id": 1,
        "name": "Jon",
        "lastName": "Doe",
        "email": "jon.doe@mail.com"
    },
    {
        "id": 2,
        "name": "Jane",
        "lastName": "Honda",
        "email": "jane.honda@mail.com"
    },
    {
        "id": 2,
        "name": "Jane",
        "lastName": "Honda",
        "email": "jane.honda@mail.com"
    },
]

const mockDao = {
    getAllUsers: async () => {
        return users
    },
    findById: async (id) => {
        return _.filter(users, user => user.id === id)
    },
}

module.exports = mockDao
