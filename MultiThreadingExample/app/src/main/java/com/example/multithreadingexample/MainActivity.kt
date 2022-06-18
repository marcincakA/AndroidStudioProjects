package com.example.multithreadingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assigning Layout elements
        val tv1
                = findViewById<TextView>(R.id.tv1)
        val tv2
                = findViewById<TextView>(R.id.tv2)
        val tv3
                = findViewById<TextView>(R.id.tv3)
        val btn
                = findViewById<Button>(R.id.btnStart)

        // Boolean for Button (initially False)
        var boolbtn
                = false
        // Button onClick action
        btn.setOnClickListener{
            // Button (True)
            boolbtn = !boolbtn
            // Case where Button is False
            if (!boolbtn)
            {
                tv1.text = "Stopped1"
                tv2.text = "Stopped2"
                tv3.text = "Stopped3"
                btn.text = "Start"
            }
            // Case where Threads are running
            else
            {
                // Setting the button text as "Stop"
                btn.text = "Stop"

                // Thread 1
                Thread(Runnable {

                    // Runs only when Button is True
                    while (boolbtn) {

                        runOnUiThread
                        {
                            tv1.text = "Started1"
                        }
                        Thread.sleep(1000)
                        runOnUiThread
                        {
                            tv1.text = "Activity1"
                        }
                        Thread.sleep(1000)
                    }
                }).start()

                // Thread 2
                Thread(Runnable {

                    // Runs only when Button is
                    // True
                    while (boolbtn) {
                        runOnUiThread{
                            tv2.text = "Started2"
                        }
                        Thread.sleep(1000)
                        runOnUiThread
                        {
                            tv2.text = "Activity2"
                        }
                        Thread.sleep(1000)
                    }
                }).start()

                // Thread 3
                Thread(Runnable {

                    // Runs only when Button is
                    // True
                    while (boolbtn) {
                        runOnUiThread{
                            tv3.text = "Started3"
                        }
                        Thread.sleep(1000)
                        runOnUiThread {
                            tv3.text = "Activity3"
                        }
                        Thread.sleep(1000)
                    }
                })
                    .start()
            }
        }
    }
}
