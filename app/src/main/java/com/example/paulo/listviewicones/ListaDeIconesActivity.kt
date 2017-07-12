package com.example.paulo.listviewicones

import android.R.layout.simple_list_item_1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*
import kotlin.collections.ArrayList


data class AdapterIconesPersonalizado(var icones: MutableList<Icone>, var act: Activity, var isEditing: Boolean): BaseAdapter(){

    override fun getCount():Int {
        return icones.size
    }
    //Usando um opcional ? na frente do Any, dizemos que o retorno pode ser Any ou Null
    override fun getItem(position:Int):Any? {
        return icones.get(position)
    }
    override fun getItemId(position:Int):Long {
        return 0
    }
    override fun getView(position:Int, convertView: View?, parent: ViewGroup):View? {
        val view : View = act.layoutInflater.inflate(R.layout.lista_icones_personalizada,parent,false)
        var icone : Icone = icones.get(position)

        //Montando o layout da view
        var nome : TextView = view.findViewById<TextView>(R.id.lista_curso_personalizada_nome)
        var descricao : TextView = view.findViewById(R.id.lista_curso_personalizada_descricao)
        var imagem : ImageView = view.findViewById(R.id.lista_curso_personalizada_imagem)
        var btnRemover : Button = view.findViewById(R.id.lista_curso_personalizada_bntRemover)

        // populando as Views
        nome.setText(icone.nome)
        descricao.setText(icone.descricao)
        //imagem.setImageResource(icone.imagemIcone)
        //imagem.setImageResource()

        imagem.setImageResource(icone.imagemIcone)
        btnRemover.id = position

        if (isEditing == true){
            btnRemover.visibility = Button.VISIBLE
        }

        return view

    }

    fun mostrarDelete(){
        isEditing = true
        this.notifyDataSetChanged()
    }

    fun deleteItem(pos : Int){
        this.icones.removeAt(pos)

        this.notifyDataSetChanged()
    }

    //var icones : List<Icone> = ArrayList<Icone>()
// variavel = nome: tipo
//    fun AdapterIconesPersonalizado(icones:List<Icone>, act: Activity) {
//        this.icones = icones
//    }

}

class ListaDeIconesActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout)

        //var cursos = arrayListOf<Curso>()
        var sList = todosOsIcones()

        //var outraLista = ArrayList<String>()
        //outraLista.add("nossa")

        //var outraLista1 = arr


        val listaDeIcones = findViewById<ListView>(R.id.lista) as ListView

//
        //var oadapter : ArrayAdapter<String> = ArrayAdapter(this, simple_list_item_1,outraLista)
        var oadapter: AdapterIconesPersonalizado = AdapterIconesPersonalizado(sList, this,false)

        listaDeIcones.adapter = oadapter


    }

    //var outro = Curso("teste","teste2",EstadoAtual.FAZENDO)

    fun todosOsIcones(): ArrayList<Icone> {
        return ArrayList(Arrays.asList(
                Icone("IFood", "Alimentação", EstadoAtual.FAZENDO, R.drawable.ifood),
                Icone("Mapas", "Transporte e Mapas", EstadoAtual.FAZENDO, R.drawable.maps),
                Icone("Waze", "Transporte e Mapas", EstadoAtual.FAZENDO, R.drawable.waze)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var listaIcones = findViewById<ListView>(R.id.lista) as ListView

        //passo para a variavel li um adaptador generico
        var li = listaIcones.adapter
        if (li !is AdapterIconesPersonalizado){ return false }

        if (item != null) {
            when (item.getItemId()) {
                R.id.editar -> {

                    li.mostrarDelete()
                    // go home
                    println("item 1")
                    return true
                }
                R.id.sobre -> {
                    var btn = 
                    //li.deleteItem(btn.id)

                    println("id: "+btn.id)
                    return true
                }
            }
        }


        return super.onOptionsItemSelected(item)
    }


}

