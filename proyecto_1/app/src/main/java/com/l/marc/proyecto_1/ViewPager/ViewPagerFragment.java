package com.l.marc.proyecto_1.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l.marc.proyecto_1.R;


public class ViewPagerFragment extends Fragment {

    private ViewPager viewPage;
    private TabLayout table;


    private inicializarTabHost mListener;

    public ViewPagerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ViewPagerFragment newInstance(String param1, String param2) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_pager, container, false);

        viewPage = (ViewPager) v.findViewById(R.id.pager);
        table = (TabLayout) v.findViewById(R.id.tab_layout);



        mListener.iniciliazarTab(table,viewPage);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof inicializarTabHost) {
            mListener = (inicializarTabHost) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement inicializarTabHost");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface inicializarTabHost {
        // TODO: Update argument type and name
        void iniciliazarTab(TabLayout tl1, ViewPager v1);
    }
}
