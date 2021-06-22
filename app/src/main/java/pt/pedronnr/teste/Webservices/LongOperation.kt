package pt.pedronnr.teste.Webservices

import android.os.AsyncTask

private class LongOperation : AsyncTask<String?, Void?, String>() {

    override fun doInBackground(vararg p0: String?): String {
        return "Executed"
    }

    override fun onPostExecute(result: String) {

    }

    override fun onPreExecute() {

    }

    override fun onProgressUpdate(vararg values: Void?) {

    }
}