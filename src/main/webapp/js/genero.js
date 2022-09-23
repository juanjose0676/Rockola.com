function loadData() {
  let request = sendRequest("genero/list", "GET", "");
  let table = document.getElementById("genero-table");
  table.innerHTML = "";
  request.onload = function () {
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
      table.innerHTML += `
                <tr>
                    <th>${element.idgenero}</th>
                    <td>${element.nombregenero}</td>
                    
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_genero.html?id=${element.idgenero}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteGenero(${element.idgenero})'>Eliminar</button>
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

function loadGenero(idgenero) {
  let request = sendRequest("genero/list/" + idgenero, "GET", "");
  let name = document.getElementById("genero-name");
  let id = document.getElementById("genero-id");
  request.onload = function () {
    let data = request.response;
    id.value = data.idgenero;
    name.value = data.nombregenero;
  };
  request.onerror = function () {
    alert("Error al recuperar los datos.");
  };
}

function deleteGenero(idgenero) {
  let request = sendRequest("genero/" + idgenero, "DELETE", "");
  request.onload = function () {
    loadData();
  };
}

function saveGenero() {
  let name = document.getElementById("genero-name").value;

  let id = document.getElementById("genero-id").value;
  let data = { idgenero: id, nombregenero: name };
  let request = sendRequest("genero/", id ? "PUT" : "POST", data);
  request.onload = function () {
    window.location = "genero.html";
  };
  request.onerror = function () {
    alert("Error al guardar los cambios.");
  };
}
