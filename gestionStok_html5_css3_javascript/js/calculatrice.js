const buttons = document.querySelectorAll('.btn');
let result = new String('0');
let opreation = false;
let parentesOpen = false;
let oprationArray = ['+', '-', '*', '/'];
let numberArray = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
console.log(buttons);

//buttons[0].innerHTML = 23233000988887777688654545569775409812*43456 ;
//buttons[0].style.fontSize = '.5rem'
let lastNumber = 0;

const calculer = (event) => {
    console.log(event.target.innerHTML);
    const value = event.target.innerHTML;
    //console.log(numberArray.includes(value));
    const resultArray = Array.from(result);
    console.log(numberArray.includes(value) && !checkPointExists());
    if ((numberArray.includes(value) && !errorCase(value))  || (value == '.' && !checkPointExists())) {
        console.log(value);
        if(resultArray[resultArray.length - 1] == ')'){
            opreation = false;
            return;
        }
        if (value == '.') lastNumber = value;
        if(result == '0') result = '';
        if(result == '' && value == '.'){
            console.log('0'.concat(value).concat('0'))
            result = '0'.concat(value).concat('0');
        }else {
            result = result + ''.concat(value);
        }    
        buttons[0].innerHTML = result;
        opreation = false;        
    } else {
        switch (value) {
            case '+':
                if (!opreation)
                result = result + value;
                lastNumber == value;
                opreation = true;
                console.log(result)
                break;
            case '-':
                if (!opreation)
                    result = result + value;
                lastNumber == value;
                opreation = true;
                break;
            case 'x':
                if (!opreation)
                    result = result + '*';
                lastNumber == value;
                opreation = true;
                break;
            case '/':
                if (!opreation)
                    result = result + value;
                lastNumber == value;
                opreation = true;
                break;
            case '(':
                if(!parentesOpen && result.slice(-1) != '(' && 
                   result+''.slice(-1) != ')' && oprationArray.includes(result.slice(-1)) ){
                    result = result + value;
                    lastNumber == value;
                    opreation = true;
                    parentesOpen = true;
                }else if(result == '0' || result == '') {
                    result = value;
                    parentesOpen = true;
                }
                break;
            case ')':
 
                if(parentesOpen && result.slice(-1) != '(' && 
                 result.slice(-1) != ')' && !opreation){
                    result = result + value;
                    lastNumber == value;
                    opreation = false;
                    parentesOpen = false;
                }
                break;
            default:
                break;

        }
        buttons[0].innerHTML = result;
    }
    // aficher
    if (result == '0') {
        result = '0';
        buttons[0].innerHTML = result;
    }
    if (result.length > 36) {
        buttons[0].style.fontSize = '.8rem'
    }
}

const remove = () => {
    console.log(result.length);
    if (result.length == 1) result = '0';
    if(result.length == 1 || result[0] == '0') {
        result = '0';
        buttons[0].innerHTML = result;
        return;
    };
    result = new String(result);
    console.log(result);
        result = result.slice(0, result.length -1);
    if(result.slice(-1) >= 0 && result.slice(-1) <= 9 && !result.slice(-1) == '.')
    { opreation == false}
    else { opreation = true;}
    if(result.length == 0) {
        result = '0';
        opreation = false;
    }
    buttons[0].innerHTML = result;
}
const getResult = () => {
    console.log(result);
     if((result.slice(-1) >= 0 && result.slice(-1) <= 9) || !oprationArray.includes(result.slice(-1))){
        result = eval(result);
        result = new String(result);
        buttons[0].innerHTML = result;
        opreation = false;
     }   
}

const checkPointExists = ()=> {
    const resultArray = Array.from(result);
    console.log(resultArray.indexOf('.'));
    return resultArray.indexOf('.') >= 0;
}

const errorCase = (value) => {
    const resultArray = Array.from(result);
    console.log(resultArray)
    if(resultArray.length == 0){
        resultArray[0] = '0';
    }
    let error = false;
    // cas ajout d'un point si il existe déjà 
    error = (resultArray.includes('.') && value == '.');
    console.log(error);
    if(error){
        return error;
    }
    // cas size = 0 et ajout de 0
    error = (resultArray[0] == '0' && resultArray.length == 1) && value == '0';
    if(error){
        return error;
    } 
    console.log(error);
    // ajout 0 après un opérateur
    error = oprationArray.includes(resultArray[resultArray.length - 1]) && value == '0'; 
    console.log(error)
    if(error){
        return error;
    }
     // ajout 0 après un nombre
     error = !((resultArray.length >= 1 && value == '0') || numberArray.includes(value)); 
     console.log(error)
     if(error){
         return error;
     } 
     // ne pas ajouter si il y a ( ) a la fin de resultats (oprationArray.includes(result+''.slice(-1))) 
    //  error = (resultArray[resultArray.length - 1] == ')') ;
    //  if(error){
    //     return error;
    //  }
    
    return error;
}

const addParaentes = (value)=> {
    if(value == '(' && !parentesOpen){

        parentesOpen = true;
    }else if(value == ')' && parentesOpen){

        parentesOpen = false;
    }
}

const changeOpreator = (value)=> {
    let resultArray = Array.from(result);
    console.log(resultArray.slice(resultArray.length -1, resultArray.length));
    if(value == resultArray.slice(resultArray.length -1, resultArray.length) && oprationArray.includes(value)){
        resultArray.slice(0, result.length -1);
        resultArray.push(value);
        result = resultArray.join('');
        console.log(resultArray);
        console.log(result);
        buttons[0].innerHTML = result;
    }
}

