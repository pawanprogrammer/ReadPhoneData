package com.trishasofttech.readphonedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_phonebook, btn_sms;
    TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_phonebook = findViewById(R.id.btn_phonebook);
        tvdata = findViewById(R.id.tvdata);
        btn_sms = findViewById(R.id.btn_sms);

        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://sms/inbox");
                Cursor c = getApplicationContext().getContentResolver().query(uri, null, null ,null,null);

                // Read the sms data
                if (c != null && c.moveToFirst())
                {
                    for(int i = 0; i < c.getCount(); i++) {
                        String mobile = c.getString(c.getColumnIndexOrThrow("address")).toString();
                        String message = c.getString(c.getColumnIndexOrThrow("body")).toString();
                        //adding item to array list
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        c.moveToNext();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "sms null", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_phonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*final ContentResolver cr = getContentResolver();
                String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER};
                final Cursor c = cr.query(ContactsContract.Data.CONTENT_URI,
                        projection, null, null, null);
                c.moveToFirst();
                while (c.moveToNext())
                {
                    Toast.makeText(getApplicationContext(),
                            c.getString(1), Toast.LENGTH_SHORT).show();


                }*/

                /*ContentResolver contentResolver = getContentResolver();
                String[] projection = new String[]{
                        ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        *//*Toast.makeText(getApplicationContext(),
                                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)),
                                Toast.LENGTH_SHORT).show();*//*
                        Toast.makeText(getApplicationContext(),
                                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)),
                                Toast.LENGTH_SHORT).show();
                    } while (cursor.moveToNext());
                }*/

            }
        });

    }
}