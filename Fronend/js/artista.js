function loadData() {
  let request = sendRequest("artista/list", "GET", "");
  let table = document.getElementById("artista-table");
  table.innerHTML = "";
  request.onload = function () {
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
      table.innerHTML += `
                <tr>
                    <th>${element.idartista}</th>
                    <td>${element.nombreartista}</td>
                    
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_artista.html?id=${element.idartista}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteArtista(${element.idartista})'>Eliminar</button>
                    </td>
                </tr>

                `;
    });
  };
  request.onerror = function () {
    table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
  };
}

function loadArtista(idartista) {
  let request = sendRequest("artista/list/" + idartista, "GET", "");
  let name = document.getElementById("artista-name");
  let id = document.getElementById("artista-id");
  request.onload = function () {
    let data = request.response;
    id.value = data.idartista;
    name.value = data.nombreartista;
  };
  request.onerror = function () {
    alert("Error al recuperar los datos.");
  };
}

function deleteArtista(idartista) {
  let request = sendRequest("artista/" + idartista, "DELETE", "");
  request.onload = function () {
    loadData();
  };
}

function saveArtista() {
  let name = document.getElementById("artista-name").value;

  let id = document.getElementById("artista-id").value;
  let data = { idartista: id, nombreartista: name };
  let request = sendRequest("artista/", id ? "PUT" : "POST", data);
  request.onload = function () {
    window.location = "artista.html";
  };
  request.onerror = function () {
    alert("Error al guardar los cambios.");
  };
}
