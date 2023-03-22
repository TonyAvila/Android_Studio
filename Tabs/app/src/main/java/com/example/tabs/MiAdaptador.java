package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiAdaptador  extends FragmentStateAdapter {

    public MiAdaptador(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                BlankFragment_suma blankFragment_suma = new BlankFragment_suma();
                return blankFragment_suma;
            case 1:
                BlankFragment_toast blankFragment_toast = new BlankFragment_toast();
                return blankFragment_toast;
            case 2:
                BlankFragment_alert blankFragment_alert = new BlankFragment_alert();
                return blankFragment_alert;
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() { return 3;}
    public CharSequence getTabTitle(int position){
        switch (position) {
            case 0: return "CALCULADORA";
            case 1: return "TOAST";
            case 2: return "ALERT";
            default: return "PRUEBA"; }}
}
