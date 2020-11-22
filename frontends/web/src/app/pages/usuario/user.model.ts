export class User {
  id: number;
  name: any;
  lastname: string;
  documentType: string;
  documentNumber: string;

  constructor(user) {
    this.id = user.id;
    this.name = user.name;
    this.lastname = user.lastname;
    this.documentType = user.documentType;
    this.documentNumber = user.documentNumber;
  }
}
