/*1-    les méthodes de sélection
        - getElementById(id)
        - getElementsByTagName()

*/
// 1-1 : premier sélecteur
    let titre = document.getElementById("titre1");
        console.log(titre);
        /* Gestion du contenu de l'élément
            -innerHTML
            -innerText
        */
    // exemple de lecture (getteur)
    console.log(titre.innerText)
    // exemple de modification (setteur)
    titre.innerHTML += ": <strong>Document Object Model</strong>"
// 1-2 : deuxième sélecteur : retourne une liste de paragraphe de type noeud
        let tabPara =document.getElementsByTagName('p');
        console.log(tabPara);

        //parcours de la liste de paragraphe
        for(let i=0;i<tabPara.length;i++)
            console.log(tabPara[0]);

        for(let item of tabPara)
            console.log(item);

        /* conversion de la liste de type HTMLcollection en Array,
            pour rendre possible l'utilisation des méthodes
            de manipulation des tableaux. exemples de méthodes: 
            ForEach; map ; filter; reduce ...
        */
        let tab = Array.from(tabPara);

        tab.map(elt=>elt.innerText).forEach(element => {
            console.log(element); 
        });
// 1-3 : troisième sélecteur : retourne une liste de paragraphe de type noeud
        let tabDiv = document.getElementsByClassName("division");

        let arrayDivs = Array.from(tabDiv);

        arrayDivs.map(elt=>elt.innerText).forEach(element => {
            console.log(element); 
        });

 // 1-4 : Quatrième sélecteur : retourne le premeier  respactant le sélecteur css      
    console.log(document.querySelector('p').innerText);
        //.sélecteur css de classe
    console.log(document.querySelector('.division').innerText);
        //# sélecteur css de l'id
    console.log(document.querySelector('#titre1').innerText);
      // premier élément li pair ou impair
    console.log(document.querySelector('ul li:nth-child(even)').innerText);

 // 1-4 : Quatrième sélecteur : retourne les élément respactant le sélecteur css 
        console.log(document.querySelectorAll('ul li'));
        let listeItems = document.querySelectorAll('ul li');

        for(let item of listeItems ){
            console.log(item.innerText);
        }