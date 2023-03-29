package shop.tukoreamyway.back.support.database;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@DatabaseSetup(
        value = {"/testDataSet.xml"},
        type = DatabaseOperation.CLEAN_INSERT)
public @interface UseSampleData {}
