package online.danbao.fragmentexample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn_getValue;
    TextView tv_value;
    Bundle args;
    String msg;

    public ContentFragment() {
        // Required empty public constructor
    }


    private OnTextSelectedListener callback;


    public void setMsg(String msg) {
        this.msg = msg;
    }


    //interface
    public interface OnTextSelectedListener {
        public void OnContentSelected(String mymsg);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.callback = (OnTextSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString());
        }
    }

    //set listener
    public void setOnTextSelectedListner(OnTextSelectedListener callback) {
        this.callback = callback;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        btn_getValue = (Button) view.findViewById(R.id.btn_getValue);
        tv_value = (TextView) view.findViewById(R.id.tv_value);

        //passValue1
//        args = getArguments();
//        btn_getValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (args != null) {
//                    String value = args.getString("Key");
//                    tv_value.setText("getMessage" + value);
//                }
//            }
//        });


//        //PassValue2
//        btn_getValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (msg != null) {
//                    tv_value.setText(msg);
//
//                }else {
//                    tv_value.setText("Value is NUll!");
//
//                }
//            }
//        });
        //PassValue3
        tv_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call
                callback.OnContentSelected("PassValue3");
            }
        });
        return view;
    }
}