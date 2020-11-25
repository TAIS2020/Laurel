export class HistorialDePagos {
    id: number;
    reference: string;
    date: string;
    nInvoice: string;
    description: string;
    product: string;
    totalValue: string;
  
    constructor(item) {
      this.id = item.id;
      this.reference = item.reference;
      this.date = item.date;
      this.nInvoice = item.nInvoice;
      this.description = item.description;
      this.product = item.product;
      this.totalValue = item.totalValue;
    }
  }