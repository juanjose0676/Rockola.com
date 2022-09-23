
function loadData(){
    let request = sendRequest('usuario/showall/', 'GET', '');
    let table = document.getElementById('users-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            var i = true;
            if (element.estado==0){
                i = false;
            }
            
            table.innerHTML += `
                <tr>
                    <th>${element.idUsuario}</th>
                    <td>${element.nombreUsuario}</td>
                    <td>${element.password}</td>
                    <td>
                        <div class="form-check form-switch">
                            <input ${i ? "checked" : "uncheked"} class="form-check-input" type="checkbox" role="switch" >
                        </div>
                    </td>
                    <td>${element.perfil}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_usuario.html?id=${element.idUsuario}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteUser(${element.idUsuario})'>Eliminar</button>
                    </td>
                    
                </tr>

                `;
        });
    };
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="5">Error al recuperar los datos.</td>
            </tr>
        `;
    };
}

function loadDataPerfil(){
    let request = sendRequest('perfil/list', 'GET', '');
    let ele = document.getElementById('sel-perfil');
    
    request.onload = function(){
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
        ele.innerHTML = ele.innerHTML +`
            <option value=${element.idPerfil} > ${element.nombrePerfil} </option>'
            `;
        });
    };
}

function loadUser(idUsuario){
   
    let request = sendRequest('usuario/list/'+idUsuario, 'GET', '');
    let nombreUsuario = document.getElementById('user-nombre');
    let password = document.getElementById('user-password');
    let id = document.getElementById('user-id');
    let status = document.getElementById('user-status');
    let perfil = document.getElementById('sel-perfil');
    let btn = document.getElementById('user-flag');
    request.onload = function(){
       
        let data = request.response;
        var i = true;
        if (data.estado==0){
            i = false;
        }
        nombreUsuario.value = data.nombreUsuario;
        password.value = data.password;
        id.value = data.idUsuario;
        status.checked = i;
        perfil.value = data.perfil;
        btn.value = 'modificar';
        
    };
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    };
}

function deleteUser(idUsuario){
    let request = sendRequest('usuario/'+idUsuario, 'DELETE', '');
    request.onload = function(){
        loadData();
    };
}

function saveUser(){
    let nombreUsuario1 = document.getElementById('user-nombre').value;
    let password1 = document.getElementById('user-password').value;
    let id1 = document.getElementById('user-id').value;
    var e = 0;
    let status1 = document.getElementById('user-status').checked;
    if(status1 == true) {  
    e = 1; 
    }
    let perfil1 = document.getElementById('sel-perfil').value;
    let data = {idUsuario: id1,nombreUsuario: nombreUsuario1,password: password1, estado: e, perfil: perfil1 };
    if (document.getElementById('user-flag').value == 'modificar') { 
        let request = sendRequest('usuario/',  'PUT', data);
        request.onload = function(){
            window.location = 'usuario.html';
        };   

        request.onerror = function(){
            alert('Error al guardar los cambios.');
        };
    }
    else {
      
        let request = sendRequest('usuario', 'POST', data);
        request.onload = function(){
            window.location = 'usuarios.html';
        };

        request.onerror = function(){
            alert('Error al guardar los cambios.');
        };
    }
    
}