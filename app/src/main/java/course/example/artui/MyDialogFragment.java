package course.example.artui;

import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;



/**
 * Created by Masha on 15/10/15.
 */
public class MyDialogFragment extends DialogFragment {

    public static final String URL = "http://moma.org/";

    public static MyDialogFragment newInstance() {
        MyDialogFragment frag = new MyDialogFragment();
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.visit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent mIntent = new Intent();
                        mIntent.setAction(Intent.ACTION_VIEW);
                        mIntent.setData(Uri.parse(URL));
                        startActivity(mIntent);

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}