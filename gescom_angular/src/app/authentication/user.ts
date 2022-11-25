export class User{

    id: number;
    nom: string;
    prenom: string;
  dateNaissance: Date;
    email: string;
    password: string;
    adresse: string;
    roleName: string;


  constructor(id: number, nom: string,
              prenom: string, dateNaissance: any,
              email: string, password: string,
              adresse: string, roleName: string) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
    this.email = email;
    this.password = password;
    this.adresse = adresse;
    this.roleName = roleName;
  }
}
