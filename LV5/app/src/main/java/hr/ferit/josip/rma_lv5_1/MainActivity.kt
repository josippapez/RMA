package hr.ferit.josip.rma_lv5_1

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeButtons();
    }

    private fun initializeButtons() {
        pikachuButton.setOnClickListener{ playSound("pikachu") }
        bulbasaurButton.setOnClickListener{ playSound("bulbasaur") }
        charmanderButton.setOnClickListener{ playSound("charmander") }
    }

    private fun playSound(pokemon: String) {
        val afd = assets.openFd("$pokemon.mp3")
        val player = MediaPlayer()
        player.stop()
        player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        player.prepare()
        player.start()
    }
}
