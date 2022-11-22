const add = (x,y)=>x+y;
const sous = (x,y)=>x-y;
const multi = (x,y)=>x*y;
const max = (x,y)=>{
    let max =x;
    if(y>=max)
        max =y
    
        return max;
};

export {add,sous,multi,max}

export function initialisation(tab){
    for(let i =0;i<10;i++)
        tab.push(i);
}

