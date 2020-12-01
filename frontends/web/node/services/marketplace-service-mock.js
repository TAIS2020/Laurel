const _ = require('lodash')
var xml2js = require('xml2js');
var fs = require('fs');


const items = [{
        'id': '0',
        'name': 'Bicicleta GX',
        'price': 900.99,
        'description': 'Descripcion bicicleta',
        'category': 'sports'
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
    getXml: async() => {
        var parser = new xml2js.Parser();
        var extractedData = "", arr = [];
        var archivoXml = __dirname + '/../config/default.xml';

        let archivo = fs.readFileSync(archivoXml, 'utf-8');
        
        let procesamiento = parser.parseStringPromise(archivo).then(function (result) {
            for (k in result.configuration.feature) {
                var item = result.configuration.feature[k].$;
                var valor = (item.automatic!= undefined && item.automatic!= null )? true : ( (item.manual!= undefined && item.manual!= null)? true :false  );

                if(valor){
                    arr.push(item.name);  
                }
            }
            //console.log(JSON.stringify(arr.sort()))
            return arr.sort().toString();       
        });

        return procesamiento;               
    },
}

module.exports = mockDao
