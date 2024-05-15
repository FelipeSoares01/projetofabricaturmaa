(function(){
    $("#tabclientes").on("click",".js-delete",function(){
        let botaoclicado = $(this)
        $("#btnExcluirCliente").attr("data-id", botaoclicado.attr("data-id"))
        $("#modalExcluirCliente").modal("show")
    })

    $("#btnExcluirCliente").on("click", function(){
        let botaosim = $(this)
        let id = botaosim.attr("data-id")
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href = "/clientes"
            }
        })
    })

    // Adicionar evento de clique para o botão "Não"
    $("#modalExcluirCliente").on("click", ".btn-secondary", function() {
        $("#modalExcluirCliente").modal("hide");
    });
})();
