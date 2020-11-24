export class Articulo {
    id: number;
    name: string;
    description: string;
    stock: string;
    price: string;

  
    constructor(item) {
      this.id = item.id;
      this.name = item.name;
      this.stock = item.stock;
      this.price = item.price;
      this.description = item.description;
    }
  }