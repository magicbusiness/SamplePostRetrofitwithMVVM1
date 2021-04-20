package com.example.samplepostretrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.samplepostretrofitwithmvvm.databinding.ActivityMainBinding
import com.example.samplepostretrofitwithmvvm.model.ModuleRetro
import com.example.samplepostretrofitwithmvvm.repository.RepositoryData
import com.example.samplepostretrofitwithmvvm.viewModel.MainView
import com.example.samplepostretrofitwithmvvm.viewModel.MainViewFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    //
    private lateinit var binding: ActivityMainBinding

    //
    private  lateinit var viewModel: MainView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init Repository and Main View
        val post = RepositoryData()
        val viewFactory = MainViewFactory(post)

        viewModel = ViewModelProvider(this, viewFactory).get(MainView::class.java)

        // @Post Form
        viewModel.postForm(3, 1, "Sample Post Form", "Sample Description")
        viewModel.dataJSON.observe(this, Observer {
            val result = it.body()
            val message = it.message()
            val error = it.code()

            if (it.isSuccessful)
            {
                sample_text.text = result.toString()

                Log.d("Success", result.toString())
                Log.d("Message", message.toString())
                Log.d("Error", error.toString())
            }

            else
            {
//                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        })

        // @Put
        val samplePut = ModuleRetro(2, 3, null.toString(), "Testing")

        viewModel.postPut(samplePut)
        viewModel.dataJSON.observe(this, Observer {
            val result = it.body()
            val message = it.message()
            val error = it.code()

            if (it.isSuccessful)
            {
                sample_text_2.text = result.toString()

                Log.d("Success2", result.toString())
                Log.d("Message2", message.toString())
                Log.d("Error2", error.toString())
            }
        })

        // @Patch
        val samplePatch = ModuleRetro(4, 5, null.toString(), "Testing2")

        viewModel.postPatch(samplePatch)
        viewModel.dataJSON.observe(this, Observer {
            val result = it.body()
            val message = it.message()
            val error = it.code()

            if (it.isSuccessful)
            {
                sample_text_3.text = result.toString()

                Log.d("Success3", result.toString())
                Log.d("Message3", message.toString())
                Log.d("Error3", error.toString())
            }
        })

        // @Delete
        viewModel.postDelete(2)
        viewModel.dataJSON.observe(this, Observer {
            val result = it.body()
            val message = it.message()
            val error = it.code()

            if (it.isSuccessful)
            {
                sample_text_4.text = result.toString()

                Log.d("Success4", result.toString())
                Log.d("Message4", message.toString())
                Log.d("Error4", error.toString())
            }
        })
    }
}