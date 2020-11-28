const _ = require('lodash')

const items = [{

        'id': 1,
        'name': 'Pepito',
        'lastname': 'Perez',
        'documentType': 'CC',
        'documentNumber': '7227448'
    },
    {
        'id': 2,
        'name': 'Rosa',
        'lastname': 'Perez',
        'documentType': 'CC',
        'documentNumber': '7225578'
    },
    {
        'id': 3,
        'name': 'Elizabetg',
        'lastname': 'Erazo',
        'documentType': 'CC',
        'documentNumber': '7226678'
    },
    {
        'id': 4,
        'name': 'Edwin',
        'lastname': 'Perez',
        'documentType': 'CC',
        'documentNumber': '7227778'
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