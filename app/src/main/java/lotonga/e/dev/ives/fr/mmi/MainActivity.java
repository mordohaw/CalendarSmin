package lotonga.e.dev.ives.fr.mmi;

import android.app.Activity;
import android.os.Bundle;

import lotonga.e.dev.ives.fr.mmi.modeles.Main;

public class MainActivity extends GeneralActivity
{

    Main main;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = new Main(getData());

    }
}
