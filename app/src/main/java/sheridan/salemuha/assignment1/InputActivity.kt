package sheridan.salemuha.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sheridan.salemuha.assignment1.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    var selectedHand = ""
    var randomHand = ""

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener{showOutput()}

    }

    fun showOutput() {
        //get a random value of 1-3 and assign the random hand
        var value = (1..3).random()
        if(value == 1){
            randomHand = getString(R.string.rock)
        }
        if(value == 2){
            randomHand = getString(R.string.paper)
        }
        if (value == 3){
            randomHand = getString(R.string.scissor)
        }


        // get the selected message text
        val message = when (binding.messageGroup.checkedRadioButtonId) {
            R.id.rdbtn_rock -> getString(R.string.rock)
            R.id.rdbtn_paper -> getString(R.string.paper)
            R.id.rdbtn_scissor -> getString(R.string.scissor)
            else -> getString(R.string.undefined)
        }


        //if no values return toast for mssing values
        if (message != getString(R.string.undefined)){
            //logic for deciding winner runs here
            var result = ""
            selectedHand = message

            if(selectedHand == (getString(R.string.paper)) && randomHand == (getString(R.string.rock))){
                result = "Winner " + selectedHand
            }
            else if(selectedHand == (getString(R.string.rock)) && randomHand == (getString(R.string.scissor))){
                result = "Winner " + selectedHand
            }
            else if(selectedHand == (getString(R.string.scissor)) && randomHand == (getString(R.string.paper))){
                result = "Winner " + selectedHand
            }
            else{
                result = "Loser "+ selectedHand
            }

            if(selectedHand.equals(randomHand)){
                result = "Tie"
            }


            //Send data using intents to our output activity class
            val intent = Intent(this, OutputActivity::class.java).apply {
                putExtra(OutputActivity.IS_URGENT_KEY, randomHand)
                putExtra(OutputActivity.MESSAGE_TEXT_KEY, result)
            }
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext,"Must Select A Hand", Toast.LENGTH_SHORT).show()
        }
    }
}