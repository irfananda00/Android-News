package com.irfanandarafifsatrio.news.preference;

import android.content.Context;

import com.irfanandarafifsatrio.news.dao.SourceDao;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public class SourcePref {
    public static final String PREFS_NAME = "Src_prefs";
    public static final String PREFS_VAL = "Src_value";

    public static void save(SourceDao.SourcesBean data, Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.putObject(PREFS_VAL, data);
        complexPreferences.commit();
    }

    public static SourceDao.SourcesBean load(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        return complexPreferences.getObject(PREFS_VAL, SourceDao.SourcesBean.class);
    }

    public static String getJSON(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        return complexPreferences.getJSON(PREFS_VAL);
    }

    public static void clearAll(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }
}
