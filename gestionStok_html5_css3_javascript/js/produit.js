
const token = "Bearer " + window.localStorage.getItem('token');



const getProduits = ()=> {
   
    fetch(host + 'produits', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': token
        }
    }).then((response) => {
        return response.json();
    })
        .then(function (data) {
            console.log(data);
            if (data != undefined) {
                console.log(data);
                //profile.innerHTML = data.nom + ' ' + data.prenom;
            }
        })
        .catch(error => {
            console.log(error);
            //window.localStorage.removeItem('token')
            //document.location.href = '/html/login.html';
        });

};

getProduits();
