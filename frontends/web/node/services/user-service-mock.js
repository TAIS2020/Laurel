const _ = require('lodash')

const items = [{
        "id": '1',
        "name": "Jon",
        "lastName": "Doe",
        "email": "jon.doe@gmail.com"
    },
    {
        "id": '2',
        "name": "Jane",
        "lastName": "Honda",
        "email": "jane.honda@gmail.com"
    },
    {
        "id": '3',
        "name": "Elizabeth",
        "lastName": "erazo",
        "email": "eerazo@gmail.com"
    },
]

const mockDao = {
    findAll: async() => {
        return items
    },
    findById: async(id) => {
        return _.filter(Item, item => item.id === id)
    },
}

module.exports = mockDao