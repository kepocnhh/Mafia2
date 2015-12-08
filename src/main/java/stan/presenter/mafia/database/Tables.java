package stan.presenter.mafia.database;

import android.provider.BaseColumns;

public class Tables
{
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    public static class Actions
    {
        public static final String TABLE_NAME = "actionstable";
        public static final String ABILITIES = "abilities";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text, " +
                ABILITIES + " text " +
                ");";
    }

    public static class Roles
    {
        public static final String TABLE_NAME = "rolestable";
        public static final String SIDE = "side";
        public static final String TYPEGROUP = "typegroup";
        public static final String TEAM = "team";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text, " +
                SIDE + " integer " +
                TYPEGROUP + " text " +
                TEAM + " text " +
                ");";
    }

    public static class RolesAndActions
    {
        public static final String TABLE_NAME = "rolesandactionstable";
        public static final String ROLE_ID = "role_id";
        public static final String ACTION_ID = "action_id";
        public static final String SELFIE = "selfie";
        public static final String VISIBLES = "visibles";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                ROLE_ID + " text " +
                ACTION_ID + " text " +
                SELFIE + " integer " +
                VISIBLES + " integer " +
                ");";
    }

    public static class VisibleRoles
    {
        public static final String TABLE_NAME = "visiblerolestable";
        public static final String ROLE_ID = "role_id";
        public static final String ROLE_WHOM = "role_whom";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                ROLE_ID + " text " +
                ROLE_WHOM + " text " +
                ");";
    }

    public static class TypesGroup
    {
        public static final String TABLE_NAME = "typesgrouptable";
        public static final String VISIBLE_IN_GROUP = "visible_in_group";
        public static final String RANG = "rang";
        public static final String RANG_SHOT = "rang_shot";
//        public static final String VISIBLE_RANG = "visible_rang";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text, " +
                VISIBLE_IN_GROUP + " integer, " +
                RANG + " integer, " +
//                VISIBLE_RANG + " integer, " +
                RANG_SHOT + " integer " +
                ");";
    }

    public static class Teams
    {
        public static final String TABLE_NAME = "teamstable";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text " +
                ");";
    }
}