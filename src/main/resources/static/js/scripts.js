function actorSelected(select) {
    let index = select.selectedIndex;
    let option = select.options[index];
    let actorId = option.value;
    let actorName = option.text;
    let urlImage = option.dataset.url;

    option.disabled = "disabled";
    select.selectedIndex = 0;

    agregarActor(actorId, actorName, urlImage);

    let ids = $("#ids").val();

    if (ids == "") {
        $("#ids").val(actorId);
    } else {
        $("#ids").val(ids + "," + actorId);
    }
}

function agregarActor(id, nombre, urlImage) {
    let htmlString = `
        <div class="card col-md-3 m-2" style="width: 10rem" >
            <img src="{URL-IMAGE}" class="card-img-top" alt="{NOMBRE}">
                <div class="card-body">
                    <p class="card-text">{NOMBRE}</p>
                    <button class="btn btn-danger" data-id="{ID}" onclick="eliminarActor(this); return false;">Eliminar</button>
                </div>
        </div>`;

    htmlString = htmlString.replace("{URL-IMAGE}", urlImage);
    htmlString = htmlString.replace(/{NOMBRE}/g, nombre);
    htmlString = htmlString.replace("{ID}", id);

    $("#protagonistas_container").append(htmlString);
}

function eliminarActor(button) {
    let id = button.dataset.id;
    let node = button.parentElement.parentElement;
    let arrayIds = $("#ids").val().split(",").filter(idActor => idActor != id);

    $("#ids").val(arrayIds.join(","));

    $("#protagonistas option[value='" + id + "']").prop("disabled", false);

    $(node).remove();
}

function previsualizar() {
    let reader = new FileReader();

    reader.readAsDataURL(document.getElementById("archivo").files[0]);

    reader.onload = function (e) {
        let vista = document.getElementById("vista_previa");
        document.getElementById("vista_previa").classList.remove("d-none");
        vista.style.backgroundImage = "url(" + e.target.result + ")";
    }
}