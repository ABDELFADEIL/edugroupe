import {Component, EventEmitter, OnInit, Output, SimpleChanges} from '@angular/core';
import {BehaviorSubject, map, Observable, of, shareReplay, switchMap, tap} from "rxjs";
import {ApiResponse} from "../../models/apiResponse";
import { faChevronDown, faChevronLeft, faChevronRight, faPlus, faSyncAlt, faTrashAlt }
  from "@fortawesome/free-solid-svg-icons";
import {Produit} from "../../produits/produit";
import {Categorie} from "../../produits/categorie";
import {ProduitService} from "../../produits/produit.service";
import {CategorieService} from "../../produits/categorie.service";
import {Client} from "../models/Client";
import {UtilisateurService} from "./service/utilisateur.service";
import {Utilisateur} from "../../models/utilisateur";



@Component({
  selector: 'app-admin-client',
  templateUrl: './admin-client.component.html',
  styleUrls: ['./admin-client.component.css']
})
export class AdminClientComponent implements OnInit {

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
  wordSubject = new BehaviorSubject<string>('');
  @Output() onChange: EventEmitter<Utilisateur> = new EventEmitter();
  utilisateur: Utilisateur | undefined;
  private utilisateurs: Client[] = [];
  private keyword: string = '';

  update: boolean = false;
  clients$: Observable<ApiResponse<Client[]>> = of(<ApiResponse<Client[]>>{});
  constructor(private clientService: UtilisateurService) {
  }

  ngOnInit(): void {
    this.clients$ = this.wordSubject.pipe(
      //debounceTime(500),
      //distinctUntilChanged(),
      tap(word => console.log(word)),
      switchMap((word, index) => {
        this.keyword = word;
        return this.getClientsObservable();
      }),
      map(response => {
        this.size = response.size;
        this.currentPage = response.number;
        this.totalElements = response.totalElements;
        this.totalPages = Array.from(Array(response.totalPages).keys());
        return response
      }),
      shareReplay()
    );
    console.log(this.clients$);
  }

  getClientsObservable(): Observable<ApiResponse<Client>> {
    return this.clientService
      .getClientsByKeyWordPagination({page: this.currentPage, size: this.size, keyword: this.keyword});
  }

  changePageSize() {
    console.log(this.size);
    this.searchClients(this.keyword);
    this.getClientsObservable();
  }

  changePage(page: number) {
    if (this.currentPage + page >= 0 && this.currentPage + page < this.totalPages.length) {
      this.currentPage += page;
      //this.getInitialProducts();
      this.searchClients(this.keyword);
      this.getClientsObservable();
    }
  }



  onChangeClient(utilisateur: Utilisateur | undefined): void {
    this.updateAdd = true;
    this.utilisateur = utilisateur;
    this.onChange.emit(this.utilisateur);
  }

  ngOnChanges(changes: SimpleChanges): void {
    //console.log(changes);
  }

  setUpdateAdd(update: boolean) {
    this.update = update;
  }

  searchClients(searchWord: string) {
    this.wordSubject.next(searchWord);
  }

  deleteProduct(clientId: number) {
    this.clientService.deleteClient(clientId)
      .subscribe((response: Client) => {
        console.log('delete response: ', response);
      })
  }

  toggleModal(utilisateur: Utilisateur | undefined) {
    this.utilisateur = utilisateur;
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
      this.toggleModal(this.utilisateur);
    }
  }
}
