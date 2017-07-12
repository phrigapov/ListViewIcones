package com.example.paulo.listviewicones

enum class EstadoAtual {
    FAZENDO {
        public override fun toString():String {
            return "Fazendo"
        }
    }, FINALIZADO {
        public override fun toString():String {
            return "finalizado"
        }
    }
}

data class Icone(var nome: String, var descricao: String, var estado: EstadoAtual, var imagemIcone : Int) {
    //utiizando data Class não precisa implementar os métodos padrões
    /*
    var nome = ""
    var descricao = ""
    var estado:EstadoAtual = EstadoAtual.FAZENDO

    fun Curso(nome:String, descricao:String, estado:EstadoAtual) {
        this.nome = nome
        this.descricao = descricao
        this.estado = estadoo
        }

    public override fun toString():String {
        return "Icone: " + nome + " Descrição: " +
                descricao + " Estado: " + estado
    }
*/
    public override fun toString():String {
        return "Icone: " + nome + " Descrição: " +
                descricao + " Estado: " + estado
    }
}
