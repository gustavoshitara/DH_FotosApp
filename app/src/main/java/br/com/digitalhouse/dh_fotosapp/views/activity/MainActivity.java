package br.com.digitalhouse.dh_fotosapp.views.activity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import br.com.digitalhouse.dh_fotosapp.R;
import br.com.digitalhouse.dh_fotosapp.adapter.FotosAdapter;
import br.com.digitalhouse.dh_fotosapp.model.Fotos;
import br.com.digitalhouse.dh_fotosapp.views.fragments.FotoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fotos> listaFotos = new ArrayList<>();

        listaFotos.add(new Fotos("EUA",
                FotoFragment.novaInstancia(R.drawable.eua, "Estados Unidos")));
        listaFotos.add(new Fotos("França",
                FotoFragment.novaInstancia(R.drawable.franca, "França")));
        listaFotos.add(new Fotos("Itália",
                FotoFragment.novaInstancia(R.drawable.italia, "Itália")));
        listaFotos.add(new Fotos("Brasil",
                FotoFragment.novaInstancia(R.drawable.rio, "Brasil")));
        listaFotos.add(new Fotos("Grécia",
                FotoFragment.novaInstancia(R.drawable.grecia, "Grécia")));

        FotosAdapter adapter = new FotosAdapter(getSupportFragmentManager(), listaFotos);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(listaFotos.size());

        tabLayout.setupWithViewPager(viewPager);
    }

}
