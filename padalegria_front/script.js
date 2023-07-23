// Dados do sistema - Pães cadastrados e fornadas recentes
const paoList = [];
const recentFornadas = [];

// Função para adicionar um novo pão ao sistema
function addPao(type, time) {
    paoList.push({ type, time });
}

// Função para registrar uma nova fornada
function registrarFornada(index) {
    const pao = paoList[index];
    const date = new Date();
    recentFornadas.push({ type: pao.type, time: pao.time, date });
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
        info.innerText = `${fornada.type}: ${fornada.date.toLocaleTimeString()} - ${timeDisplay}`;
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

// Evento de cadastro de novo pão
const breadForm = document.getElementById("bread-form");
breadForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const breadType = document.getElementById("bread-type").value;
    const breadTime = parseInt(document.getElementById("bread-time").value);
    if (breadType && breadTime) {
        addPao(breadType, breadTime);
        createBreadButtons();
        breadForm.reset();
    }
});

// Exemplo de pães cadastrados
addPao("Francês", 20);
addPao("Doce com Côco", 30);
addPao("Pão Bolacha", 25);

// Inicializar a exibição dos botões e fornadas
createBreadButtons();
showRecentFornadas();
