/**
 * 
 */
package com.team4d.lolhelper.api.database;

import android.content.Context;
import android.os.AsyncTask;

/**
 * @author KaosuRyoko
 */
public class LOLDatabaseAsyncTask extends AsyncTask<String, Void, String[]>
{
	private final Context context;

	public LOLDatabaseAsyncTask(Context c)
	{
		context = c;
	}

	@Override
	protected String[] doInBackground(String... params)
	{
		LOLSQLiteHelper.getInstance(context).getWritableDatabase();
		return null;
	}
}
