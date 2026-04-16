package com.notification.notificationnotes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DeleteNoteDialogFragment extends DialogFragment
{
    public static DeleteNoteDialogFragment newInstance(int notePos, String noteTitle)
    {
        DeleteNoteDialogFragment frag = new DeleteNoteDialogFragment();
        Bundle args = new Bundle();
        args.putInt("notePos", notePos);
        args.putString("noteTitle", noteTitle);
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final int notePos;
        final String noteTitle;
        if (getArguments() != null) {
            notePos = getArguments().getInt("notePos");
            noteTitle = getArguments().getString("noteTitle");
        } else {
            notePos = 0;
            noteTitle = "";
        }
        final String deletePrompt = getResources().getString(R.string.dialog_delete_note);
        final String dialogText = (noteTitle != null && noteTitle.isEmpty()) ?
            deletePrompt + "?" : deletePrompt + " \"" + noteTitle + "\"?";

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage(dialogText)
            .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    if (Globals.LOG) Log.d(Globals.TAG, "Confirm delete of note at position " + notePos);
                    ((MainActivity) requireActivity()).deleteNote(notePos);
                }
            })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    if (Globals.LOG) Log.d(Globals.TAG, "Cancel delete note at position " + notePos);
                }
            });

        return builder.create();
    }
}
