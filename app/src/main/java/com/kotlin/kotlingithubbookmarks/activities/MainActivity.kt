package com.kotlin.kotlingithubbookmarks.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.kotlin.kotlingithubbookmarks.R
import com.kotlin.kotlingithubbookmarks.app.Constants
import com.kotlin.kotlingithubbookmarks.app.isNotEmpty
import kotlinx.android.synthetic.main.activity_display.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
        //TextView.text points to CharSequence object
        val str1 = txvGreeting.text
        txvGreeting.text = "Welcome"

        //EditText.text points to Editable object
        val str2 = etName.text.toString()
        etName.setText("Samson")
         **/

        //setSupportActionBar(toolbar)


    }

    /** save app username in SharedPreferences */
    fun saveName (view: View ) {

        if (etName.isNotEmpty(inputLayoutName)) {
            val personName = etName.text.toString()
            val sp = getSharedPreferences(Constants.APP_SHARED_PREFERENCES, Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString(Constants.KEY_PERSON_NAME, personName)
            editor.apply()
        }
    }

    /** Search repositories on github after passing data to DisplayActivity */
    fun listRepositories(view: View){

        if (etRepoName.isNotEmpty(inputLayoutRepoName)){
            val queryRepo = etRepoName.text.toString()
            val repoLanguage = etLanguage.text.toString()

            val intent = Intent(this@MainActivity, DisplayActivity::class.java)
            intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_REPO)
            intent.putExtra(Constants.KEY_REPO_SEARCH, queryRepo)
            intent.putExtra(Constants.KEY_LANGUAGE, repoLanguage)
            startActivity(intent)
        }
    }

    /**Search repositories of a particular github user after passing data to DisplayActivity */
    fun listUserRepositories(view: View){

        if (etGithubUser.isNotEmpty(inputLayoutGithubUser)) {
            val githubUser = etGithubUser.text.toString()

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_USER)
            intent.putExtra(Constants.KEY_GITHUB_USER, githubUser)
            startActivity(intent)
        }
    }

}