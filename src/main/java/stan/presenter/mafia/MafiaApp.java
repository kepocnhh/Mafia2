package stan.presenter.mafia;

import android.app.Application;

import stan.presenter.mafia.database.SQliteApi;

public class MafiaApp
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SQliteApi.createDb(getApplicationContext());
    }
}