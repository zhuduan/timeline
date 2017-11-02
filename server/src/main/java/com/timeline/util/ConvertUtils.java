package com.timeline.util;

import com.timeline.common.NotConvert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Convert the source object to target object
 *
 * @author Haifeng.Zhu
 *         created at 11/1/17
 */
public class ConvertUtils {
    
    /***
     * 
     * generator a new targetType with values in dataSource
     * notice :
     *      1. field only in target will be ignore
     *      2. same name but different field type will be ignore
     * 
     * @param dataSource
     * @param targetType
     * @param <T> dataSource type
     * @param <V> target type
     * @return target object or null
     * @throws IllegalAccessException,InstantiationException 
     */
    public static <T extends Object, V extends Object> V convert(T dataSource, Class<V> targetType) {
       try {
           Field fields[] = targetType.getDeclaredFields();
           V targetObject = targetType.newInstance();

           for (Field targetField : fields) {
               if (isNotConvert(targetField)) {
                   continue;
               }

               Field sourceField;
               try {
                   sourceField = dataSource.getClass().getDeclaredField(targetField.getName());
               } catch (NoSuchFieldException exp) {
                   // if the field not declare in source, just ignore it for useless field here
                   continue;
               }

               Class<?> targetFieldType = targetField.getType();
               Class<?> sourceFieldType = sourceField.getType();
               if (!targetFieldType.equals(sourceFieldType)) {
                   // if type not same, just ignore it for consider as useless field here
                   continue;
               }

               targetField.setAccessible(true);
               sourceField.setAccessible(true);
               targetField.set(targetObject, sourceField.get(dataSource));
           }
           return targetObject;
       } catch (Exception exp){
           // TODO: some log here - should not happen
           return null;
       }
    }
    
    private static boolean isNotConvert(Field field){
        Annotation annotations[] = field.getAnnotations();
        for ( Annotation annotation : annotations ){
            if ( annotation instanceof NotConvert){
                return true;
            }
        }
        return false;
    }

    /***
     * 
     * generator a list, which contains new targetType with values in dataSource
     * Notice: @see(this.convert(T dataSource, Class<V> targetType))
     * 
     * @param dataSources
     * @param targetType
     * @param <T>
     * @param <V>
     * @return target object list or empty list if nothing converted
     * @throws IllegalAccessException,InstantiationException
     */
    public static <T extends Object, V extends Object> List<V> convert(List<T> dataSources, Class<V> targetType){
        List<V> resList = new ArrayList<>();
        dataSources.forEach( (dataSource) -> {
            V targetObject = convert(dataSource, targetType);
            if ( targetObject!=null ){
                resList.add(targetObject);
            }
        });
        return resList;
    }
}
