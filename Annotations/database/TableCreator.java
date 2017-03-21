//package annotations.database;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class TableCreator {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("arguments: annotated class");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> specificClass = Class.forName(className);

            DBTable dbTable = specificClass.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotation found in class " + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = specificClass.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<String>();
            for (Field field : specificClass.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue;
                }

                if (annotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) annotations[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                }

                if (annotations[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) annotations[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder(
                    "CREATE TABLE " + tableName + "("
            );
            for (String column : columnDefs) {
                createCommand.append("\n    " + column + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ")";
            System.out.println("Table Creation SQL for " + className + " is: \n " + tableCreate);
        }
    }

    private static String getConstraints(Constraints constraints) {
        String stringConstraints = "";
        if (!constraints.allowNull()) {
            stringConstraints += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            stringConstraints += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            stringConstraints += " UNIQUE";
        }
        return stringConstraints;
    }
}