import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import { faChevronDown } from "@fortawesome/free-solid-svg-icons";
import {UtilisateurService} from "../admin-client/service/utilisateur.service";
import {Role, Utilisateur} from "../../models/utilisateur";
import {Produit} from "../../produits/produit";
import {Observable} from "rxjs";
import {Categorie} from "../../produits/categorie";


@Component({
  selector: 'form-client',
  templateUrl: './form-client.component.html',
  styleUrls: ['./form-client.component.css']
})
export class FormClientComponent implements OnInit, OnChanges{

  @Output() toggleModal = new EventEmitter<void>();
  validated: boolean = false;
  faChevronDown = faChevronDown;
  @Input() utilisateur: Utilisateur | undefined;
  roles: Set<Role> | undefined;
  selectedRole: Role | undefined;
  constructor(private clientService: UtilisateurService) {
  }
  ngOnInit(): void {
    this.getRoles();
    if (!this.utilisateur){
      this.utilisateur = new Utilisateur();
    }

  }

  onSubmit(formValue:any) {
    console.log(formValue);
    console.log(this.utilisateur);
    if(this.utilisateur)
      this.clientService.updateAddClient(this.utilisateur).subscribe(
        (response)=> {
          console.log(response);
          this.closeModal();
        }
      )
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
    if (changes['utilisateur'].currentValue == undefined){
      this.utilisateur = new Utilisateur();
      let roles = new Array<Role>()
      this.utilisateur.roles = roles;
    } else {
      this.utilisateur = changes['utilisateur'].currentValue;
    }
    console.log(this.utilisateur);
  }

  getRoles(){
    this.clientService.getRoles().subscribe(
      (roles)=> {
        this.roles = roles;
        this.selectedRole = roles[1];
      }
    )
  }
  closeModal() {
    this.toggleModal.emit();
  }

  changeRole() {
    console.log(this.selectedRole);
    if(!!this.utilisateur && this.selectedRole){
      let role: Role | undefined = this.utilisateur.roles.find(role=> role.authority === this.selectedRole?.authority);
      if(!role){
        this.utilisateur.roles.push(this.selectedRole);
      }

    }
    console.log(this.utilisateur);
  }
}
