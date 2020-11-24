export class DetalleArticulo {
    id: number;
    name: string;
    description: string;
    price: string;
    stock: string;

    constructor(item) {
      this.id = item.id;
      this.name = item.name;
      this.description = item.description;
      this.price = item.price;
      this.stock = item.stock;

    }
  }
