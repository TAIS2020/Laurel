export class Item {
  id: number;
  name: string;
  description: string;
  price: string;

  constructor(item) {
    this.id = item.id;
    this.name = item.name;
    this.description = item.description;
    this.price = item.price;
  }
}
