export class Categorie {

  private _id: number = 0;
  private _nom: string = '';


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  toString() :String{
    return "{id:" + this.id +" , nome:"+ this.nom +"}";
  }

}
