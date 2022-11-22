const profile = document.getElementById('profile');
const nom = document.getElementById('nom');
const prenom = document.getElementById('prenom');
const dateNaissance = document.getElementById('dateNaissance');
const email = document.getElementById('email');
const adresse = document.getElementById('adresse');
const emailInput = document.getElementById('emailInput');
const addressInput = document.getElementById('addressInput');
const token = "Bearer " + window.localStorage.getItem('token');

let currentUser;

const getCurrentUser = () => {
    
    fetch(host + 'auth/current-user', {
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
                currentUser = data;
                console.log(data);
                displayUserInfo(data)
                //profile.innerHTML = data.nom + ' ' + data.prenom;
            }
        })
        .catch(error => {
            console.log(error);
            window.localStorage.removeItem('token')
            document.location.href = '/html/login.html';
        });

};

const displayUserInfo = (user)=> {
    currentUser = user;
    nom.innerHTML = user.nom;
    prenom.innerHTML = user.prenom;
    dateNaissance.innerHTML = user.ddnClient;
    email.innerHTML = user.email;
    adresse.innerHTML = user.adresse;
}

const updateEmail = ()=> {
    const email = document.getElementById('updateEmail');
    const adresse = document.getElementById('updateAddress');
    console.log(currentUser)
    emailInput.value = currentUser.email;
    console.log(email.style.display)
    if(email.style.display == "none" || email.style.display == ""){
        email.style.display = "flex";
    }
    else{
        email.style.display = "none";
    }
       adresse.style.display = "none";

    
}
const updateAddress = ()=> {
    const adresse = document.getElementById('updateAddress');
    const email = document.getElementById('updateEmail');
    addressInput.value = currentUser.adresse;
    console.log(adresse.style.display)
    if(adresse.style.display == "none" || adresse.style.display == ""){
        adresse.style.display = "flex";
    }
    else {
        adresse.style.display = "none";
    }
    email.style.display = "none";
}

const sendUpdateEmail = ()=> {
    console.log(emailInput.value);
    currentUser.email = emailInput.value;
    fetch(host + 'auth/update', {
        method: 'PUT',
        body: JSON.stringify(currentUser),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': getToken()
        }
    }).then((response) => {
        return response.json();
    })
        .then(function (data) {
            console.log(data);
            updateEmail();
            currentUser = data;
            email.innerHTML = data.email;
        })
        .catch(error => {
            console.log(error);
        });


};


const sendUpdateAddress = ()=> {
    console.log(addressInput.value);
    currentUser.adresse = addressInput.value;
    fetch(host + 'auth/update', {
        method: 'PUT',
        body: JSON.stringify(currentUser),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': getToken()
        }
    }).then((response) => {
        return response.json();
    })
        .then(function (data) {
            console.log(data);
            updateAddress();
            currentUser = data;
            adresse.innerHTML = data.adresse;
        })
        .catch(error => {
            console.log(error);
        });


};

getCurrentUser();

// dom manipulation
// let h2 = document.querySelector('h2');
// document.body.appendChild(h2);

// // 
// let newPara = document.createElement('p');
// console.log(newPara);
// newPara.textContent = 'My new para';
// document.body.appendChild(newPara , h2);

// let titre2 = document.createElement('h3');
// console.log(titre2);

// let contentuTitre2 = document.createTextNode(h2.innerHTML);
// titre2.appendChild(contentuTitre2);
// document.body.replaceChild(titre2, h2);
// titre2.onclick = (e)=> console.log(e);