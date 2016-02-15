package stan.presenter.mafia.ui.activities;

import android.database.Cursor;
import android.util.Log;

import stan.presenter.mafia.R;
import stan.presenter.mafia.core.abilities.Ability;
import stan.presenter.mafia.core.abilities.active.changeProperty.Block;
import stan.presenter.mafia.core.abilities.active.changeProperty.HealNight;
import stan.presenter.mafia.core.abilities.active.changeProperty.Kill;
import stan.presenter.mafia.core.action.Action;
import stan.presenter.mafia.core.role.Role;
import stan.presenter.mafia.core.role.Team;
import stan.presenter.mafia.core.role.TypeGroup;
import stan.presenter.mafia.core.role.TypeVisibility;
import stan.presenter.mafia.database.ContentDriver;
import stan.presenter.mafia.database.SQliteApi;
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
//        insertActions();
//        insertAbilities();
        SQliteApi.endTransaction();
        getTypesGroup();
        getTeams();
        getRoles();
        getActions();
        getAbilities();
    }

    public void insertTeams()
    {
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Город", "Мирные жители и роли защищающие их")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Мафия", "Пытаются убить мирных жителей и захватить город")));
        SQliteApi.insertTeam(ContentDriver.getContentValues(
                new Team("Нейтральные", "Сохраняют нейтралитет и пытаются выжить")));
    }

    public void insertTypesGroup()
    {
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getStringRes(R.string.tg_individuals),
                        getStringRes(R.string.tg_individuals_descr))
                        .setVisibleInGroup(false)
                        .setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getStringRes(R.string.tg_organized),
                        getStringRes(R.string.tg_organized_descr))
                        .setVisibleInGroup(true)
                        .setRang(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getStringRes(R.string.tg_clan),
                        getStringRes(R.string.tg_clan_descr))
                        .setVisibleInGroup(true).setRang(true)
                        .setRangShot(false)));
        SQliteApi.insertTypeGroup(ContentDriver.getContentValues(
                new TypeGroup(getStringRes(R.string.tg_sect),
                        getStringRes(R.string.tg_sect_descr))
                        .setVisibleInGroup(false).setRang(true)
                        .setRangShot(false)));
    }

    public void insertRoles()
    {
        Role peace = new Role(getStringRes(R.string.role_peace),
                getStringRes(R.string.role_peace_descr));
        peace.setTypeVisibility(TypeVisibility.peace);
        Team t = getTeam();
        if (t != null)
        {
            peace.setTeam(t);
        }
        SQliteApi.insertRole(ContentDriver.getContentValues(peace));
        Role mafia = new Role(getStringRes(R.string.role_mafia),
                getStringRes(R.string.role_mafia_descr));
        mafia.setTypeVisibility(TypeVisibility.mafia);
        TypeGroup typeGroup = getTypeGroup();
        if (typeGroup != null)
        {
            mafia.setTypeGroup(typeGroup);
        }
        SQliteApi.insertRole(ContentDriver.getContentValues(mafia));
    }

    public void insertActions()
    {
        Action kill = new Action(getStringRes(R.string.action_kill),
                getStringRes(R.string.action_kill_descr));
        SQliteApi.insertAction(ContentDriver.getContentValues(kill));
        Action jail = new Action(getStringRes(R.string.action_jail),
                getStringRes(R.string.action_jail_descr));
        SQliteApi.insertAction(ContentDriver.getContentValues(jail));
    }

    public void insertAbilities()
    {
        SQliteApi.insertAbility(ContentDriver.getContentValues(
                        new Block(getStringRes(R.string.ability_block),
                        getStringRes(R.string.ability_block_descr))));
        SQliteApi.insertAbility(ContentDriver.getContentValues(
                        new Kill(getStringRes(R.string.ability_kill),
                        getStringRes(R.string.ability_kill_descr))));
        SQliteApi.insertAbility(ContentDriver.getContentValues(
                        new HealNight(getStringRes(R.string.ability_healnight),
                        getStringRes(R.string.ability_healnight_descr))));
    }

    public void getTypesGroup()
    {
        Cursor cursor = SQliteApi.getTypesGroup();
        while (cursor.moveToNext())
        {
            TypeGroup tg = ContentDriver.setTypeGroupContentValues(cursor);
            Log.e("getTypesGroup", "TypeGroup - name: " + tg.name + " descr: " + tg.description);
        }
        cursor.close();
    }

    public TypeGroup getTypeGroup()
    {
        Cursor cursor = SQliteApi.getTypesGroup();
        while (cursor.moveToNext())
        {
            return ContentDriver.setTypeGroupContentValues(cursor);
        }
        return null;
    }

    public void getTeams()
    {
        Cursor cursor = SQliteApi.getTeams();
        while (cursor.moveToNext())
        {
            Team t = ContentDriver.setTeamContentValues(cursor);
            Log.e("getTeams", "Team - name: " + t.name + " descr: " + t.description);
        }
        cursor.close();
    }

    public Team getTeam()
    {
        Cursor cursor = SQliteApi.getTeams();
        while (cursor.moveToNext())
        {
            return ContentDriver.setTeamContentValues(cursor);
        }
        return null;
    }

    public void getRoles()
    {
        Cursor cursor = SQliteApi.getRoles();
        while (cursor.moveToNext())
        {
            Role r = ContentDriver.setRoleContentValues(cursor);
            Log.e("getRoles", "Role - name: " + r.name + " descr: " + r.description);
        }
        cursor.close();
    }

    public void getActions()
    {
        Cursor cursor = SQliteApi.getActions();
        while (cursor.moveToNext())
        {
            Action a = ContentDriver.setActionContentValues(cursor);
            Log.e("getActions", "Action - name: " + a.name + " descr: " + a.description);
        }
        cursor.close();
    }

    public void getAbilities()
    {
        Cursor cursor = SQliteApi.getAbilities();
        while (cursor.moveToNext())
        {
            Ability a = ContentDriver.setAbilityContentValues(cursor);
            Log.e("getAbilities", "Ability - name: " + a.name + " descr: " + a.description);
        }
        cursor.close();
    }

    @Override
    public void constructor()
    {
        Constructor.startConstructor(this);
    }
}