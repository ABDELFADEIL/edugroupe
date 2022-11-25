import { Produit } from './produit';
import {Categorie} from "./categorie";

describe('Produit', () => {
  it('should create an instance', () => {
    return expect(new Produit(0, '', '', 0, 0, '', new Categorie(0, '')))
      .toBeTruthy();
  });
});
