package com.nick.a75fapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Khoury on 2017-06-06.
 */

public class ViewServerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_server);
        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        // QUERY THE DATABASE
        // https://developer.android.com/training/basics/data-storage/databases.html
        ContractHelper mDbHelper = new ContractHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Contract.Sensor._ID,
                Contract.Sensor.COLUMN_TAG,
                Contract.Sensor.COLUMN_DATA,
                Contract.Sensor.COLUMN_TIME
        };
        // Filter results WHERE "title" = 'My Title'
        //String selection = Contract.Sensor.COLUMN_TAG + " = ?";
        //String[] selectionArgs = { "*" }; // My Title
        // How you want the results sorted in the resulting Cursor
        String sortOrder = Contract.Sensor.COLUMN_TIME + " DESC";
        Cursor cursor = db.query(
                Contract.Sensor.TABLE_NAME,          // The table to query
                projection,                          // The columns to return
                null, //selection,                   // The columns for the WHERE clause, null for all entries
                null, //selectionArgs,               // The values for the WHERE clause, null for all entries
                null,                                // don't group the rows
                null,                                // don't filter by row groups
                sortOrder                            // The sort order
        );
        //iterate through database items that matched the search
        List itemIds = new ArrayList<>();
        String result = "<type>: <data>, <epoch>\n";
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.Sensor._ID));
            itemIds.add(itemId);
            String row = cursor.getString(cursor.getColumnIndex(Contract.Sensor.COLUMN_TAG))
                    + ": " + cursor.getString(cursor.getColumnIndex(Contract.Sensor.COLUMN_DATA))
                    + ", " + cursor.getString(cursor.getColumnIndex(Contract.Sensor.COLUMN_TIME)) + "\n";
            result += row;
        }
        cursor.close();

        textViewResult.setMovementMethod(new ScrollingMovementMethod());
        textViewResult.setText(result);
    }
}
