import {Component, EventEmitter, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {ProduitService} from "../../produits/produit.service";
import {Produit} from "../../produits/produit";
import {faArrowAltCircleUp, faPlus} from "@fortawesome/free-solid-svg-icons";
import { faChevronDown, faChevronRight, faChevronLeft, faTrashAlt, faSyncAlt } from "@fortawesome/free-solid-svg-icons";
import {Categorie} from "../../produits/categorie";
import {CategorieService} from "../../produits/categorie.service";

@Component({
  selector: 'app-admin-produit',
  templateUrl: './admin-produit.component.html',
  styleUrls: ['./admin-produit.component.css']
})
export class AdminProduitComponent implements OnInit, OnChanges{
  faPlus = faPlus;
  faChevronDown = faChevronDown;
  faChevronLeft = faChevronLeft;
  faChevronRight = faChevronRight;
  faTrashAlt = faTrashAlt;
  faSync = faSyncAlt;
  produits?: Produit [];
  currentPage: number = 0;
  size: number = 10;
  totalPages: number [] = [];
  totalElements: number = 0;
  updateAdd: boolean = false;
  @Output() onChange:EventEmitter<Produit> = new EventEmitter();
  produit: Produit | undefined;

  private categories: Categorie[] = [];
  categorieName: any;

  constructor(private produitService: ProduitService,
              private categorieService: CategorieService) {
  }

  ngOnInit(): void {
    this.getProduits();
    this.getAllCategories();
  }

  getProduits(){
    this.produitService.getProduits({page: this.currentPage, size: this.size}).subscribe(
      response => {
        if(!!response){
          this.produits = response.content;
          this.size = response.size;
          this.currentPage = response.number;
          this.totalPages = Array.from(Array(response.totalPages).keys());
          this.totalElements = response.totalElements;
          console.log('size= ', this.size);
          console.log('currentPage= ', this.currentPage);
          console.log('totalPages= ', this.totalPages);
          console.log(this.produits);
        }

      }
    )
  }

  changePageSize() {
    console.log(this.size);
    this.getProduits();
  }
  changePage(page:number) {
    console.log(this.size);
    if (this.currentPage + page >= 0 && this.currentPage + page < this.totalPages.length){
      this.currentPage += page;
      this.getProduits();
    }
  }

  openFormProduit(produit:Produit | undefined){
    this.updateAdd = true;
    this.produit = produit;
  }

  getAllCategories(){
    this.categorieService.getCategories().subscribe(
      (response)=> {
        this.categories = response;
        console.log(this.categories);
      }
    )
  }

  onChangeProduit(produit: Produit | undefined):void {
      this.updateAdd = true;
      this.produit = produit;
      this.onChange.emit(this.produit);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
  }
  setUpdateAdd(updateAdd: boolean){
    this.updateAdd = updateAdd;
    console.log(this.updateAdd);
  }
}
