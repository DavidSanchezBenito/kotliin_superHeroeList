package com.example.kotliin_superheroelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superhero.view.*

//HeroAdapter.HeroHolder => nombre de la clase y luego otra clase que tengo q crear
//Lo primero que hacemos es decirle a la clase que tendrá un RecyclerAdapter y un ViewHolder: HeroHolder q tendremos q crear
class HeroAdapter (val superHero: List<SuperHero>) : RecyclerView.Adapter<HeroAdapter.HeroHolder>(){


  //Estos 3 metodos los implementamos automaticamente:
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {

      //devulve un objeto ViewHolder al cual le pasamos la celda que hemos creado.
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount(): Int =   superHero.size
    //le va a decir al ReclicerView cuantos items tiene la lista.

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {

        //se encarga de coger cada una de las posiciones de la lista de superhéroes y pasarlas a la clase ViewHolder para que esta pinte todos los valores.
    holder.render(superHero[position])
    }


    class HeroHolder (val view: View): RecyclerView.ViewHolder(view){


    fun render(superHero: SuperHero ){
        view.txt_nombreHeroe.text = superHero.superHeroName
        view.txt_nombreReal.text = superHero.realName
        view.txt_publisher.text = superHero.publisher

        //para cargar la imagen utilizaremos la libreria implementada:  implementation 'com.squareup.picasso:picasso:2.71828'

        Picasso.get().load(superHero.image).into(view.image)

        view.setOnClickListener{
            Toast.makeText(view.context, "has seleccionado a ${superHero.superHeroName}",Toast.LENGTH_LONG).show()
        }
    }

    }  //end HeroHolder

}
