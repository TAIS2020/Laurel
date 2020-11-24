const _ = require('lodash')

const items = [{
        id: 1,
        name: "Bicicleta MTB",
        stock: "2",
        description: "eeeeee",
        price: "1200",
    },
    {
        id: 2,
        name: "Bicicleta MTB",
        stock: "2",
        description: "eeeeee",
        price: "1200",
    },
    {
        id: 3,
        name: "Bicicleta MTB",
        stock: "2",
        description: "eeeeee",
        price: "1200",
    },
    {
        id: 4,
        name: "Bicicleta MTB",
        stock: "2",
        description: "eeeeee",
        price: "1200",
    }
]

const mockDao = {
    findAll: async() => {
        return items
    },
}

module.exports = mockDao