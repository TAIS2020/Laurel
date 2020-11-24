const _ = require('lodash')

const items = [{
        'id': '0',
        'name': 'Bicicleta GX',
        'price': 900.99,
        'description': 'Descripcion bicicleta'
    },
    {
        'id': '1',
        'name': 'Bicicleta MTB',
        'price': 950.00,
        'description': 'Descripcion bicicleta'
    },
    {
        'id': '2',
        'name': 'Bicicleta Nakxus',
        'price': 999.99,
        'description': 'Descripcion bicicleta'
    },
    {
        'id': '3',
        'name': 'Bicicleta Optimus',
        'price': 1000.50,
        'description': 'Descripcion bicicleta'
    },
    {
        'id': '4',
        'name': 'Bicicleta Roadmaster',
        'price': 1500.00,
        'description': 'Descripcion bicicleta'
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