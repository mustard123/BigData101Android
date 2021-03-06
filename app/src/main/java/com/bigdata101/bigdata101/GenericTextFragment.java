package com.bigdata101.bigdata101;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyFragmentInteraction} interface
 * to handle interaction events.
 * Use the {@link GenericTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenericTextFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textView;



    private MyFragmentInteraction mListener;

    public GenericTextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GenericTextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GenericTextFragment newInstance(String param1, String param2) {
        GenericTextFragment fragment = new GenericTextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String resource;
        if(mParam1.contains("Art.")){
            int endIndex = 0;
            endIndex = mParam1.indexOf("Art.");

           resource = mParam1.substring(0, endIndex).toLowerCase().trim().replace(" ", "_");
        }else {
            resource = mParam1.toLowerCase().replace(" ", "_");
        }



        Log.d("resource", resource);
    int layoutId = getResources().getIdentifier(resource,"layout", this.getActivity().getPackageName());


        // Inflate the layout for this fragment
        View rootview = inflater.inflate(layoutId, container, false);

        //textView = rootview.findViewById(R.id.content_text);

        return  rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.fragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragmentInteraction) {
            mListener = (MyFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
