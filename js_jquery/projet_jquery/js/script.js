// Quelques sélécteur css complex en JQuery
/*
 - $("li:even")
 - $("li:odd")
 - $("li:lt(2)")
 - $("li:gt(2)")
 - $(":empty") // Tous les enfants qui n'ont pas de contenu
 - hide() cacher l'element sélectioné
 - show() afficher l'element sélectioné
 - toggle() cacher ou afficher l'element sélectioné
 - html()  innerHTML de l'element sélectioné
 - text() innerText de l'element sélectioné 
 - css() gérer le style l'element sélectioné
 - attr() gérer les attributs
 - val()  récupérer la valeur de l'element
 - each()  permet d'itérer sur un ensemble d'element
*/
// document.onload(
//     //alert('Wellcom to JQuery')
// );
// $(document).ready(alert('Wellcom to JQuery'))
$( document ).ready(function() {
    console.log( "ready!" );
    //alert('Wellcom to JQuery')
});
$("#btn1").click(()=> {
    $("#p").html('btn1 clicked!')
});
$("#btn2").dblclick(()=> {
    $("#p").html('btn2 double clicked!')
});

// para
$("#btn1").dblclick(()=> {
    $("#para").hide();
});
$("#btn2").click(()=> {
    $("#para").show()
});

$("#p").hover(()=> {
    $("#para").show()
});
$("#btn1").mousedown( () =>{ 
    $("#para1").hide();
});
$("#btn1").mouseup(function () { 
    $("#para1").show();
});

$("#btn1").click(() =>{ 
    console.log('=> function')
    console.log(this.document)
    $("body").css({"background-color": "#f2f2f2"});
});
$("#btn2").click(function () { 
    console.log('function normale')
    console.log(this)
    $("body").css({"background-color":"#9fe5cd"});
});