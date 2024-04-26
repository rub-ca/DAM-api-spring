const liPut = document.querySelector("#li-put")
const liPost = document.querySelector("#li-post")
const liDelete = document.querySelector("#li-delete")

const formPut = document.querySelector("#form-put")
const formPost = document.querySelector("#form-post")
const formDelete = document.querySelector("#form-delete")

liPut.addEventListener("click", () => {
    setFormsOff()
    desactivarTodos()
    formPut.classList.remove("no-mostrar")
    liPut.classList.add("activado")
})

liPost.addEventListener("click", () => {
    setFormsOff()
    desactivarTodos()
    formPost.classList.remove("no-mostrar")
    liPost.classList.add("activado")
})

liDelete.addEventListener("click", () => {
    setFormsOff()
    desactivarTodos()
    formDelete.classList.remove("no-mostrar")
    liDelete.classList.add("activado")
})

function setFormsOff() {
    formPut.classList.add("no-mostrar")
    formPost.classList.add("no-mostrar")
    formDelete.classList.add("no-mostrar")
}
function desactivarTodos() {
    liPut.classList.remove("activado")
    liPost.classList.remove("activado")
    liDelete.classList.remove("activado")
}