package sheridan.salemuha.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sheridan.salemuha.assignment1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding

    //const
    companion object{
        const val MESSAGE_TEXT_KEY = "message"
        const val IS_URGENT_KEY = "urgent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get and display the message data
        binding.isUrgentOutput.text = intent.getStringExtra(IS_URGENT_KEY)
        binding.messageText.text = intent.getStringExtra(MESSAGE_TEXT_KEY)

        // make the close button work
        binding.closeButton.setOnClickListener { finish() }
}
}