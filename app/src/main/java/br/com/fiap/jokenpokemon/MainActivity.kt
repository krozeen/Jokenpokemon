package br.com.fiap.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val GRAMA = 1
    val AGUA = 2
    val FOGO = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBulbasaur.setOnClickListener {
            realizarJogada(GRAMA)
        }

        ivCharmander.setOnClickListener {
            realizarJogada(FOGO)
        }

        ivSquirtle.setOnClickListener {
            realizarJogada(AGUA)
        }
    }

    fun realizarJogada(jogadaUsuario: Int) {
        val jogadaAdversario = Random().nextInt(3) + 1

        configuraimagemDaJogada(jogadaUsuario, ivVoce)
        configuraimagemDaJogada(jogadaAdversario, ivAndroid)

        when (jogadaUsuario) {
            GRAMA -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        empate()
                    }
                    AGUA -> {
                        vitoria()
                    }
                    FOGO -> {
                        derrota()
                    }
                }
            }
            FOGO -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        vitoria()
                    }
                    AGUA -> {
                        derrota()
                    }
                    FOGO -> {
                        empate()
                    }
                }
            }
            AGUA -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        derrota()
                    }
                    AGUA -> {
                        empate()
                    }
                    FOGO -> {
                        vitoria()
                    }
                }
            }
        }
    }

    fun configuraimagemDaJogada(jogada: Int, imageView: ImageView){
        when(jogada){
            GRAMA -> {configuraImagem(R.drawable.bulbasaur, imageView)}
            FOGO -> {configuraImagem(R.drawable.charmander, imageView)}
            AGUA -> {configuraImagem(R.drawable.squirtle, imageView)}
        }
    }

    fun configuraImagem(resorseId: Int, imageView: ImageView){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resorseId))
    }

    fun vitoria() {
        tvResultado.text = "Você Venceu!"
    }

    fun empate() {
        tvResultado.text = "Empate!"
    }

    fun derrota() {
        tvResultado.text = "Você Perdeu!"
    }
}
