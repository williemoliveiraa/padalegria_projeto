// Dados do sistema - Pães cadastrados e fornadas recentes
const paoList = [];
const recentFornadas = [];

// Função para adicionar um novo pão ao sistema
function addPao(type, description, time) {
    paoList.push({ type, description, time });
}

// Função para registrar uma nova fornada
function registrarFornada(index) {
    const pao = paoList[index];
    const date = new Date();
    recentFornadas.push({ type: pao.type, description: pao.description, time: pao.time, date });
    showRecentFornadas();
}

// Função para mostrar as últimas fornadas na tela
function showRecentFornadas() {
    const breadInfo = document.getElementById("bread-info");
    breadInfo.innerHTML = "";
    recentFornadas.forEach((fornada) => {
        const now = new Date();
        const timeDiff = (fornada.date.getTime() + fornada.time * 60000) - now.getTime();
        const timeRemaining = Math.ceil(timeDiff / 1000 / 60);
        const timeDisplay = timeRemaining > 0 ? `Falta ${timeRemaining} minutos` : "Pronto!";
        const info = document.createElement("p");
        info.innerText = `${fornada.type} (${fornada.description}): ${fornada.date.toLocaleTimeString()} - ${timeDisplay}`;
        breadInfo.appendChild(info);
    });
}

// Função para criar os botões dos pães cadastrados
function createBreadButtons() {
    const breadButtons = document.getElementById("bread-buttons");
    breadButtons.innerHTML = "";
    paoList.forEach((pao, index) => {
        const button = document.createElement("button");
        button.innerText = pao.type;
        button.classList.add("bread-button");
        button.style.backgroundColor = `hsl(${index * 30}, 70%, 50%)`;
        button.addEventListener("click", () => registrarFornada(index));
        breadButtons.appendChild(button);
    });
}
// Função para criar os botões de cadastro de fornada
function createBakeButtons() {
    const breadButtons = document.getElementById("bread-buttons");
    breadButtons.innerHTML = "";
    paoTypes.forEach((type, index) => {
        const button = document.createElement("button");
        button.classList.add("bake-button");
        button.style.backgroundColor = paoColors[index];
        button.innerText = type;
        breadButtons.appendChild(button);
    });
    bindBakeButtons();
}

// Função para mostrar as últimas fornadas na tela do cliente
function showRecentFornadasCliente() {
    const breadInfo = document.getElementById("bread-info");
    breadInfo.innerHTML = "";
    recentFornadas.forEach((fornada) => {
        const now = new Date();
        const timeDiff = (fornada.date.getTime() + fornada.time * 60000) - now.getTime();
        const timeRemaining = Math.ceil(timeDiff / 1000 / 60);
        const timeDisplay = timeRemaining > 0 ? `Falta ${timeRemaining} minutos` : "Pronto!";
        const info = document.createElement("p");
        info.innerText = `${fornada.type} (${fornada.description}): ${fornada.date.toLocaleTimeString()} - ${timeDisplay}`;
        breadInfo.appendChild(info);
    });
}

// Evento de cadastro de fornada pelo cliente
function bindBakeButtons() {
    const bakeButtons = document.querySelectorAll(".bake-button");
    bakeButtons.forEach((button, index) => {
        button.addEventListener("click", () => {
            registrarFornada(index);
            showRecentFornadasCliente();
        });
    });
}

// Inicialização da página para listar pães cadastrados ou fornadas recentes
const currentPage = window.location.pathname.split("/").pop();
if (currentPage === "cadastro-paes.html") {
    createBreadButtons();
} else if (currentPage === "cadastro-fornada.html") {
    createBakeButtons();
} else if (currentPage === "ultimas-fornadas.html") {
    showRecentFornadasCliente();
}
