function unePartie(){
    document.getElementsByTagName("iframe")[0].setAttribute("src", "./assets/unePartie.txt");
    changeColor();
}
function multPartie(){
    //populatePre('./assets/stats500.txt');
    document.getElementsByTagName("iframe")[0].setAttribute("src", "./assets/stats500.txt");
    changeColor();
}
function changeColor(){
    let doc = document.getElementsByTagName("iframe");
    doc[0].style.backgroundColor = "#FFFFFF";
}