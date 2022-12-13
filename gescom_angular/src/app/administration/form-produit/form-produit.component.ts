import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Produit} from "../../produits/produit";
import {Categorie} from "../../produits/categorie";
import {ProduitService} from "../../produits/produit.service";
import {CategorieService} from "../../produits/categorie.service";
import { faChevronDown } from "@fortawesome/free-solid-svg-icons";
import {Observable} from "rxjs";

@Component({
  selector: 'form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css']
})
export class FormProduitComponent implements OnInit, OnChanges{

  @Output() toggleModal = new EventEmitter<MouseEvent>();
  @Input() produit: Produit | undefined;
  validated: boolean = false;
  categories$: Observable<Categorie[]> | undefined;
  selectedCategorie: Categorie | undefined;
  faChevronDown = faChevronDown;
  constructor(private produitService: ProduitService, private categorieService: CategorieService) {
  }
  ngOnInit(): void {
    this.categories$ = this.categorieService.getCategories();
    if(!!this.produit && this.produit?.id != 0){
      this.selectedCategorie = this.produit.categorie;
    }else{
      this.produit = new Produit();
      //this.selectedCategorie = this.categories[0];
    }


  }

  onSubmit(formValue:any) {
    console.log(formValue);
    console.log(this.produit);
    if(this.produit)
    this.produitService.updateAddProduit(this.produit).subscribe(
      (response)=> {
        console.log(response);
        this.closeModal();
      }
    )
  }


  changeCategorie() {
    console.log(this.selectedCategorie);
    if(this.produit)
    this.produit.categorie = this.selectedCategorie
    console.log(this.produit);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    if (changes['produit'].currentValue == undefined){
      this.produit = new Produit();
    } else {
      this.produit = changes['produit'].currentValue;
      this.selectedCategorie = this.produit?.categorie;
    }
    console.log(this.produit);
    console.log(this.selectedCategorie);
  }

  closeModal() {
    this.toggleModal.emit();
  }
}
