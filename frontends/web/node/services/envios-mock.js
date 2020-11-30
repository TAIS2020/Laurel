const _ = require('lodash');

const items = [{
        'id': 1,
        'guide': '111000',
        'date': '11/04/2020',
        'address': 'cl 12 sur',
        'city': 'Bogota',
        'invoice': '00013',
        'cost': '$ 122220',
        'state': 'Entregado'
    },
    {
        'id': 2,
        'guide': '111000',
        'date': '11/04/2020',
        'address': 'cl 12 sur',
        'city': 'Bogota',
        'invoice': '00013',
        'cost': '$ 122220',
        'state': 'Entregado'
    },
    {
        'id': 3,
        'guide': '111000',
        'date': '11/04/2020',
        'address': 'cl 12 sur',
        'city': 'Bogota',
        'invoice': '00013',
        'cost': '$ 122220',
        'state': 'Entregado'
    },
    {
        'id': 4,
        'guide': '111000',
        'date': '11/04/2020',
        'address': 'cl 12 sur',
        'city': 'Bogota',
        'invoice': '00013',
        'cost': '$ 122220',
        'state': 'Entregado'
    }

]



const mockDao = {
    findAll: async() => {
        return items
    },
    findById: async(id) => {
        return _.filter(items, item => item.id === id)
    }
}

module.exports = mockDao