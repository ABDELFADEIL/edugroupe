import {Component, EventEmitter, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {ProduitService} from "../../produits/produit.service";
import {Produit} from "../../produits/produit";
import {faArrowAltCircleUp, faPlus} from "@fortawesome/free-solid-svg-icons";
import { faChevronDown, faChevronRight, faChevronLeft, faTrashAlt, faSyncAlt } from "@fortawesome/free-solid-svg-icons";
import {Categorie} from "../../produits/categorie";
import {CategorieService} from "../../produits/categorie.service";
import {
  debounceTime,
  distinctUntilChanged,
  Observable,
  Subject,
  switchMap,
  tap,
  pipe,
  mergeMap,
  concatMap,
  AsyncSubject, of, BehaviorSubject, map
} from "rxjs";
import {AnonymousSubject} from "rxjs/internal/Subject";
import {ApiResponse} from "../../models/apiResponse";

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
  wordSubject = new  BehaviorSubject<string>('');
  produits$: Observable<ApiResponse<Produit>> = of(<ApiResponse<Produit>>{});
  @Output() onChange:EventEmitter<Produit> = new EventEmitter();
  produit: Produit | undefined;
  private categories: Categorie[] = [];
  private keyword: string = '';

  constructor(private produitService: ProduitService,
              private categorieService: CategorieService) {
  }

  ngOnInit(): void {
    this.produits$  = this.wordSubject.pipe(
      debounceTime(1000),
      //distinctUntilChanged(),
      tap( word=> console.log(word)),
      switchMap((word, index)=> {
        this.keyword = word;
        return this.getProduitsObservable();
      }),
      map(response=> {
        this.size = response.size;
        this.currentPage = response.number;
        this.totalElements = response.totalElements;
        this.totalPages = Array.from(Array(response.totalPages).keys());
        return response
      })
    );

    console.log(this.produits$);
    this.getAllCategories();
  }

  getProduitsObservable() :Observable<ApiResponse<Produit>>{
    console.log(this.currentPage);
    console.log(this.size);
    return this.produitService.getProduitsByKeyWord({page: this.currentPage, size: this.size}, this.keyword);
  }

  changePageSize() {
    console.log(this.size);
    this.searchProduits(this.keyword);
    this.getProduitsObservable();
  }
  changePage(page:number) {
    console.log(this.size);
    console.log(this.currentPage + page >= 0 && this.currentPage + page < this.totalPages.length);
    console.log(this.currentPage);
    console.log(this.totalPages)
    if (this.currentPage + page >= 0 && this.currentPage + page < this.totalPages.length){
      this.currentPage += page;
      //this.getInitialProducts();
      this.searchProduits(this.keyword);
      this.getProduitsObservable();
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

  searchProduits(searchWord: string) {
    console.log(searchWord);
    this.wordSubject.next(searchWord);
    console.log(this.wordSubject);
    //this.currentPage = 0;
  }
}
