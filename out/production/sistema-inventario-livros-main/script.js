class Livro{

constructor(titulo, autor, data, localizacao, status){
this.titulo = titulo
this.autor = autor
this.data = data
this.localizacao = localizacao
this.status = status
}

}

const form = document.getElementById("formLivro")
const tabela = document.querySelector("#tabelaLivros tbody")

form.addEventListener("submit", function(e){

e.preventDefault()

let titulo = document.getElementById("titulo").value
let autor = document.getElementById("autor").value
let data = document.getElementById("data").value
let localizacao = document.getElementById("localizacao").value
let status = document.getElementById("status").value

let livro = new Livro(titulo, autor, data, localizacao, status)

adicionarLivro(livro)

form.reset()

})

function adicionarLivro(livro){

let linha = tabela.insertRow()

linha.insertCell(0).innerText = livro.titulo
linha.insertCell(1).innerText = livro.autor
linha.insertCell(2).innerText = livro.data
linha.insertCell(3).innerText = livro.localizacao

let statusCell = linha.insertCell(4)
statusCell.innerText = livro.status

if(livro.status === "Disponível"){
statusCell.classList.add("disponivel")
}

if(livro.status === "Emprestado"){
statusCell.classList.add("emprestado")
}

if(livro.status === "Manutenção"){
statusCell.classList.add("manutencao")
}

}