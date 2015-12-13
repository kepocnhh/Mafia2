package stan.presenter.mafia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class SQliteApi
{
    public static DatabaseHelper dbHelper;
    public static volatile SQLiteDatabase sdb;
    public static String DB_NAME = "mafia";
    public static int DB_VERSION = 1512130256;

    public static void createDb(Context context)
    {
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
        sdb = dbHelper.getWritableDatabase();
        createDBTables(sdb);
    }

    public static void startTransaction()
    {
        sdb.beginTransaction();
    }

    public static void endTransaction()
    {
        sdb.setTransactionSuccessful();
        sdb.endTransaction();
    }

    // INSERT
    /* ************************************************************************ */
    public static long insertAction(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.Actions.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertAbility(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.Abilities.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertRole(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.Roles.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertTypeGroup(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.TypesGroup.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public static long insertTeam(ContentValues content)
    {
        return sdb.insertWithOnConflict(Tables.Teams.TABLE_NAME, null, content, SQLiteDatabase.CONFLICT_REPLACE);
    }

    // GET ALL
    /* ************************************************************************ */
    public static Cursor getActions()
    {
        Cursor main = sdb.query(Tables.Actions.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getAbilities()
    {
        Cursor main = sdb.query(Tables.Abilities.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getTypesGroup()
    {
        Cursor main = sdb.query(Tables.TypesGroup.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getTeams()
    {
        Cursor main = sdb.query(Tables.Teams.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }
    public static Cursor getRoles()
    {
//        Cursor cursor = sdb.rawQuery(
//                "SELECT *"
//                        + "FROM " + Tables.PostSimple_TABLE_NAME + " "
//                        + "JOIN " + Tables.PostsAndCategory_TABLE_NAME + " "
//                        + "ON " + Tables.PostSimple_TABLE_NAME + "." + BaseColumns._ID + "=" + Tables.PostsAndCategory_TABLE_NAME + "." + Tables.PostsAndCategory_post_id_COLUMN + " "
//                        + "JOIN " + Tables.Category_TABLE_NAME + " "
//                        + "ON " + Tables.Category_TABLE_NAME + "." + BaseColumns._ID + "=" + Tables.PostsAndCategory_TABLE_NAME + "." + Tables.PostsAndCategory_category_id_COLUMN + " "
//                        + "WHERE " + Tables.Category_TABLE_NAME + "." + BaseColumns._ID + "=" + category_id + " "
//                        + "ORDER BY " + Tables.PostSimple_date_COLUMN + " DESC" + " "
//                        + "LIMIT " + page*10 + "; "
//                , new String[]{});
//        Cursor cursor = sdb.rawQuery(
//                "SELECT * "
//                        + "FROM " + Tables.SESSIONS_TABLE_NAME + " "
//                        + "LEFT JOIN " + Tables.MOVIES_TABLE_NAME + " "
//                        + "ON " + Tables.SESSIONS_TABLE_NAME + "." +Tables.SESSIONS_MOVIE_ID_COLUMN + " = " + Tables.MOVIES_TABLE_NAME + "." + BaseColumns._ID + " "
//                        + "WHERE " + Tables.SESSIONS_DATE_COLUMN + "=\"" + date + "\" "
//                        + "GROUP BY " + Tables.SESSIONS_MOVIE_ID_COLUMN + " "
//                , new String[]{});
//        Cursor main = sdb.query(Tables.Roles.TABLE_NAME, null, null, null, null, null, null);
        Cursor cursor = sdb.rawQuery(
                "SELECT "
//                        + Tables.Roles.TABLE_NAME + "." + BaseColumns._ID + " AS ID," + Tables.Teams.TABLE_NAME + "." + BaseColumns._ID + " AS team_ID "
                        + Tables.Teams.TABLE_NAME + "." + BaseColumns._ID + " AS " + Tables.Teams.TEAM_ID + ", "
                        + Tables.Teams.TABLE_NAME + "." + Tables.NAME + " AS " + Tables.Teams.TEAM_NAME + ", "
                        + Tables.Teams.TABLE_NAME + "." + Tables.DESCRIPTION + " AS " + Tables.Teams.TEAM_DESCRIPTION + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + BaseColumns._ID + " AS " + Tables.TypesGroup.TYPESGROUP_ID + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + Tables.NAME + " AS " + Tables.TypesGroup.TYPESGROUP_NAME + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + Tables.DESCRIPTION + " AS " + Tables.TypesGroup.TYPESGROUP_DESCRIPTION + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + Tables.TypesGroup.VISIBLE_IN_GROUP + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + Tables.TypesGroup.RANG + ", "
                        + Tables.TypesGroup.TABLE_NAME + "." + Tables.TypesGroup.RANG_SHOT + ", "
                        + Tables.Roles.TABLE_NAME + "." + BaseColumns._ID + ", "
                        + Tables.Roles.TABLE_NAME + "." + Tables.NAME + ", "
                        + Tables.Roles.TABLE_NAME + "." + Tables.DESCRIPTION + ", "
                        + Tables.Roles.TABLE_NAME + "." + Tables.Roles.TEAM_ID + ", "
                        + Tables.Roles.TABLE_NAME + "." + Tables.Roles.SIDE + " "
                        + "FROM " + Tables.Roles.TABLE_NAME + " "
                        + "LEFT JOIN " + Tables.Teams.TABLE_NAME + " "
                        + "ON " + Tables.Roles.TABLE_NAME + "." +Tables.Roles.TEAM_ID + " = " + Tables.Teams.TABLE_NAME + "." + BaseColumns._ID + " "
                        + "LEFT JOIN " + Tables.TypesGroup.TABLE_NAME + " "
                        + "ON " + Tables.Roles.TABLE_NAME + "." +Tables.Roles.TYPEGROUP_ID + " = " + Tables.TypesGroup.TABLE_NAME + "." + BaseColumns._ID + " "
                , new String[]{});
        return cursor;
    }

    // CLEAR DB TABLES
    /* ************************************************************************ */
    public static void clearDB(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.Actions.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Abilities.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Roles.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.RolesAndActions.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.ActionsAndAbilities.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.VisibleRoles.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.TypesGroup.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Teams.TABLE_NAME);
    }

    // CREATE DB TABLES
    /* ************************************************************************ */
    public static void createDBTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.Actions.CREATE_TABLE);
        db.execSQL(Tables.Abilities.CREATE_TABLE);
        db.execSQL(Tables.Roles.CREATE_TABLE);
        db.execSQL(Tables.RolesAndActions.CREATE_TABLE);
        db.execSQL(Tables.ActionsAndAbilities.CREATE_TABLE);
        db.execSQL(Tables.VisibleRoles.CREATE_TABLE);
        db.execSQL(Tables.TypesGroup.CREATE_TABLE);
        db.execSQL(Tables.Teams.CREATE_TABLE);
    }
}