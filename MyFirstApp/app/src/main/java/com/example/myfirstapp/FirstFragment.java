package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

//    private FragmentFirstBinding binding;
    TextView showCountTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int currentCount=Integer.parseInt(showCountTextView.getText().toString());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        /**
         * 使用该findViewById()方法并将所需视图的 id 作为参数，然后在该视图上设置单击侦听器。
         * 在单击侦听器的主体中，使用一个操作（在本例中用于导航到另一个片段）并导航到那里。
         */
        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast myToast=Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                countMe(v);
            }
        });

    }

    private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();
        //        将值转换为数字并递增
        // Convert value to a number and increment it
        Integer count=0;
        try {
            count = Integer.parseInt(countString);
        }catch (Exception e) {
            count=0;
        }
        ++count;
        // TextView通过以编程方式设置text的属性来显示 中的新值
        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

}