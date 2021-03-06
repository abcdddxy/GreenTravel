package com.example.zero.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by jojo on 2017/9/13.
 */

public class SaleFragmentController {
    /**
     * 容器
     */
    private int containerId;
    /**
     * SaleFragment管理
     */
    private FragmentManager fm;
    /**
     * SaleFragment列表
     */
    private ArrayList<Fragment> fragments;

    /**
     * SaleFragment控制器类
     */
    private static SaleFragmentController controller;

    public static SaleFragmentController getInstance(SaleFragment parentFragment, int containerId) {
        if (controller == null) {
            controller = new SaleFragmentController(parentFragment, containerId);
        }
        return controller;
    }

    private SaleFragmentController(Fragment fragment, int containerId) {
        this.containerId = containerId;
        fm = fragment.getChildFragmentManager();
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new SaleHotFragment());
        fragments.add(new SaleMyFragment());

        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commit();
    }

    /**
     * 显示Fragment
     *
     * @param position Fragment位置
     */
    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }

    /**
     * 隐藏Fragment
     */
    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
