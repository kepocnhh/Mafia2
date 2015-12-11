package stan.presenter.mafia.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONArray;

import java.util.Date;

import stan.presenter.mafia.core.Mafia;
import stan.presenter.mafia.core.MafiaDescription;
import stan.presenter.mafia.core.action.Action;
import stan.presenter.mafia.core.role.Role;
import stan.presenter.mafia.core.role.Team;
import stan.presenter.mafia.core.role.TypeGroup;

public class ContentDriver
{
    //__________________________________GET_CONTENT_VALUES
    static private ContentValues getContentValues(Mafia m)
    {
        ContentValues cv = new ContentValues();
//        if (m.UID == null)
//        {
//            m.UID = getUI();
//        }
//        cv.put(BaseColumns._ID, m.UID);
        cv.put(Tables.NAME, m.name);
        return cv;
    }

//    static private String getUI()
//    {
//        return new Date().getTime() + "";
//    }

    static private ContentValues getContentValues(MafiaDescription m)
    {
        ContentValues cv = getContentValues((Mafia) m);
        cv.put(Tables.DESCRIPTION, m.description);
        return cv;
    }

    static public ContentValues getContentValues(Action a)
    {
        ContentValues cv = getContentValues((stan.presenter.mafia.core.MafiaDescription) a);
        JSONArray abilitieArray = new JSONArray();
        for (int i = 0; i < a.abilities.length; i++)
        {
            JSONArray abilitieMap = new JSONArray();
            int[] map = a.abilities[i].getMap();
            for (int j = 0; j < map.length; j++)
            {
                abilitieMap.put(map[j]);
            }
            abilitieArray.put(abilitieMap);
        }
        String abilities = abilitieArray.toString();
        cv.put(Tables.Actions.ABILITIES, abilities);
        return cv;
    }

    static public ContentValues getContentValues(Role r)
    {
        ContentValues cv = getContentValues((stan.presenter.mafia.core.MafiaDescription) r);
        cv.put(Tables.Roles.SIDE, r.typeVisibility.ordinal());
//        cv.put(Tables.Roles.TYPEGROUP, r.typeGroup.UID);
        if(r.team != null)
        {
            cv.put(Tables.Roles.TEAM_ID, r.team.UID);
        }
        if(r.typeGroup != null)
        {
            cv.put(Tables.Roles.TYPEGROUP_ID, r.typeGroup.UID);
        }
        return cv;
    }

    static public ContentValues getContentValues(TypeGroup t)
    {
        ContentValues cv = getContentValues((stan.presenter.mafia.core.MafiaDescription) t);
        if (t.visibleInGroup)
        {
            cv.put(Tables.TypesGroup.VISIBLE_IN_GROUP, 1);
        }
        else
        {
            cv.put(Tables.TypesGroup.VISIBLE_IN_GROUP, 0);
        }
        if (t.rang)
        {
            cv.put(Tables.TypesGroup.RANG, 1);
        }
        else
        {
            cv.put(Tables.TypesGroup.RANG, 0);
            return cv;
        }
        if (t.rangShot)
        {
            cv.put(Tables.TypesGroup.RANG_SHOT, 1);
        }
        else
        {
            cv.put(Tables.TypesGroup.RANG_SHOT, 0);
        }
//        if(t.visibleRang)
//        {
//            cv.put(Tables.TypesGroup.VISIBLE_RANG, 1);
//        }
//        else
//        {
//            cv.put(Tables.TypesGroup.VISIBLE_RANG, 0);
//        }
        return cv;
    }

    static public ContentValues getContentValues(Team t)
    {
        ContentValues cv = getContentValues((stan.presenter.mafia.core.MafiaDescription) t);
        return cv;
    }

    static public TypeGroup setTypeGroupContentValues(Cursor route)
    {
        return setTypeGroupContentValues(route, Tables.NAME, Tables.DESCRIPTION, BaseColumns._ID);
    }
    static private TypeGroup setTypeGroupContentValues(Cursor route, String name, String descr, String id)
    {
        TypeGroup t = new TypeGroup(route.getString(route.getColumnIndex(name)),
                route.getString(route.getColumnIndex(descr)));
        t.UID = route.getInt(route.getColumnIndex(id));
        int i = route.getInt(route.getColumnIndex(Tables.TypesGroup.VISIBLE_IN_GROUP));
        t.setVisibleInGroup(i == 1);
        i = route.getInt(route.getColumnIndex(Tables.TypesGroup.RANG));
        if (i == 1)
        {
            t.setRang(true);
        }
        else
        {
            t.setRang(false);
            return t;
        }
        i = route.getInt(route.getColumnIndex(Tables.TypesGroup.RANG_SHOT));
        t.setRangShot(i == 1);
        return t;
    }

    static public Team setTeamContentValues(Cursor route)
    {
        return setTeamContentValues(route, Tables.NAME, Tables.DESCRIPTION, BaseColumns._ID);
    }
    static private Team setTeamContentValues(Cursor route, String name, String descr, String id)
    {
        Team t = new Team(route.getString(route.getColumnIndex(name)),
                route.getString(route.getColumnIndex(descr)));
        t.UID = route.getInt(route.getColumnIndex(id));
        return t;
    }
    static public Role setRoleContentValues(Cursor route)
    {
        Role r = new Role(route.getString(route.getColumnIndex(Tables.NAME)),
                route.getString(route.getColumnIndex(Tables.DESCRIPTION)));
        r.UID = route.getInt(route.getColumnIndex(BaseColumns._ID));
        if(route.getInt(route.getColumnIndex(Tables.Teams.TEAM_ID))>0)
        {
            r.team = setTeamContentValues(route, Tables.Teams.TEAM_NAME, Tables.Teams.TEAM_DESCRIPTION, Tables.Teams.TEAM_ID);
        }
        if(route.getInt(route.getColumnIndex(Tables.TypesGroup.TYPESGROUP_ID))>0)
        {
            r.typeGroup = setTypeGroupContentValues(route, Tables.TypesGroup.TYPESGROUP_NAME, Tables.TypesGroup.TYPESGROUP_DESCRIPTION, Tables.TypesGroup.TYPESGROUP_ID);
        }
        return r;
    }
}