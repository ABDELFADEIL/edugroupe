export class Role {
  id?: number;
  authority?: string;
}

export class Utilisateur{
  id: number = 0;
  nom?: string;
  prenom?:string;
  adresse?: string;
  dateNaissance?: string;
  email?: string
  password?: string;
  roles: Array<Role> = new Array<Role>()
}
