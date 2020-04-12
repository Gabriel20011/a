var list = new Array();
var pageList = new Array();
var currentPage = 1;
var numberPerPage = 50;
var numberOfPages = 1;
var contador = 0;
function loadList(arr) {
	list.push(arr)
	contador++
	if (contador == 50){
		numberOfPages++;
		contador = 0;
	}
}
function drawList(arr) {
	var body = document.getElementsByTagName("body")[0];
	var tabla   = document.createElement("table");
	var tblBody = document.createElement("tbody");
	for (let i = 0; i < arr.length; i++) {
		var hilera = document.createElement("tr");

		for (let j = 0; j < 6; j++) {
			var celda = document.createElement("td");
			var textoCelda = document.createTextNode(arr[i].split(";")[j]);
			celda.appendChild(textoCelda);
			hilera.appendChild(celda);
		}
		tblBody.appendChild(hilera);
	}

	tabla.appendChild(tblBody);
	body.appendChild(tabla);
	tabla.setAttribute("border", "2");

}

function cargarNPagina(){

	document.getElementById("nPagina").innerHTML = "Pagina: " + currentPage + " de: " + numberOfPages
}

function cargarListaP(){
	let inicio = (currentPage - 1) * 50
	let fin = currentPage * 50
	var supp1 = []
	if (list.length < 50){
		for (inicio ; inicio < list.length ; inicio ++){
			supp1.push(list[inicio])
		}
	}
	else{
		if (list.length < fin){
			for (inicio ; inicio < list.length; inicio ++){
				supp1.push(list[inicio])
			}
		}
		else{
			for (inicio ; inicio < fin ; inicio ++){
				supp1.push(list[inicio])
			}
		}
	}
	drawList(supp1)
}
function firstPage(){
	currentPage = 1;
	cargarListaP();
	cargarNPagina()
}
function lastPage() {
	currentPage = numberOfPages;
	cargarListaP();
	cargarNPagina()
}

function previousPage() {
	if (currentPage > 1)
		currentPage -= 1;
	cargarListaP();
	cargarNPagina()
}
function nextPage() {
	if (currentPage < numberOfPages)
		currentPage += 1;
	cargarListaP();
	cargarNPagina()
}