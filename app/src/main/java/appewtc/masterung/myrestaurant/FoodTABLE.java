package appewtc.masterung.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 7/23/15 AD.
 */
public class FoodTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeDatabase, readDatabase;
    public static final String FOOD_TABLE = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";

    public FoodTABLE(Context context) {

        //Connected Table
        objMyOpenHelper = new MyOpenHelper(context);
        writeDatabase = objMyOpenHelper.getWritableDatabase();
        readDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    //Read All Source
    public String[] readAllSource() {

        String[] strSource = null;
        Cursor objCursor = readDatabase.query(FOOD_TABLE,
                new String[] {COLUMN_ID_FOOD, COLUMN_SOURCE},
                null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strSource = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strSource[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SOURCE));
                objCursor.moveToNext();
            }
        }

        objCursor.close();
        return strSource;
    }

    //Read All Price
    public String[] readAllPrice() {

        String strPrice[] = null;
        Cursor objCursor = readDatabase.query(FOOD_TABLE,
                new String[]{COLUMN_ID_FOOD, COLUMN_PRICE},
                null, null, null, null, null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strPrice = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {
                strPrice[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PRICE));
                objCursor.moveToNext();
            }
        }
        objCursor.close();
        return strPrice;
    }

    //Read All Food
    public String[] readAllFood() {

        String[] strFood = null;

        Cursor objCursor = readDatabase.query(FOOD_TABLE,
                new String[]{COLUMN_ID_FOOD, COLUMN_FOOD},
                null, null, null, null, null);
        if (objCursor != null) {

            objCursor.moveToFirst();
            strFood = new String[objCursor.getCount()];
            for (int i = 0; i < objCursor.getCount(); i++) {

                strFood[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOOD));
                objCursor.moveToNext();

            }   //for

        }   // if
        objCursor.close();
        return strFood;
    }

    public long addValueFood(String strFood, String strSource, String strPrice) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_FOOD, strFood);
        objContentValues.put(COLUMN_SOURCE, strSource);
        objContentValues.put(COLUMN_PRICE, strPrice);

        return writeDatabase.insert(FOOD_TABLE, null, objContentValues);
    }

}   // Main Class
