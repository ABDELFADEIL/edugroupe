
/***********************JQuery*****************************************/
$(document).ready(function(){

    //1-    Création et initialisation du tableau de compte
    let comptes = [
        {login:"bart@yahoo.fr",password:"Test1234"},
        {login:"lisa@yahoo.fr",password:"Test1234"},
        {login:"omer@yahoo.fr",password:"Test1234"}
    ];

    // 2- fonction verifCompte

    function verifCompte(){
        //2-1   Sélection des éléments inputs pour login et password
            let login = $('#txtLogin').val();
            let pwd = $('#txtPwd').val();
            let existe = false;

        // 2-2  Recherche du login et pwd dans le tableau

            // for(let i=0;i<comptes.length && !existe ;i++){
            //     if(comptes[i].login == login && comptes[i].password == pwd){
            //          existe = true;   
            //     }
            // }
            let compte = comptes.find((elt)=>(elt.login == login && elt.password == pwd));
       
        // 2-3 Test de la variable existe
            // if(existe)
            if(compte != undefined)
                $('span').html("<Strong> Connexion </strong>").css('color','red');
            else
                $('span').html("<Strong> Wrong Values </strong>").addClass('btn-danger');
    }
    //3- Sélection du bouton + ajout de l'évènement click
        // $('#btnConnexion').click(verifCompte);

         $('#btnConnexion').on("click",verifCompte);
         $('#btnReset').on("click",()=>{
            $('span').text('')
         });
    //4-    fonction liste des comptes
         function listeCompte(comptes){
            $('table').remove();
            //4- création du noeud Table
            let nodes = $("<table> <tr><th>LOGIN</th><th>PASSWORD</th></tr></table>");

            // ajout du tableau
            $('body form').append(nodes);

            // parcours du tableau 
            for(let i=0;i<comptes.length;i++){
                
                let chaine ="<tr><td>" + comptes[i].login + "</td><td>" + comptes[i].password +"</td></tr>";

                $('table').append(chaine);
            }
            //Ajout des classes bootstrap au tableau
            $('table').addClass('table');
            $('table').addClass('table-hover');
            $('table').addClass('mt-5');
         }
         listeCompte(comptes);
    //5-    Création d'un compte
    
         $('#btnCreate').on('click',function(){
            //5-1   Sélection des champs
                let login = $('#txtLogin').val();
                let pwd = $('#txtPwd').val();
            //5-2 test du contenu des champs
            if(login.length == 0 && pwd.length==0){
                $('span').html("<Strong> Remplir les Champs S.V.P </strong>").css('color','red');
            }else{
                // Vérifie l'existence de ce compte dans la base

                if(comptes.find((elt)=>(elt.login == login)) != undefined){
                    $('span').html("<Strong> Ce compte existe déjà dans la base </strong>").css('color','red');
                }else{
                    comptes.push({login:login,password:pwd});
                    // let chaine ="<tr><td>" + login + "</td><td>" + pwd +"</td></tr>";
                    // $('table').append(chaine);
                    listeCompte(comptes);
                }      
            }
            // Appel de la fonction
         })
})


