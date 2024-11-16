package com.khuttun.notificationnotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AddNoteActivity extends ThemedActivity
{
    private EditText titleInput;
    private EditText textInput;
    private int noteIndex; // index for the edited note if this activity is opened for note editing

    // Request codes
    public static final int ADD_REQ = 1;
    public static final int EDIT_REQ = 2;

    // Extra names
    public static final String TITLE = "TITLE";
    public static final String TEXT = "TEXT";
    public static final String NOTE_INDEX = "NOTE_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.titleInput = (EditText) findViewById(R.id.note_title_input);
        this.textInput = (EditText) findViewById(R.id.note_text_input);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            this.titleInput.setText(extras.getString(TITLE, ""));
            this.textInput.setText(extras.getString(TEXT, ""));
            this.noteIndex = extras.getInt(NOTE_INDEX, -1);
            if (noteIndex > -1)
            {
                setTitle(getString(R.string.edit_note));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.save_note)
        {
            String title = this.titleInput.getText().toString();
            String text = this.textInput.getText().toString();
            if (Globals.LOG) Log.d(Globals.TAG, "Saving note. Title: " + title + ", Text: " + text);

            Intent data = new Intent();
            data.putExtra(TITLE, title);
            data.putExtra(TEXT, text);
            data.putExtra(NOTE_INDEX, this.noteIndex);

            setResult(RESULT_OK, data);
            finish();

        }

        return true;
    }
}
