package com.example.jadwalsholat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch(Dispatchers.IO) {
            val response = fetchAPI()
        }
        
    }
    private suspend fun fetchAPI(){
        val url = URL("https://waktu-sholat.vercel.app/prayer?latitude=-6.848838888888888&longitude=107.5178777777778")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"

        try {
            val response = withContext(Dispatchers.IO){
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val responseBuilder = StringBuilder()
                var line:String?

                while (reader.readLine().also { line = it } != null){
                    responseBuilder.append(line)
                }
                reader.close()
                responseBuilder.toString()
            }
            withContext(Dispatchers.Main){
                println("Response:$response")
            }
        } finally {
            connection.disconnect()
        }
    }
}