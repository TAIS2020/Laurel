export class Carrito {
    id: number;
    name: string;
    quantity: string;
    price: string;
  
    constructor(item) {
      this.id = item.id;
      this.name = item.name;
      this.quantity = item.quantity;
      this.price = item.price;
    }
  }
