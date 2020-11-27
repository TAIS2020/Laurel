const _ = require('lodash')


const items = [{
        'id': 1,
        'reference': '111000',
        'date': '11/04/2020',
        'nInvoice': '00012',
        'description': 'producte',
        'product': 'ciclavvv',
        'totalValue': '$  122220'
    },
    {
        'id': 2,
        'reference': '1110222',
        'date': '23/02/2020',
        'nInvoice': '00013',
        'description': 'alumine total',
        'product': 'cicla -vvv',
        'totalValue': '$  120000'
    },
    {
        'id': 3,
        'reference': '111000',
        'date': '01/12/2020',
        'nInvoice': '00012',
        'description': 'producte',
        'product': 'ciclavvv',
        'totalValue': '$  200000'
    },
    {
        'id': 4,
        'reference': '111000',
        'date': '23/04/2020',
        'nInvoice': '00012',
        'description': 'compra realizada',
        'product': 'cicla dddd',
        'totalValue': '$   122220'
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