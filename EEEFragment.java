package aditya.services.adityagate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EEEFragment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eeefragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.eee_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.eee_tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Settings Viewable", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i=new Intent(getApplicationContext(),Settings.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_translate);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.group_EEE_id).setChecked(true);
    }
    
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.group_CSE_id) {
            // Handle the CSE action
            Intent i1 = new Intent(getApplicationContext(), CSEFragment.class);
            startActivity(i1);
            overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            finish();
        } else if (id == R.id.group_IT_id) {
            Intent i2 = new Intent(getApplicationContext(), ITFragment.class);
            startActivity(i2);
            overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            finish();
        } else if (id == R.id.group_EEE_id) {

        } else if (id == R.id.group_ECE_id) {
            Intent i4 = new Intent(getApplicationContext(), ECEFragment.class);
            startActivity(i4);
            overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            finish();
        } else if (id == R.id.group_CIVIL_id) {
            Intent i5 = new Intent(getApplicationContext(), CIVILFragment.class);
            startActivity(i5);
            overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            finish();
        } else if (id == R.id.group_MECH_id) {
            Intent i6 = new Intent(getApplicationContext(), MECHFragment.class);
            startActivity(i6);
            overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.eee_custom_tab, null);
        tabOne.setText("Papers");
        /*tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.qp_icon, 0, 0);*/
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.eee_custom_tab, null);
        tabTwo.setText("Key");
        /*tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.key_icon, 0, 0);*/
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.eee_custom_tab, null);
        tabThree.setText("Materials");
        /*tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.material_icon, 0, 0);*/
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.eee_custom_tab, null);
        tabFour.setText("Resource Person");
        /*tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.reource, 0, 0);*/
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }


    private void setupViewPager(ViewPager viewPager) {
        EEEViewPagerAdapter adapter = new EEEViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new pap_eeeFragment(), "Papers");
        adapter.addFragment(new key_eeeFragment(), "Key");
        adapter.addFragment(new mat_eeeFragment(), "Materials");
        adapter.addFragment(new res_eeeFragment(), "Resource Person");
        viewPager.setAdapter(adapter);
    }
    class EEEViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public EEEViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
