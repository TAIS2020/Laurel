export class DetalleMarkplace {
    name: string;
    quantity: string;
    price: string;
  
    constructor(item) {
       this.name = item.name;
       this.quantity = item.quantity;
       this.price = item.price;
    }
  }