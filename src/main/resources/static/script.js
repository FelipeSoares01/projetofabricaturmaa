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

    $(document).ready(function(){
        let servicoId;

        // Evento para abrir o modal e guardar o ID do serviço
        $(".js-delete").on("click", function(){
            servicoId = $(this).attr("data-id");
            $('#modalExcluirServico').modal('show');
        });

        // Evento para confirmar a exclusão do serviço
        $("#btnExcluirServico").on("click", function(){
            $.ajax({
                url: "/servicos/delete/" + servicoId,
                method: "GET",
                success: function(){
                    window.location.href = "/servicos";
                },
                error: function(){
                    alert("Erro ao excluir o serviço.");
                }
            });
        });
    });
    // Adicionar evento de clique para o botão "Não"
    $("#modalExcluirCliente").on("click", ".btn-secondary", function() {
        $("#modalExcluirCliente").modal("hide");
    });
})();
