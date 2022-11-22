## Filter
Ecrire une un programme( app.js) qui filtre les éléments du tableau.
Ce programme doit filtrer une liste d'éléments contenant un motif.
Details:
Dans le fichier suivant `data.js`, il y a `Countries` contenant `Peoples` contenant `Animals`.
- Seuls les animaux contenant le motif passé en argument (par exemple `ry`) 
sont affichés comme dans l'exemple en dessous. 

Exemple d'exécution de la commande et de son résultat :

```shell script
$ node app.js --filter=ry
[
  {
    name: 'Uzuzozne',
    people: [
      {
        name: 'Lillie Abbott',
        animals: [
          {
            name: 'John Dory'
          }
        ]
      }
    ]
  },
  {
    name: 'Satanwi',
    people: [
      {
        name: 'Anthony Bruno',
        animals: [
          {
            name: 'Oryx'
          }
        ]
      }
    ]
  }
]
```