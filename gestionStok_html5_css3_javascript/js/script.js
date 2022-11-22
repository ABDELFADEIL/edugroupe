console.log('script recharger !');
// récupérer les formulaires et les stocker dans des variables

const loginForm = document.getElementById('login');
const signupForm = document.getElementById('signup');
const registered = document.getElementById('registred');
const boxSignup = document.getElementById('box');
const messageError = document.getElementById('message');// message
const host = 'http://localhost:8080/api/';
// login fonction
const login = (e) => {
    console.log('function login !');
    //loginForm.addEventListener('submit', (e)=> {
    e.preventDefault();
    const email = loginForm.email.value;
    const password = loginForm.password.value;
    console.log(email, password)
    // send to server
    fetch(host + 'auth/login', {
        method: 'POST',
        body: JSON.stringify({
            "email": email,
            "password": password
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then((response) => {
        return response.json();
    })
        .then(function (data) {
            console.log(data);
            if (data != undefined) {
                saveToken(data.accessToken);
                document.location.href = "/html/index.html";
            }
        })
        .catch(error => {
            console.log(error)
            messageError.style.display = "block";
            setTimeout(function () { messageError.style.display = "none"; }, 10000);
        });

    console.log(getToken())

};

const saveToken = (token) => { window.localStorage.setItem('token', token); }
const getToken = () => { 
    const token = window.localStorage.getItem('token');
    if(!token){
        return null;
    }
    return "Bearer " + token; 
}

// signup fonction
const signup = (e) => {
    e.preventDefault();
    const signupForm = document.forms["signup"];
    console.log('function signup !');
    var formData = new FormData(signupForm);
    var object = {"roleName": "USER"};
    formData.forEach((value, key) => {
        if(!(new String(key) === new String("rePassword"))){
            object[key] = value;
        }else  if(key == 'dateNaissance'){
            object[key] = formatDate(value); 
        }
    });
    var json = JSON.stringify(object);
    console.log(json);
    for (var [key, value] of formData) {
        console.log(key, value)
    }
    fetch(host + 'auth/register', {
        method: 'POST',
        body: json,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then((response) => {
        if (response.ok) {
            return response.json();
          }
          throw new Error(res.statusText);
    })
        .then((data) => {
            console.log(data);
            if (data != undefined) {
                signupForm.style.display = "none";
                boxSignup.style.minHeight = "auto";
                registered.style.display = "inline-block";
            }
        })
        .catch(error => {
                console.log(error);
            messageError.style.display = "block";
            setTimeout(function () { messageError.style.display = "none"; }, 5000);
        });
};

const formatDate = (date) =>{
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}

const isLogin = () =>{ 
    if(document.location.href == '/html/login.html'){
        if(getToken != undefined){
            document.location.href = '/html/profile.html'
        }
    }
}
const isNotLogin = () =>{ 
    if(document.location.href == '/html/profile.html'){
        if(getToken == undefined){
            document.location.href = '/html/login.html';
        }
    }
}

const logout = () => {
    console.log("logout !");
     let logIcon = document.getElementById("logIcon");
    if(logIcon.classList[1] == 'fa-power-off'){
        window.localStorage.removeItem('token');
        logIcon.classList.add('fa-user-circle');
        logIcon.classList.remove('fa-power-off');
        document.location.href = '/html/login.html';
    }
    
}

const setIcon = () => {
    console.log("auto execution !");
    console.log(getToken())
    console.log(getToken())
    if(!getToken()){
        logIcon.classList.add('fa-user-circle');
        logIcon.classList.remove('fa-power-off');
    }else {
        logIcon.classList.add('fa-power-off');
        logIcon.classList.remove('fa-user-circle');

    }
 
};
setIcon();
isLogin();
isNotLogin();


// Labo 1
const isAllTableElementsPositif = (table) => {
    return table.find(element => (element < 0)) < 0;
}
const myTable = [2, 5 , -8, 6, -9];
console.log(isAllTableElementsPositif(myTable));

// Labo 2
const myTable2 = [2, 5 , -8, 6, 9, 4]
const getSumOfOdd = (table) => {
    let sum = 0;
    table.forEach(element => {
        if((element % 2 == 0)){
            sum += element;
        }
    });
    return sum;
}
console.log(getSumOfOdd(myTable2));

//Labo 3 -1
const dispalyByRow = (table)=> {
    for(let i = 0; i < table.length; i++){
        console.log(table[i]);
    }
}

//Labo 3 -2
const dispalyByColumn = (table)=> {
    let column = 0;
    for(let column = 0; column < table.length; column++){
        const newColumn = table.filter((element, index)=> {
            console.log(element, index);
            const col = element[index, column];
            console.log("colonne =", col);
            return col;
    
        });
        console.log(newColumn);
    }
}

// Labo 4 - 1
const tableBlackWight1 = (size) => {
    let martix = new Array(size);
    for(i = 0; i < size; i++){
        martix[i] = new Array(size);
        for(x = 0; x < size; x++){
            if(i === x){
                martix [i][x] = "NOIR";
            }else{
                martix [i][x] = "BLANC";
            }
        }   
    }
    console.table(martix);
    return martix;
}

// Labo 4 - 2
const tableBlackWight2 = (size) => {
    let martix = new Array(size);
    for(i = 0; i < size; i++){
        martix[i] = new Array(size);
        for(x = 0; x < size; x++){
            if(i === x || i == 0 || i == (size - 1)){
                martix [i][x] = "NOIR";
            }else{
                martix [i][x] = "BLANC";
            }
        }   
    }
    console.table(martix);
}
// Labo 4 - 3
const tableBlackWight3 = (size) => {
    let martix = new Array(size);
    for(i = 0; i < size; i++){
        martix[i] = new Array(size);
        for(x = size; x > 0; x--){
            if(i === size - x){
                martix [i][x] = "NOIR";
            }else{
                martix [i][x] = "BLANC";
            }
        }   
    }
    console.table(martix);
}

//tableBlackWight1(10);
//tableBlackWight2(10);
//tableBlackWight3(10);

// Labo 5 
const tableCourse = (table) => {
    let nbStudants = 0;
    for(let i = 0; i < table.length; i++){
        const total = table[i].reduce((a, b) => a + b, 0);
        const moyen = total / (table[i].length * 20) * 100;
        if(moyen > 50){
            nbStudants = nbStudants + 1;
        }
    }
    const percentOfStudants = (nbStudants / table.length) * 100;
    const number = Math.round(percentOfStudants * 100) / 100;
    console.log('Pourcentage des étudiants ayant obtenu plus de 50% = ', number + "%");
    return number;
}

const notesEtudiants = [
    [20, 15, 12, 16, 19],
    [19, 18, 20, 13, 9],
    [8, 16, 11, 9, 11],
    [15, 6, 9, 12, 7],
    [11, 10, 7, 10, 5],
    [11, 3, 7, 17, 13],
    [20, 15, 12, 16, 19],
    [19, 18, 20, 13, 9],
    [8, 16, 11, 9, 11],
    [15, 6, 9, 12, 7],
    [11, 10, 7, 10, 5],
    [11, 3, 7, 17, 13]
]

//tableCourse(notesEtudiants);
//console.log("Exo 3");
//const myTable3 = tableBlackWight1(10);
//dispalyByRow(myTable3);
//console.log("dispalyByColumn");
//dispalyByColumn(myTable3);

const calculatrice = ()=> {
    document.location.href = "/html/exercie_dom.html";
}