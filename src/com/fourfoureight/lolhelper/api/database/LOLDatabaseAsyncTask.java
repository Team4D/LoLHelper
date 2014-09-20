/**
 * 
 */
package com.fourfoureight.lolhelper.api.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
		SQLiteDatabase db = LOLSQLiteHelper.getInstance(context).getWritableDatabase();
		db.close();

		return null;
	}

}
