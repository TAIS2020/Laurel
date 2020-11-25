export class Envios {
  guide: number;
  date: string;
  address: string;
  city: string;
  invoice: string;
  cost: string;
  state: string;

    constructor(item) {
      this.guide = item.guide;
      this.date = item.date;
      this.address = item.address;
      this.city = item.city;
      this.invoice = item.invoice;
      this.cost = item.cost;
      this.state = item.state;
    }
  }
