import {Component, OnInit} from '@angular/core';
import {ProduitService} from "../produit.service";
import { faCartPlus } from '@fortawesome/free-solid-svg-icons';
import {Produit} from "../produit";
import {Router} from "@angular/router";
import {Categorie} from "../categorie";
import {CategorieService} from "../categorie.service";

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit{

  faCartPlus = faCartPlus;
  produits: Produit [] | undefined;
  months = ["1", "2", "3", "4"]
  private page: number = 0;
  private size: number = 100;
  private keyword: string = '';
  categories: Array<Categorie> | undefined;
  constructor(private produitService: ProduitService,
              private router: Router, private categorieService: CategorieService) {
  }

  ngOnInit(): void {
    this.getCategories();
    console.log(this.months[Math.floor(Math.random() * this.months.length)]);
    this.getProduct();
  }

  getProduct(){
    this.produitService
      .getProductsByKeyWordPagination(
        {page: this.page, size: this.size, keyword: this.keyword}, undefined)
      .subscribe( // {page:0, size:10}
      (response)=> {
        this.produits = response.content;
        console.log(this.produits)
      }
    )
  }

  detailProduit(id:any) {
    this.router.navigate(['/produits', id])
  }
  getProductByCategorie(categoryId:number){
    console.log(categoryId)
    this.produitService.getProductsByKeyWordPagination({page: this.page, size: this.size, keyword: this.keyword}, categoryId).subscribe( // {page:0, size:10}
      (response)=> {
        this.produits = response.content;
        console.log(this.produits)
      }
    )
  }

  getCategories(){
    this.categorieService.getCategories().subscribe(
      (categories)=>
      {
        this.categories = categories;
        console.log(categories);
      }
    )
  }
}
