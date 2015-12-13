package stan.presenter.mafia.database;

import android.provider.BaseColumns;

public class Tables
{
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    public static class Actions
    {
        public static final String TABLE_NAME = "actionstable";
//        public static final String ABILITIES = "abilities";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text " +
//                ABILITIES + " text " +
                ");";
    }
    public static class Abilities
    {
        public static final String TABLE_NAME = "abilitiestable";
        public static final String MAP = "map";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text, " +
                MAP + " text " +
                ");";
    }

    public static class Roles
    {
        public static final String TABLE_NAME = "rolestable";
        public static final String SIDE = "side";
        public static final String TYPEGROUP_ID = "typegroup_id";
        public static final String TEAM_ID = "team_id";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text, " +
                SIDE + " integer, " +
                TYPEGROUP_ID + " integer, " +
                TEAM_ID + " integer " +
                ");";
    }

    public static class RolesAndActions
    {
        public static final String TABLE_NAME = "rolesandactionstable";
        public static final String ROLE_ID = "role_id";
        public static final String ACTION_ID = "action_id";
//        public static final String SELFIE = "selfie";
//        public static final String VISIBLES = "visibles";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                ROLE_ID + " text, " +
                ACTION_ID + " text " +
//                SELFIE + " integer " +
//                VISIBLES + " integer " +
                ");";
    }
    public static class ActionsAndAbilities
    {
        public static final String TABLE_NAME = "actionsandabilitiestable";
        public static final String ABILITY_ID = "ability_id";
        public static final String ACTION_ID = "action_id";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                ABILITY_ID + " text, " +
                ACTION_ID + " text " +
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
        public static final String TYPESGROUP_ID = "typesgroup_ID";
        public static final String TYPESGROUP_NAME = "typesgroup_NAME";
        public static final String TYPESGROUP_DESCRIPTION = "typesgroup_DESCRIPTION";

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
        public static final String TEAM_ID = "team_ID";
        public static final String TEAM_NAME = "team_NAME";
        public static final String TEAM_DESCRIPTION = "team_DESCRIPTION";

        public static final String CREATE_TABLE="create table if not exists "+
                TABLE_NAME+"("+
                BaseColumns._ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                DESCRIPTION + " text " +
                ");";
    }
}