import { ChangeDetectionStrategy, Component, EventEmitter, OnChanges,
  OnInit, Output, SimpleChanges} from '@angular/core';
import {ProduitService} from "../../produits/produit.service";
import {Produit} from "../../produits/produit";
import { faChevronDown, faChevronLeft, faChevronRight, faPlus, faSyncAlt,
  faTrashAlt} from "@fortawesome/free-solid-svg-icons";
import {Categorie} from "../../produits/categorie";
import {CategorieService} from "../../produits/categorie.service";
import {BehaviorSubject, map, Observable, of, shareReplay, switchMap, tap} from "rxjs";
import {ApiResponse} from "../../models/apiResponse";

@Component({
  selector: 'app-admin-produit',
  templateUrl: './admin-produit.component.html',
  styleUrls: ['./admin-produit.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AdminProduitComponent implements OnInit, OnChanges{
  faPlus = faPlus;
  faChevronDown = faChevronDown;
  faChevronLeft = faChevronLeft;
  faChevronRight = faChevronRight;
  faTrashAlt = faTrashAlt;
  faSync = faSyncAlt;
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
      //debounceTime(500),
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
      }),
      shareReplay()
    );

    console.log(this.produits$);
    this.getAllCategories();
  }

  getProduitsObservable() :Observable<ApiResponse<Produit>>{
    return this.produitService
      .getProductsByKeyWordPagination({page: this.currentPage, size: this.size, keyword: this.keyword});
  }

  changePageSize() {
    console.log(this.size);
    this.searchProduits(this.keyword);
    this.getProduitsObservable();
  }
  changePage(page:number) {
    if (this.currentPage + page >= 0 && this.currentPage + page < this.totalPages.length){
      this.currentPage += page;
      //this.getInitialProducts();
      this.searchProduits(this.keyword);
      this.getProduitsObservable();
    }
  }

  getAllCategories(){
    this.categorieService.getCategories().subscribe(
      (response)=> {
        this.categories = response;
        //console.log(this.categories);
      }
    )
  }

  onChangeProduit(produit: Produit | undefined):void {
      this.updateAdd = true;
      this.produit = produit;
      this.onChange.emit(this.produit);
  }

  ngOnChanges(changes: SimpleChanges): void {
    //console.log(changes);
  }

  searchProduits(searchWord: string) {
    this.wordSubject.next(searchWord);
  }
  deleteProduct(productId: number){
    this.produitService.deleteProduct(productId)
      .subscribe((response)=> {
        console.log('delete response: ', response);
      })
  }


   toggleModal(produit: Produit | undefined) {
    this.produit = produit;
     const modalId = "modal";
     const modal = <HTMLElement>document.getElementById(modalId);

    if(getComputedStyle(modal).display==="flex") { // alternatively: if(modal.classList.contains("modal-show"))
      modal.classList.add("modal-hide");
      setTimeout(() => {
        document.body.style.overflow = "initial"; // Optional: in order to enable/disable page scrolling while modal is hidden/shown - in this case: "initial" <=> "visible"
        modal.classList.remove("modal-show", "modal-hide");
        modal.style.display = "none";
      }, 200);
    }
    else {
      document.body.style.overflow = "hidden"; // Optional: in order to enable/disable page scrolling while modal is hidden/shown
      modal.style.display = "flex";
      modal.classList.add("modal-show");
    }
  }

  closeModal(event: MouseEvent) {
    if ((event.target as HTMLElement).classList.contains("modal")) {
      this.toggleModal(undefined);
    }
  }
}
