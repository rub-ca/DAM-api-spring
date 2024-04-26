const liEmp = document.querySelector("#li-emp")
const liDept = document.querySelector("#li-dep")
const liJob = document.querySelector("#li-job")
const liDet = document.querySelector("#li-det")

const arraySoloRuta = document.getElementsByClassName("solo-ruta")
const arrayIdRuta = document.getElementsByClassName("id-ruta")

const metGet = document.getElementsByClassName("met-get")[0]
const metPost = document.getElementsByClassName("met-post")[0]
const metPut = document.getElementsByClassName("met-put")[0]
const metDelete = document.getElementsByClassName("met-delete")[0]

const liEditar = document.getElementById("li-editar")
const liMostrar = document.getElementById("li-mostrar")

liEditar.addEventListener("click", () => {
    window.location.href = "/edit/job"
})
liMostrar.addEventListener("click", () => {
    window.location.href = "/show/job"
})

liEmp.addEventListener("click", () => {
    mostrarTodo()
    desactivarTodos()

    liEmp.classList.add("activado")

    for (const c of arrayIdRuta) {
        c.innerHTML = "/employees/{id}"
    }

    for (const c of arraySoloRuta) {
        c.innerHTML = "/employees"
    }
})


liDept.addEventListener("click", () => {
    mostrarTodo()
    desactivarTodos()

    liDept.classList.add("activado")

    for (const c of arrayIdRuta) {
        c.innerHTML = "/departments/{id}"
    }

    for (const c of arraySoloRuta) {
        c.innerHTML = "/departments"
    }
})


liJob.addEventListener("click", () => {
    mostrarTodo()
    desactivarTodos()

    liJob.classList.add("activado")

    for (const c of arrayIdRuta) {
        c.innerHTML = "/jobs/{id}"
    }

    for (const c of arraySoloRuta) {
        c.innerHTML = "/jobs"
    }
})

liDet.addEventListener("click", () => {
    desactivarTodos()

    liDet.classList.add("activado")

    //tituloSeccion.innerHTML = "detailed"

    metDelete.classList.add("no-mostrar")
    metPut.classList.add("no-mostrar")
    metPost.classList.add("no-mostrar")

    for (const c of arraySoloRuta) {
        c.classList.add("no-mostrar")
    }
    for (const c of arrayIdRuta) {
        c.innerHTML = "/detailed/{id}"
    }

})

// Tools
function mostrarTodo() {
    metDelete.classList.remove("no-mostrar")
    metPut.classList.remove("no-mostrar")
    metPost.classList.remove("no-mostrar")
    for (const c of arraySoloRuta) {
        c.classList.remove("no-mostrar")
    }
}

function desactivarTodos() {
    liEmp.classList.remove("activado")
    liDept.classList.remove("activado")
    liJob.classList.remove("activado")
    liDet.classList.remove("activado")
}