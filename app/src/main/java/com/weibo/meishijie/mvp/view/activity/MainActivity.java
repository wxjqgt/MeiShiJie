package com.weibo.meishijie.mvp.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.weibo.meishijie.R;
import com.weibo.meishijie.mvp.base.BaseActivity;
import com.weibo.meishijie.mvp.view.fragment.DiscoveryFragment;
import com.weibo.meishijie.mvp.view.fragment.MineFragment;
import com.weibo.meishijie.mvp.view.fragment.StoreFragment;
import com.weibo.meishijie.mvp.view.fragment.TopicFragment;
import com.weibo.meishijie.mvp.view.fragment.recommend.RecommendFragment;

/**
 * Created by Administrator on 2017/12/19.
 */

public class MainActivity extends BaseActivity {

    private FragmentManager fm;
    private Fragment lastFragment;
    private RadioGroup rb_bottom_navbar;

    @Override
    protected void findView() {
        rb_bottom_navbar = findViewById(R.id.bottom_navbar);
    }

    @Override
    protected void listener() {
        fm = getSupportFragmentManager();
        RxRadioGroup.checkedChanges(rb_bottom_navbar)
                .compose(this.<Integer>bindToLifecycle())
                .subscribe(integer -> {
                    String tag = RecommendFragment.TAG;
                    Fragment fragment = fm.findFragmentByTag(tag);
                    int id = integer.intValue();
                    rb_bottom_navbar.check(id);
                    FragmentTransaction ft = fm.beginTransaction();
                    if (lastFragment != null) {
                        ft.hide(lastFragment);
                    }
                    switch (id) {
                        case R.id.rb_recommend:
                            if (fragment != null) {
                                ft.show(fragment);
                            } else {
                                fragment = RecommendFragment.newInstance();
                                ft.add(R.id.fragment, fragment, tag);
                            }
                            break;
                        case R.id.rb_discovery:
                            tag = DiscoveryFragment.TAG;
                            fragment = fm.findFragmentByTag(tag);
                            if (fragment != null) {
                                ft.show(fragment);
                            } else {
                                fragment = DiscoveryFragment.newInstance();
                                ft.add(R.id.fragment, fragment, tag);
                            }
                            break;
                        case R.id.rb_store:
                            tag = StoreFragment.TAG;
                            fragment = fm.findFragmentByTag(tag);
                            if (fragment != null) {
                                ft.show(fragment);
                            } else {
                                fragment = StoreFragment.newInstance();
                                ft.add(R.id.fragment, fragment, tag);
                            }
                            break;
                        case R.id.rb_topic:
                            tag = TopicFragment.TAG;
                            fragment = fm.findFragmentByTag(tag);
                            if (fragment != null) {
                                ft.show(fragment);
                            } else {
                                fragment = TopicFragment.newInstance();
                                ft.add(R.id.fragment, fragment, tag);
                            }
                            break;
                        case R.id.rb_mine:
                            tag = MineFragment.TAG;
                            fragment = fm.findFragmentByTag(tag);
                            if (fragment != null) {
                                ft.show(fragment);
                            } else {
                                fragment = MineFragment.newInstance();
                                ft.add(R.id.fragment, fragment, tag);
                            }
                            break;
                        default:
                            break;
                    }
                    ft.commit();
                    lastFragment = fragment;
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
