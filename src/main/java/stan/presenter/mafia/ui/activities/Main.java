package stan.presenter.mafia.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import stan.presenter.mafia.R;
import stan.presenter.mafia.core.role.Role;
import stan.presenter.mafia.core.role.Team;
import stan.presenter.mafia.core.role.TypeGroup;
import stan.presenter.mafia.core.role.TypeVisibility;
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
        initDB();
    }

    private void initDB()
    {
        SQliteApi.startTransaction();
//        insertTeams();
//        insertTypesGroup();
//        insertRoles();
        SQliteApi.endTransaction();
        getTypesGroup();
        getTeams();
        getRoles();
    }

    public void insertTeams()
    {
        SQliteApi.insertTeam(ContentDriver.getContentValues(new Team("Город", "Мирные жители и роли защищающие их")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(new Team("Мафия", "Пытаются убить мирных жителей и захватить город")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(new Team("Нейтральные", "Сохраняют нейтралитет и пытаются выжить")));
    }

    public void insertTypesGroup()
    {
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(new TypeGroup(getResources().getString(R.string.individuals), getResources().getString(R.string.individuals_descr)).setVisibleInGroup(false).setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(new TypeGroup(getResources().getString(R.string.organized), getResources().getString(R.string.organized_descr)).setVisibleInGroup(true).setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(new TypeGroup(getResources().getString(R.string.clan), getResources().getString(R.string.clan_descr)).setVisibleInGroup(true).setRang(true).setRangShot(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(new TypeGroup(getResources().getString(R.string.sect), getResources().getString(R.string.sect_descr)).setVisibleInGroup(false).setRang(true).setRangShot(false)));
    }

    public void insertRoles()
    {
        Role peace = new Role("Мирный житель", "Ночью не просыпаются. Днём пытаются разоблачить мафию");
        peace.setTypeVisibility(TypeVisibility.peace);
        Team t = getTeam();
        if(t!=null)
        {
            peace.setTeam(t);
        }
        SQliteApi.insertRole(ContentDriver.getContentValues(peace));
        Role mafia = new Role("Мафия", "Убивают городских жителей и пытаются не выдать себя");
        mafia.setTypeVisibility(TypeVisibility.mafia);
        TypeGroup typeGroup = getTypeGroup();
        if(typeGroup!=null)
        {
            mafia.setTypeGroup(typeGroup);
        }
        SQliteApi.insertRole(ContentDriver.getContentValues(mafia));
    }

    public void getTypesGroup()
    {
        Cursor cursor = SQliteApi.getTypesGroup();
        while(cursor.moveToNext())
        {
            TypeGroup tg = ContentDriver.setTypeGroupContentValues(cursor);
            Log.e("getTypesGroup", "TypeGroup - name: " + tg.name + " descr: " + tg.description);
        }
        cursor.close();
    }
    public TypeGroup getTypeGroup()
    {
        Cursor cursor = SQliteApi.getTypesGroup();
        while(cursor.moveToNext())
        {
            return ContentDriver.setTypeGroupContentValues(cursor);
        }
        return null;
    }

    public void getTeams()
    {
        Cursor cursor = SQliteApi.getTeams();
        while(cursor.moveToNext())
        {
            Team t = ContentDriver.setTeamContentValues(cursor);
            Log.e("getTeams", "Team - name: " + t.name + " descr: " + t.description);
        }
        cursor.close();
    }
    public Team getTeam()
    {
        Cursor cursor = SQliteApi.getTeams();
        while(cursor.moveToNext())
        {
            return ContentDriver.setTeamContentValues(cursor);
        }
        return null;
    }

    public void getRoles()
    {
        Cursor cursor = SQliteApi.getRoles();
        while(cursor.moveToNext())
        {
            Role r = ContentDriver.setRoleContentValues(cursor);
            Log.e("getRoles", "Role - name: " + r.name + " descr: " + r.description);
        }
        cursor.close();
    }

    @Override
    public void constructor()
    {
        Constructor.startConstructor(this);
    }
}