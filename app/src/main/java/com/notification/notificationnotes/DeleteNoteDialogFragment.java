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
        final int notePos = getArguments().getInt("notePos");
        final String noteTitle = getArguments().getString("noteTitle");
        final String deletePrompt = getResources().getString(R.string.dialog_delete_note);
        final String dialogText = noteTitle.isEmpty() ?
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
