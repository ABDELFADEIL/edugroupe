import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Produit} from "../../produits/produit";
import {Categorie} from "../../produits/categorie";
import {ProduitService} from "../../produits/produit.service";
import {CategorieService} from "../../produits/categorie.service";
import { faChevronDown } from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css']
})
export class FormProduitComponent implements OnInit, OnChanges{

  @Output() addUpdateEvent = new EventEmitter<boolean>;
  @Input() produit: Produit | undefined;
  validated: boolean = false;
  categories: Categorie [] = [];
  selectedCategorie: Categorie | undefined;
  faChevronDown = faChevronDown;
  constructor(private produitService: ProduitService, private categorieService: CategorieService) {
  }
  ngOnInit(): void {
    this.getAllCategories();
    if(this.produit){
      this.selectedCategorie = this.produit.categorie;
      console.log('produit not null');
      console.log(this.produit);
      console.log(this.selectedCategorie);
      console.log(this.produit);
      console.log(this.selectedCategorie);
    }else{
      this.produit = new Produit();
      this.selectedCategorie = this.categories[0];
    }


  }

  onSubmit(formValue:any) {
    console.log(formValue);
    console.log(this.produit);
    if(this.produit)
    this.produitService.updateAddProduit(this.produit).subscribe(
      (response)=> {
        console.log(response);
        this.addUpdateEvent.emit(false);
      }
    )
  }

  getAllCategories(){
    this.categorieService.getCategories().subscribe(
     (response)=> {
        this.categories = response;
        console.log(this.categories);
    }
    )
  }


  changeCategorie() {
    console.log(this.selectedCategorie);
    if(this.produit)
    this.produit.categorie = this.selectedCategorie;
    console.log(this.produit);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    if (changes['produit'].currentValue == undefined){
      this.produit = new Produit();
      this.selectedCategorie = this.categories[0];
    } else {
      this.produit = changes['produit'].currentValue;
      this.selectedCategorie = this.produit?.categorie;
    }
    console.log(this.produit);
    console.log(this.selectedCategorie);
  }
  closeForm(){
    this.produit = undefined;
    this.addUpdateEvent.emit(false);
  }
}
