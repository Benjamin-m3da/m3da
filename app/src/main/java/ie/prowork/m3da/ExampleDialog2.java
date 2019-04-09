//package ie.prowork.m3da;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatDialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//
//public class ExampleDialog2 extends AppCompatDialogFragment {
//    private EditText Other_reason_tv;
//    private Button Submit_reason_btn;
//    private ExampleDialogListener listener;
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.reason_if_other_holidayrequest_dialog, null);
//
//        builder.setView(view)
//                .setTitle("Login")
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String username = Other_reason_tv.getText().toString();
//                        listener.applyTexts(username);
//                    }
//                });
//
//        absense_reason_tv = view.findViewById(R.id.Other_reason_tv);
//
//        return builder.create();
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        try {
//            listener = (ExampleDialogListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() +
//                    "must implement ExampleDialogListener");
//        }
//    }
//
//    public interface ExampleDialogListener {
//        void applyTexts(String username);
//    }
//}