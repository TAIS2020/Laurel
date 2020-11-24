const _ = require('lodash')


const items = [{
        'id': '1',
        'name': 'Bicicleta GX',
        'quantity': '1',
        'price': '1100'
    },
    {
        'id': '2',
        'name': 'Bicicleta MTB',
        'quantity': '2',
        'price': '1200'
    },
    {
        'id': '3',
        'name': 'Bicicleta Nakxus',
        'quantity': '3',
        'price': '1300'
    },
    {
        'id': '4',
        'name': 'EBicicleta Optimus',
        'quantity': '4',
        'price': '1400'
    }
]



const mockDao = {
    findAll: async() => {
        return items
    },
    findById: async(id) => {
        return _.filter(items, item => item.id === id)
    },

}

module.exports = mockDao