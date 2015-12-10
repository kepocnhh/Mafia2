package stan.presenter.mafia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQliteApi
{
    public static DatabaseHelper dbHelper;
    public static volatile SQLiteDatabase sdb;
    public static String DB_NAME = "mafia";
    public static int DB_VERSION = 1512101602;

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
        //TODO create query for get teams, typegroup
        Cursor main = sdb.query(Tables.Roles.TABLE_NAME, null, null, null, null, null, null);
        return main;
    }

    // CLEAR DB TABLES
    /* ************************************************************************ */
    public static void clearDB(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.Actions.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Roles.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.RolesAndActions.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.VisibleRoles.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.TypesGroup.TABLE_NAME);
        db.execSQL("drop table if exists " + Tables.Teams.TABLE_NAME);
    }

    // CREATE DB TABLES
    /* ************************************************************************ */
    public static void createDBTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.Actions.CREATE_TABLE);
        db.execSQL(Tables.Roles.CREATE_TABLE);
        db.execSQL(Tables.RolesAndActions.CREATE_TABLE);
        db.execSQL(Tables.VisibleRoles.CREATE_TABLE);
        db.execSQL(Tables.TypesGroup.CREATE_TABLE);
        db.execSQL(Tables.Teams.CREATE_TABLE);
    }
}