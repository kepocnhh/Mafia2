package stan.presenter.mafia.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import stan.presenter.mafia.R;
import stan.presenter.mafia.core.role.Team;
import stan.presenter.mafia.core.role.TypeGroup;
import stan.presenter.mafia.database.ContentDriver;
import stan.presenter.mafia.database.SQliteApi;
import stan.presenter.mafia.database.Tables;
import stan.presenter.mafia.listeners.fragments.main.IMainFragmentClick;
import stan.presenter.mafia.ui.fragments.main.MainFragment;

public class Main
        extends StanActivity
        implements IMainFragmentClick
{
    //_______________VIEWS

    //_______________FRAGMENTS

    //_______________FIELDS

    public Main()
    {
        super(R.layout.main, R.id.main_frame);
    }

    @Override
    protected void initViews()
    {
    }

    @Override
    protected void init()
    {
        addFragment(MainFragment.newInstance());
//        initDB();
    }

    private void initDB()
    {
        SQliteApi.startTransaction();
        insertTeam();
        insertTypeGroup();
        SQliteApi.endTransaction();
        getTypesGroup();
        getTeams();
    }
    public void insertTeam()
    {
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Город", "Мирные жтели и роли защищающие их")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Мафия", "Пытаются убить мирных жителей и захватить город")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Нейтральные", "Сохраняют нейтралитет и пытаются выжить")));
    }
    public void insertTypeGroup()
    {
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getResources().getString(R.string.individuals),
                        getResources().getString(R.string.individuals_descr))
                        .setVisibleInGroup(false)
                        .setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getResources().getString(R.string.organized),
                        getResources().getString(R.string.organized_descr))
                        .setVisibleInGroup(true)
                        .setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getResources().getString(R.string.clan),
                        getResources().getString(R.string.clan_descr))
                        .setVisibleInGroup(true)
                        .setRang(true)
                        .setRangShot(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getResources().getString(R.string.sect),
                        getResources().getString(R.string.sect_descr))
                        .setVisibleInGroup(false)
                        .setRang(true)
                        .setRangShot(false)));
    }
    public void getTypesGroup()
    {
        Cursor cursor = SQliteApi.getTypesGroup();
//        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
            TypeGroup tg = ContentDriver.setTypeGroupContentValues(cursor);
            Log.e("getTypesGroup", "TypeGroup - name: " + tg.name + " descr: " + tg.description);
        }
        cursor.close();
    }
    public void getTeams()
    {
        Cursor cursor = SQliteApi.getTeams();
//        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
            Team t = ContentDriver.setTeamContentValues(cursor);
            Log.e("getTeams", "Team - name: " + t.name + " descr: " + t.description);
        }
        cursor.close();
    }

    @Override
    public void constructor()
    {
        Constructor.startConstructor(this);
    }
}